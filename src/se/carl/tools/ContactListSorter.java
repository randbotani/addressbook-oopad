package se.carl.tools;

import se.carl.model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class ContactListSorter {

    private static Comparator<Contact> contactComparator = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
        }
    };

    public static ArrayList<Contact> sort (ArrayList<Contact> contacts){
        contacts.sort(contactComparator);
        return contacts;
    }

}
