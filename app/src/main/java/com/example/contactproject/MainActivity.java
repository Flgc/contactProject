package com.example.contactproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contactproject.adapter.ContactAdapter;
import com.example.contactproject.dao.ContactDAO;
import com.example.contactproject.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadContacts();
    }

    private void loadContacts(){
        ContactDAO contactDAO = new ContactDAO(this);
        //List<Contact> contacts = contactDAO.listContacts();
        List<Contact> contacts = fakeContacts();
        ContactAdapter contactAdapter = new ContactAdapter(contacts, this);

        ListView lvContacts = findViewById(R.id.lvContacts);
        lvContacts.setAdapter(contactAdapter);
    }

    private List<Contact> fakeContacts(){
        Contact c1 = new Contact(1,"Contact 01");
        Contact c2 = new Contact(1,"Contact 02");
        Contact c3 = new Contact(1,"Contact 03");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        return contacts;
    }
}