package se.carl.registry;

import se.carl.model.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class RegistryPersister {
    private static final Logger log = Logger.getLogger(RegistryPersister.class.getName());

    private List<LocalContact> fileContacts = new ArrayList<>();
    private String path = "contacts.ser";

    public void save(Registry registry) {
        log.info("Saving in a file...");
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(registry.getContacts());
            out.flush();
            out.close();
            fileOut.close();
            log.info("File saved successfully!");
        }catch (Exception e){
            log.info("Error: " + e);
            e.printStackTrace();
        }
    }

    public ArrayList<LocalContact> load() {
        log.info("Loading from a file...");
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            fileContacts = (ArrayList) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();

        }catch (Exception e){
            log.info("Error: " + e);
            e.printStackTrace();
        }
        log.info("File loaded successfully!");
        return (ArrayList<LocalContact>) fileContacts;

    }

}

