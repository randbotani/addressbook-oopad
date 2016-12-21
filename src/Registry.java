import java.util.ArrayList;
import java.util.UUID;


public class Registry {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String firstName, String lastName, String email){
        UniqueIdGenerator idGenerator = new UniqueIdGenerator();
        UUID id = idGenerator.getUuid();
        Contact contact = new LocalContact(id, firstName, lastName, email);
        contacts.add(contact);

    }
    public ArrayList<Contact> getContacts(){
<<<<<<< HEAD
        return this.contacts;

=======
        return contacts;
>>>>>>> d18e6240315d2a308114fc1dccf1074350a77670
    }
    public void deleteContact(String id){
        for(Contact contact: contacts){
            if(contact.getId().equals(id)){
                contacts.remove(contact);
            }
        }
    }
    public ArrayList<Contact> search(String term){
        ArrayList<Contact> temp = new ArrayList<>();

        for(Contact contact: contacts){
            if(contact.getFirstName().startsWith(term) || contact.getLastName().startsWith(term)){
                temp.add(contact);
            }
        }
        return temp;

    }
    public void load( ){

    }
}
