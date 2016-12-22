package se.carl.catalogue;

import se.carl.tools.Console;


import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;


class CatalogueClient {
    private static final Logger log = Logger.getLogger(CatalogueClient.class.getName());

    private String host;
    private int port;
    private Socket socket;
    private OutputStream outputStream;
    private PrintWriter writer;


    public CatalogueClient(String host, int port){
        log.info("Setting CLIENT host and port.");
        this.host = host;
        this.port = port;
    }

    public void connect(){
        log.info("Connecting to server...");
        try{
            socket = new Socket(host, port);
            log.info("Connected!");
        }catch (IOException e){
            //e.printStackTrace();
            String info = "Not connected to Central Catalogue!";
            log.severe(info);
            Console consolePrinter = new Console();
            consolePrinter.print(info);

        }
    }

    public void sendRequest(String request){
        log.info("Sending a request.");
        try {
            outputStream = socket.getOutputStream();
            writer = new PrintWriter(outputStream);
            writer.println(request);
            writer.flush();
        }catch (IOException e){
            log.severe("Error: " + e);
            e.printStackTrace();
        }
    }

    public String waitForResponse(){
        log.info("Waiting for response...");
        String response = "";
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                if(line.equals("")) {
                    break;
                }
                response += line + "\n";

            }
            log.info("Returning response...");
            return response;
        }catch (IOException e){
            log.severe("Error " + e);
            e.printStackTrace();
        } return null;
    }

    public void disconnect(){
        log.info("Disconnecting...");
        try {
            outputStream = socket.getOutputStream();
            writer.println("exit");
            writer.flush();
            socket.close();
            outputStream.close();
            writer.close();
        }catch (IOException e){
            log.severe("Error " + e);
            e.printStackTrace();
        }
    }
}