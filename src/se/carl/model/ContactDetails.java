package se.carl.model;


import java.io.Serializable;
import java.util.logging.Logger;


class ContactDetails implements Serializable{
    private static final Logger log = Logger.getLogger(ContactDetails.class.getName());

    private String firstName;
    private String lastName;
    private String email;

    public ContactDetails(String firstName, String lastName, String email){
        log.info("Setting a contact details...");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        log.info("Getting instance variable: 'firstName'.");
        return firstName;
    }

    public String getLastName() {
        log.info("Getting instance variable: 'lastName'.");
        return lastName;
    }

    public String getEmail() {
        log.info("Getting instance variable: 'email'.");
        return email;
    }
}