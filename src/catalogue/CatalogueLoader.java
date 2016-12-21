package catalogue;

import java.io.IOException;

/**
 * Created by Luiz Oliveira on 2016-12-21.
 */
public class CatalogueLoader {

    public void run(){
        Thread thread = new Thread(() -> {
            RemoteCatalogueFactory remoteCatalogueFactory = new RemoteCatalogueFactory();

            //remoteCatalogueFactory.RemoteCatalogueFactory(61616);
            try {
                remoteCatalogueFactory.creat("172.20.200.240");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
