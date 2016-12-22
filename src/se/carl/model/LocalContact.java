package se.carl.model;

import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Logger;

public class LocalContact implements Contact, Serializable{
    private static final Logger log = Logger.getLogger(LocalContact.class.getName());

    private ContactDetails contactDetails;
    private UUID id;

    public LocalContact(UUID id, String firstName, String lastName, String email){
        log.info("Setting a local contact...");
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
        return getUUID().toString();
    }

    private UUID getUUID() {
        log.info("Getting Contact id (UUID).");
        return id;
    }
}