package se.carl.catalogue;

class RemoteCatalogueFactory {

    private int defaultPort;

    public RemoteCatalogueFactory(int defaultPort){
        this.defaultPort = defaultPort;
    }

    public RemoteCatalogueProxy create(String host){
        return new AtomicRemoteCatalogueProxy(host, defaultPort);

    }
}
