package se.carl.registry;

import java.util.ArrayList;
import java.util.UUID;
import se.carl.model.*;


import java.util.*;


public class Registry {
    private ArrayList<LocalContact> contacts;

    public Registry() {
        contacts = new ArrayList<>();
    }

    public void addContact(String firstName, String lastName, String email) {
        LocalContact newLocalContact = new LocalContact(UUID.randomUUID(), firstName, lastName, email);
        newLocalContact.getId();
        contacts.add(newLocalContact);
    }

    public ArrayList<LocalContact> getContacts() {
        return contacts;
    }

    public void deleteContact(String id) {
        Iterator<LocalContact> it = contacts.iterator();
        while (it.hasNext()) {
            LocalContact contact = it.next();
            if (contact.getId().equals(id)) {
                it.remove();
            }
        }
    }

    public List<LocalContact> search(String term) {
        List<LocalContact> results = new ArrayList<>();

        for (LocalContact contact : contacts) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) || contact.getLastName().toLowerCase().startsWith(term.toLowerCase())) {
                results.add(contact);
            }
        }
        return results;
    }

    public void load(ArrayList<LocalContact> contacts) {
        this.contacts = contacts;
    }
}