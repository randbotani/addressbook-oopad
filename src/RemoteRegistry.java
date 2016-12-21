import java.util.ArrayList;

public class RemoteRegistry {

   private ArrayList<Contact> contacts = new ArrayList<>();

   public void add (String id, String firstName, String lastName, String email){
      Contact contact = new RemoteContact(id, firstName, lastName, email);
      contacts.add(contact);
   }





}
