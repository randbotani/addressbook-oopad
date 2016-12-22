package se.carl.tools;

import se.carl.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Logger;

public class ContactListSorter {
    private static final Logger log = Logger.getLogger(ContactListSorter.class.getName());


    private static Comparator<Contact> contactComparator = new Comparator<Contact>() {

        @Override
        public int compare(Contact c1, Contact c2) {
            log.info("Comparing First Name between 2 contacts...");
            return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
        }
    };

    public static ArrayList<Contact> sort (ArrayList<Contact> contacts){
        log.info("Sorting Contacts...");
        contacts.sort(contactComparator);
        return contacts;
    }

}
