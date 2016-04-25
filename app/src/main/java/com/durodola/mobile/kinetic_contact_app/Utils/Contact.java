package com.durodola.mobile.kinetic_contact_app.Utils;

/**
 * Created by mobile on 2016-04-21.
 */
public class Contact {
    /*  public String gender;
      public String phone;

      @Override
      public String toString() {
          return (gender);
      }*/
     /* public  String cell ;
      public  Location location ;
      public  Login login ;
      public  Picture picture ;
      public  Name name ;*/
    public String gender = "gender";
    public String phone = "phone";
    String title;
    public String email = "email";


    // String link;
    public String cell = "cell";
    public Location location;
    public Login login;
    public Picture picture;
    public Name name;
    private static Contact contact = new Contact();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Contact() {
    }

    /* Static 'instance' method */
    public static Contact getInstance() {
        return contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return ("gender " + gender + " cell " + cell + " phone " + phone);
    }


}
