package model;

import java.util.UUID;

public class LocalContact implements Contact{
    private UUID id;
    private ContactDetails contactDetails;

    public LocalContact(UUID id, String firstName, String lastName, String email) {
        this.contactDetails = new ContactDetails(firstName, lastName, email);
        this.id = id;
    }

    @Override
    public String getId() {
        String uuid = this.id.toString();
        return uuid;
    }

    @Override
    public String getFirstName() {
        return contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        return contactDetails.getLastName();
    }

    @Override
    public String getEmailAddress() {
        return contactDetails.getEmail();
    }

}
