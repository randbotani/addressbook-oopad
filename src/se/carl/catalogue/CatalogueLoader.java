package se.carl.catalogue;


import java.util.List;
import se.carl.registry.*;


public class CatalogueLoader implements Runnable{

    private RemoteCatalogueProxy atomicRemoteCatalogueProxy;
    private RemoteCatalogueFactory remoteCatalogueFactory;
    private RemoteRegistry remoteRegistry;

    public CatalogueLoader(RemoteRegistry remoteRegistry) {
        this.remoteRegistry = remoteRegistry;
        remoteCatalogueFactory = new RemoteCatalogueFactory(61616);
    }

    public void run(){
        atomicRemoteCatalogueProxy = remoteCatalogueFactory.create("localhost");

        List<String> contactsAsStringLines = atomicRemoteCatalogueProxy.getContacts();

        for (String contactLine: contactsAsStringLines
                ) {

            String[] contactArray = contactLineToContactArray(contactLine);
            if(contactArray == null) {
                break;
            }
            remoteRegistry.add(contactArray[0], contactArray[1], contactArray[2], contactArray[3]);
        }
    }


    private String[] contactLineToContactArray(String contactLine) {
        String[] contactArray = contactLine.split(" ");
        if(contactArray.length == 4) {
            return contactArray;
        }
        return null;
    }
}