package registry;

import registry.Registry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AutoSave {

    public void run(){
        Registry registry = new Registry();
        File file = new File("ContactList.contacts");
        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(registry.getContacts());
        }catch (IOException e){

            e.printStackTrace();
        }

    }
}