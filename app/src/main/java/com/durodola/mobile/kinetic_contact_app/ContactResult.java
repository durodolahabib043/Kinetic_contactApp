package com.durodola.mobile.kinetic_contact_app;

import com.durodola.mobile.kinetic_contact_app.Utils.Contact;

import java.util.List;

/**
 * Created by mobile on 2016-04-21.
 */
public class ContactResult {
    List<Contact> results;
    private static ContactResult result = new ContactResult();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private ContactResult() {
    }

    /* Static 'instance' method */
    public static ContactResult getInstance() {
        return result;
    }
}
