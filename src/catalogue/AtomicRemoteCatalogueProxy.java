package catalogue;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.Arrays;
>>>>>>> 98f2d3e1f78023da40e9c53e7c6ea131797fae4a
import java.util.List;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

<<<<<<< HEAD
    CatalogueClient catalogueClient= new CatalogueClient("localhost",16161);

    AtomicRemoteCatalogueProxy (String host , int port) throws IOException {
=======
    CatalogueClient catalogueClient;
>>>>>>> 98f2d3e1f78023da40e9c53e7c6ea131797fae4a

    AtomicRemoteCatalogueProxy (String host , int port) throws IOException {
        catalogueClient = new CatalogueClient(host, port);
    }

<<<<<<< HEAD
    //catalogueClient.waitForRespons().split("/")

=======
    public List<String> getContacts() {
>>>>>>> 98f2d3e1f78023da40e9c53e7c6ea131797fae4a

        List contacts = null;

<<<<<<< HEAD
    public ArrayList<String> getContacts() {
        ArrayList<String> temp = new ArrayList<>();

=======
>>>>>>> 98f2d3e1f78023da40e9c53e7c6ea131797fae4a
        try {
            catalogueClient.connect();
            catalogueClient.sendRequest("getall");
            catalogueClient.waitForRespons();
<<<<<<< HEAD

=======
            contacts = Arrays.asList(catalogueClient.waitForRespons().split("/"));
>>>>>>> 98f2d3e1f78023da40e9c53e7c6ea131797fae4a
            catalogueClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        return temp;
=======
        return contacts;
>>>>>>> 98f2d3e1f78023da40e9c53e7c6ea131797fae4a
    }
}
