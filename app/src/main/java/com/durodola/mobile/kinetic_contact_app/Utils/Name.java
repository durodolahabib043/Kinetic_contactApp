package com.durodola.mobile.kinetic_contact_app.Utils;

/**
 * Created by mobile on 2016-04-21.
 */
public class Name {
    public  String title = "title" ;
    public  String first = "first" ;
    public  String last = "last" ;

    private static Name name = new Name();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Name() {
    }

    /* Static 'instance' method */
    public static Name getInstance() {
        return name;
    }

}
