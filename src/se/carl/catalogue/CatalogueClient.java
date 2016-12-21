package se.carl.catalogue;

import java.io.*;
import java.net.Socket;

class CatalogueClient {

    private String host;
    private int port;
    private Socket socket;
    private OutputStream outputStream;
    private PrintWriter writer;


    public CatalogueClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void connect(){
        try{
            socket = new Socket(host, port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendRequest(String request){
        try {
            outputStream = socket.getOutputStream();
            writer = new PrintWriter(outputStream);
            writer.println(request);
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String waitForResponse(){
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
            return response;
        }catch (IOException e){
            e.printStackTrace();
        } return null;
    }

    public void disconnect(){
        try {
            outputStream = socket.getOutputStream();
            writer.println("exit");
            writer.flush();
            socket.close();
            outputStream.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}