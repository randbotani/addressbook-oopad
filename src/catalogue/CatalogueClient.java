package catalogue;

import java.io.*;
import java.net.Socket;

public class CatalogueClient {

    private String host;
    private int port;
    private Socket socket;



    InputStream inputStream = socket.getInputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader reader = new BufferedReader(inputStreamReader);

    OutputStream outputStream = socket.getOutputStream();
    PrintWriter writer = new PrintWriter(outputStream);

    public CatalogueClient(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }


    public void connect() throws IOException {
        this.socket = new Socket(host, port);
    }

    public String waitForRespons() {
        String centralCatalog = null;

        try {

            for ( centralCatalog = reader.readLine(); centralCatalog != null; centralCatalog = reader.readLine()) {
                centralCatalog += centralCatalog +"/";

            }
            reader.close();
            writer.close();

        } catch (Exception e) {
            System.out.println("we can't load centralCatalog because there is no connection with server");
        }

        return centralCatalog;
    }

    public void sendRequest(String request){

        writer.println(request);
        writer.flush();
    }

    public void disconnect(){
        writer.println("exit");
        writer.flush();
    }
}
