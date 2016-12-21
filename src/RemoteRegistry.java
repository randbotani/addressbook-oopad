import java.util.ArrayList;

public class RemoteRegistry {

   private ArrayList<Contact> contacts = new ArrayList<>();

   public void add (String id, String firstName, String lastName, String email){
      Contact contact = new RemoteContact(id, firstName, lastName, email);
      contacts.add(contact);
   }

   public ArrayList<Contact> getContacts(){
      return this.contacts;
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



}
