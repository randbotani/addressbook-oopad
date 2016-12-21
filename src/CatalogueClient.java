import java.io.*;
import java.net.Socket;

public class CatalogueClient {

    private String host;
    private int port;
    private Socket socket;

    RemoteRegistry remoteRegistry = new RemoteRegistry();


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

        try {

            for (String centralCatalog = reader.readLine(); centralCatalog != null; centralCatalog = reader.readLine()) {
                String[] temp = centralCatalog.trim().split("\\s+");
                remoteRegistry.add(temp[0], temp[1], temp[2], temp[3]);
            }

            reader.close();
            writer.close();

        } catch (Exception e) {
            System.out.println("we can't load centralCatalog because there is no connection with server");
        }

        return "";
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
