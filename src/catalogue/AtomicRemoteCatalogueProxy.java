package catalogue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    CatalogueClient catalogueClient= new CatalogueClient("localhost",16161);

    AtomicRemoteCatalogueProxy (String host , int port) throws IOException {

    }

    //catalogueClient.waitForRespons().split("/")



    public ArrayList<String> getContacts() {
        ArrayList<String> temp = new ArrayList<>();

        try {
            catalogueClient.connect();
            catalogueClient.sendRequest("getall");
            catalogueClient.waitForRespons();

            catalogueClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
