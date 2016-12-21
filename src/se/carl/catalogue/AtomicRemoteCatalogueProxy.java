package se.carl.catalogue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    private final String host;
    private final int port;
    private CatalogueClient catalogueClient;

    public AtomicRemoteCatalogueProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public List<String> getContacts() {

        catalogueClient = new CatalogueClient(host, port);
        catalogueClient.connect();
        catalogueClient.sendRequest("getall");

        String clientResponse = catalogueClient.waitForResponse();

        catalogueClient.disconnect();

        return parseResponse(clientResponse);

    }

    private List<String> parseResponse(String response) {
        List<String> converter = new ArrayList<>();
        String[] splitClientResponse = response.split("\n");
        Collections.addAll(converter, splitClientResponse);

        return converter;
    }
}
