package catalogue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    CatalogueClient catalogueClient;

    AtomicRemoteCatalogueProxy (String host , int port) throws IOException {
        catalogueClient = new CatalogueClient(host, port);
    }

    public List<String> getContacts() {

        List contacts = null;

        try {
            catalogueClient.connect();
            catalogueClient.sendRequest("getall");
            catalogueClient.waitForRespons();
            contacts = Arrays.asList(catalogueClient.waitForRespons().split("/"));
            catalogueClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
