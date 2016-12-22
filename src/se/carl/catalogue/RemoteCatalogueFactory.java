package se.carl.catalogue;

import java.util.logging.Logger;

class RemoteCatalogueFactory {

    private static final Logger log = Logger.getLogger(RemoteCatalogueFactory.class.getName());

    private int defaultPort;

    public RemoteCatalogueFactory(int defaultPort){
        log.info("Setting default port...");
        this.defaultPort = defaultPort;
    }

    public RemoteCatalogueProxy create(String host){
        log.info("Creating a proxy...");
        return new AtomicRemoteCatalogueProxy(host, defaultPort);

    }
}
