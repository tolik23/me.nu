package com.liutorovich.anatoliy.gmail.menu.Interface;

import android.database.Cursor;

/**
 * Created by ToLik on 23.02.2017.
 */

public interface IMenuDatabase {

    public void addContact(String restaurant, String adress, double summ, String date);
    public Cursor getAllContacts();
    public int getContactsCount();
    public void deleteAll();
}
