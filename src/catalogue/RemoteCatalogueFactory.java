package catalogue;

import java.io.IOException;

/**
 * Created by Luiz Oliveira on 2016-12-21.
 */
public class RemoteCatalogueFactory {
    private int defaultPort = 61616;

    public void RemoteCatalogueFactory(int port){
        this.defaultPort = port;
    }

    public RemoteCatalogueProxy creat(String host) throws IOException {
        AtomicRemoteCatalogueProxy proxy = new AtomicRemoteCatalogueProxy(host, this.defaultPort);
        return proxy;
    }

}
