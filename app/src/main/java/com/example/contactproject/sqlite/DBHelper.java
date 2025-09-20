package com.example.contactproject.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Create a layout and structure script for the new table in the SQLite database
    private static final String DATABASE_NAME = "contacts_db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    private static final String CRATE_TABLE_CONTACTS =
            "CREATE TABLE " + TABLE_CONTACTS_NAME + "("+
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT)";

    // Construct
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table if it does not exist
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRATE_TABLE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
