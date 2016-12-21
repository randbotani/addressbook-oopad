
package se.carl.model;

public class RemoteContact implements Contact {
    private ContactDetails contactDetails;
    private String id;

    public RemoteContact(String id, String firstName, String lastName, String email){
        this.id = id;
        contactDetails = new ContactDetails(firstName, lastName, email);

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
    public String getEmail() {
        return contactDetails.getEmail();
    }

    @Override
    public String getId() {
        return id;
    }
}