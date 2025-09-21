package com.example.contactproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.contactproject.model.Contact;
import com.example.contactproject.sqlite.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    private final SQLiteDatabase db;

    public ContactDAO(Context conext) {
        DBHelper dbHelper = new DBHelper(conext);
        db = dbHelper.getWritableDatabase();
    }

    public void contactInsert(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, contact.getName());

        db.insert(DBHelper.TABLE_CONTACTS_NAME, null, values);
    }

    // return a contact list to fill out the activity later
    public List<Contact> listContacts() {
       List<Contact> contacts = new ArrayList<>();

       // Assembles a pointer to the elements in database list
        Cursor cursor = db.query(DBHelper.TABLE_CONTACTS_NAME,
                new String[] {DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME},
                        null, null, null, null, null);

        // Move the cursor over the elements
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);

                Contact contact = new Contact(id, name);
                contacts.add(contact);

            } while (cursor.moveToNext());
        }
        cursor.close();

       return contacts;
    }
}
