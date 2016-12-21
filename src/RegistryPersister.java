import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RegistryPersister {

    private ArrayList<Contact> temp = new ArrayList<>();

    public void save(){
        AutoSave autoSave = new AutoSave();
        autoSave.run();

    }
    public ArrayList<Contact> load() throws ClassNotFoundException {

        File file = new File("ContactList.contacts");



        try(FileInputStream load = new FileInputStream(file);
            ObjectInputStream is = new ObjectInputStream(load)){
            temp = (ArrayList<Contact>) is.readObject();
        }catch (IOException e){
            temp = new ArrayList<>();
            e.printStackTrace();


        }
            return temp;
    }

}
