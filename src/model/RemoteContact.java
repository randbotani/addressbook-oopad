
package model;

/**
 * Created by Rand on 2016-12-20.
 */

public class RemoteContact implements Contact{

    private String id;
    private ContactDetails contactDetails;

    public RemoteContact(String id, String firstName, String lastName, String email) {
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
