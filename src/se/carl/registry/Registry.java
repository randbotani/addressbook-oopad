package se.carl.registry;

import java.util.ArrayList;
import java.util.UUID;
import se.carl.model.*;


import java.util.*;
import java.util.logging.Logger;


public class Registry {
    private static final Logger log = Logger.getLogger(Registry.class.getName());

    private ArrayList<LocalContact> contacts;

    public Registry() {
        log.info("Creating a Contact List...");
        contacts = new ArrayList<>();
    }

    public void addContact(String firstName, String lastName, String email) {
        log.info("Creating a local contact...");
        UniqueIdGenerator id = new UniqueIdGenerator();
        LocalContact newLocalContact = new LocalContact(id.generate(), firstName, lastName, email);
        newLocalContact.getId();
        contacts.add(newLocalContact);
        log.info("Adding the new contact in the Contact List.");
    }

    public ArrayList<LocalContact> getContacts() {
        log.info("Getting contacts in the Contact List.");
        return contacts;
    }

    public void deleteContact(String id) {
        Iterator<LocalContact> it = contacts.iterator();
        while (it.hasNext()) {
            LocalContact contact = it.next();
            if (contact.getId().equals(id)) {
                it.remove();
                log.info("Removing a contact from the Contact List.");
            }
        }
    }

    public List<LocalContact> search(String term) {
        List<LocalContact> results = new ArrayList<>();
        log.info("Searching in the Contact List...");
        for (LocalContact contact : contacts) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) || contact.getLastName().toLowerCase().startsWith(term.toLowerCase())) {
                results.add(contact);
            }
        }
        log.info("Searching returns its results.");
        return results;
    }

    public void load(ArrayList<LocalContact> contacts) {
        log.info("Updating the Contact List.");
        this.contacts = contacts;
    }
}