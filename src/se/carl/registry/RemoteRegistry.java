package se.carl.registry;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import se.carl.catalogue.*;
import se.carl.model.*;

public class RemoteRegistry {
   private static final Logger log = Logger.getLogger(RemoteRegistry.class.getName());


   private List<RemoteContact> remoteContacts;
   private CatalogueLoader catalogueLoader;

   public RemoteRegistry(){
      log.info("Creating a Contact List...");
      remoteContacts = new ArrayList<>();
      catalogueLoader = new CatalogueLoader(this);
      Thread thread = new Thread(catalogueLoader);
      thread.start();
   }

   public List<RemoteContact> getContacts(){
      log.info("Getting remote contacts in the Contact List.");
      return remoteContacts;
   }

   public List<RemoteContact> search(String term){

      List<RemoteContact> results = new ArrayList<>();
      log.info("Searching remote contacts in the Contact List...");
      for(RemoteContact c : remoteContacts){
         if (c.getFirstName().toLowerCase().startsWith(term.toLowerCase()) || c.getLastName().toLowerCase().startsWith(term.toLowerCase())){
            results.add(c);
         }
      }
      log.info("Searching returns its results.");
      return results;
   }

   public void add(String id, String firstName, String lastName, String email){
      log.info("Adding a remote contacts in the Contact List...");
      remoteContacts.add(new RemoteContact(id, firstName, lastName, email));
   }
}
