package se.carl.catalogue;


import java.util.List;
import se.carl.registry.*;
import se.carl.tools.Console;


public class CatalogueLoader implements Runnable{

    private RemoteCatalogueProxy atomicRemoteCatalogueProxy;
    private RemoteCatalogueFactory remoteCatalogueFactory;
    private RemoteRegistry remoteRegistry;
    private Console consolePrinter;

    public CatalogueLoader(RemoteRegistry remoteRegistry) {
        this.remoteRegistry = remoteRegistry;
        remoteCatalogueFactory = new RemoteCatalogueFactory(61616);
    }

    public void run(){
        List<String> contactsAsStringLines;
            atomicRemoteCatalogueProxy = remoteCatalogueFactory.create("localhost");
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
/*            Console consolePrinter = new Console();
            consolePrinter.print("NullPointerException!");*/
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