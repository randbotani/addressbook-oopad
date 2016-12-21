package model;

import java.util.UUID;

public class ContactDetails {

    private String firstName;
    private String lastName;
    private String email;

    public ContactDetails(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

}
