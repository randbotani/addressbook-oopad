import java.util.UUID;

public class LocalContact implements Contact{
    private UUID id;

    private ContactDetails contactDetails;

    public LocalContact(UUID id, String firstName, String lasttName, String email) {
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
