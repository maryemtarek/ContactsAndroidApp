package com.example.contactsapp;

import java.io.Serializable;

public class Contact implements Serializable {
    int contact_Image;
    String contact_name;
    String PhoneNumber;
    Contact (int image,String name,String PhoneNumber)
    {
        contact_Image = image;
        contact_name= name;
        this.PhoneNumber = PhoneNumber;
    }

    public int getContact_Image() {
        return contact_Image;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
