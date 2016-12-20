/**
 * Created by Rand on 2016-12-20.
 */
public class RemoteContact implements Contact{

    private String id;

    private ContactDetails contactDetails;

    public RemoteContact(String id, String firstName, String lasttName, String email) {
        this.contactDetails = new ContactDetails(firstName, lasttName, email);
        this.id = id;
        this.contactDetails = contactDetails;
    }



    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getEmailAddress() {
        return null;
    }
}
