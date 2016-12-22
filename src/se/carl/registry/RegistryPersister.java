package se.carl.registry;

import se.carl.model.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class RegistryPersister {
    private List<LocalContact> fileContacts = new ArrayList<>();
    private String path = "contacts.ser";

    public void save(Registry registry) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(registry.getContacts());
            out.flush();
            out.close();
            fileOut.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<LocalContact> load() {
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            fileContacts = (ArrayList) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (ArrayList<LocalContact>) fileContacts;
    }

}

