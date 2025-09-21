package com.example.contactproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contactproject.adapter.ContactAdapter;
import com.example.contactproject.dao.ContactDAO;
import com.example.contactproject.model.Contact;

import java.util.List;

public class ListClientActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activityclientlist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Create the variable for the Views (xml)
        Button btBack  =  findViewById(R.id.btBack);
        btBack.setOnClickListener(this);

        loadContacts();
    }

    private void loadContacts(){
        ContactDAO contactDAO = new ContactDAO(this);

        /*
        Contact c1 = new Contact(1,"Contact 01");
        Contact c2 = new Contact(1,"Contact 02");
        Contact c3 = new Contact(1,"Contact 03");

        contactDAO.contactInsert(c1);
        contactDAO.contactInsert(c2);
        contactDAO.contactInsert(c3);

         */

        List<Contact> contacts = contactDAO.listContacts();

        ContactAdapter contactAdapter = new ContactAdapter(contacts, this);

        ListView lvContacts = findViewById(R.id.lvContacts);
        lvContacts.setAdapter(contactAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btBack) {
            finish();
        }
    }
}