
package se.carl.model;

import java.util.logging.Logger;

public class RemoteContact implements Contact {
    private static final Logger log = Logger.getLogger(RemoteContact.class.getName());


    private ContactDetails contactDetails;
    private String id;

    public RemoteContact(String id, String firstName, String lastName, String email){
        log.info("Setting a remote contact...");
        this.id = id;
        contactDetails = new ContactDetails(firstName, lastName, email);

    }

    @Override
    public String getFirstName() {
        log.info("Getting Contact Details:");
        return contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        log.info("Getting Contact Details:");
        return contactDetails.getLastName();
    }

    @Override
    public String getEmail() {
        log.info("Getting Contact Details:");
        return contactDetails.getEmail();
    }

    @Override
    public String getId() {
        log.info("Getting Contact id (String).");
        return id;
    }
}