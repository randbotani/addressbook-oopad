package se.carl.model;

import java.io.Serializable;


public interface Contact extends Serializable {

    String getFirstName();
    String getLastName();
    String getEmail();
    String getId();

}
