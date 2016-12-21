package se.carl.registry;



import java.util.ArrayList;
import java.util.List;
import se.carl.catalogue.*;
import se.carl.model.*;

public class RemoteRegistry {

   private List<RemoteContact> remoteContacts;
   private CatalogueLoader catalogueLoader;

   public RemoteRegistry(){
      remoteContacts = new ArrayList<>();
      catalogueLoader = new CatalogueLoader(this);
      Thread thread = new Thread(catalogueLoader);
      thread.start();
   }

   public List<RemoteContact> getContacts(){
      return remoteContacts;
   }

   public List<RemoteContact> search(String term){
      List<RemoteContact> results = new ArrayList<>();

      for(RemoteContact c : remoteContacts){
         if (c.getFirstName().toLowerCase().startsWith(term.toLowerCase()) || c.getLastName().toLowerCase().startsWith(term.toLowerCase())){
            results.add(c);
         }
      }
      return results;
   }

   public void add(String id, String firstName, String lastName, String email){
      remoteContacts.add(new RemoteContact(id, firstName, lastName, email));
   }
}
