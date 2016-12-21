package se.carl.tools;

import se.carl.model.*;

import java.util.ArrayList;


public class ContactFormatter {

    public static String format(ArrayList<Contact> contacts){
        String result = "";
        for (Contact c :
                contacts) {
            result += format(c) + "\n";
        }
        return result;
    }

    private static String format(Contact contact){
        return contact.getId()+" "+contact.getFirstName()+" "+contact.getLastName()+" "+contact.getEmail();
    }

}
