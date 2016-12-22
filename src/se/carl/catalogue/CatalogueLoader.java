package se.carl.catalogue;


import java.util.List;
import java.util.logging.Logger;

import se.carl.registry.*;


public class CatalogueLoader implements Runnable{
    private static final Logger log = Logger.getLogger(CatalogueLoader.class.getName());

    private RemoteCatalogueProxy atomicRemoteCatalogueProxy;
    private RemoteCatalogueFactory remoteCatalogueFactory;
    private RemoteRegistry remoteRegistry;

    public CatalogueLoader(RemoteRegistry remoteRegistry) {
        int port = 61616;
        log.info("Setting remote registry... port: " + port);
        this.remoteRegistry = remoteRegistry;
        remoteCatalogueFactory = new RemoteCatalogueFactory(port);
    }

    public void run(){
        String host = "172.20.200.157";
        log.info("Setting remote registry... host: " + host);
        List<String> contactsAsStringLines;
            atomicRemoteCatalogueProxy = remoteCatalogueFactory.create(host);
        try{
    contactsAsStringLines = atomicRemoteCatalogueProxy.getContacts();

        for (String contactLine: contactsAsStringLines
                ) {

            String[] contactArray = contactLineToContactArray(contactLine);
            if(contactArray == null) {
                break;
            }
            remoteRegistry.add(contactArray[0], contactArray[1], contactArray[2], contactArray[3]);
        }

} catch (Exception e){
            log.severe("Error: " + e);
        }
    }


    private String[] contactLineToContactArray(String contactLine) {
        log.info("Splitting contact line (string from the server).");
        String[] contactArray = contactLine.split(" ");
        if(contactArray.length == 4) {
            return contactArray;
        }
        return null;
    }
}