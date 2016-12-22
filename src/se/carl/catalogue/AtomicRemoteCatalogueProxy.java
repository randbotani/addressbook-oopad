package se.carl.catalogue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {
    private static final Logger log = Logger.getLogger(AtomicRemoteCatalogueProxy.class.getName());

    private final String host;
    private final int port;
    private CatalogueClient catalogueClient;

    public AtomicRemoteCatalogueProxy(String host, int port) {
        log.info("Setting ATOMIC host and port.");
        this.host = host;
        this.port = port;
    }

    public List<String> getContacts() {
        log.info("Receiving contacts...");
        catalogueClient = new CatalogueClient(host, port);
        catalogueClient.connect();
        catalogueClient.sendRequest("getall");

        String clientResponse = catalogueClient.waitForResponse();

        catalogueClient.disconnect();

        return parseResponse(clientResponse);

    }

    private List<String> parseResponse(String response) {
        log.info("Parsing contacts...");
        List<String> converter = new ArrayList<>();
        String[] splitClientResponse = response.split("\n");
        Collections.addAll(converter, splitClientResponse);

        return converter;
    }
}
