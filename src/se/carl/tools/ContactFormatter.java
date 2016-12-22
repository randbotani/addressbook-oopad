package se.carl.tools;

import se.carl.model.*;

import java.util.ArrayList;
import java.util.logging.Logger;


public class ContactFormatter {
    private static final Logger log = Logger.getLogger(ContactFormatter.class.getName());

    public static String format(ArrayList<Contact> contacts){
        log.info("Formatting a Contact in multiple lines...");

        String result = "";
        for (Contact c : contacts) {
            result += format(c) + "\n";
        }
        return result;
    }

    private static String format(Contact contact){
        log.info("Formatting a contact in a line...");
        return contact.getId()+" "+contact.getFirstName()+" "+contact.getLastName()+" "+contact.getEmail();
    }

}
