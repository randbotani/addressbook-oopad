package se.carl.model;

import java.io.Serializable;
import java.util.UUID;

public class LocalContact implements Contact, Serializable{

    private ContactDetails dets;
    private UUID id;

    public LocalContact(UUID id, String firstName, String lastName, String email){
        this.id = id;
        dets = new ContactDetails(firstName, lastName, email);
    }

    @Override
    public String getFirstName() {
        return dets.getFirstName();
    }

    @Override
    public String getLastName() {
        return dets.getLastName();
    }

    @Override
    public String getEmail() {
        return dets.getEmail();
    }

    @Override
    public String getId() {
        return getUUID().toString();
    }

    private UUID getUUID() {
        return id;
    }
}