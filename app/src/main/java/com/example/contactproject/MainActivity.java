package com.example.contactproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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

        // Create the variable for the Views (xml)
        //EditText etName  =  findViewById(R.id.editTextName);

        // This button will be handled on this screen
        Button btInsert  =  findViewById(R.id.buttonInsert);
        btInsert.setOnClickListener(this);

        // This button will be handled on this screen
        Button btConsult =  findViewById(R.id.buttonConsult);
        btConsult.setOnClickListener(this);

        /*
        --> Implement with one button just "extends AppCompatActivity" in public class
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                insertContacts(name);
                Intent screenListClient = new Intent(MainActivity.this,
                        ListClientActivity.class);
                startActivity(screenListClient);
                finish();
            }
        }); */
    }

    // Implement with two button necessary implements View.OnClickListener in public class
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonInsert){
            EditText etName  =  findViewById(R.id.editTextName);
            String name = etName.getText().toString();
            insertContacts(name);
            returnConsult();
        } else if (view.getId() == R.id.buttonConsult){
            returnConsult();
        }
    }

    private void insertContacts(String name){
        ContactDAO contactDAO = new ContactDAO(this);

        Contact c1 = new Contact(1,name);
        contactDAO.contactInsert(c1);
    }

    private void returnConsult(){
        Intent screenListClient = new Intent(MainActivity.this,
                ListClientActivity.class);
        startActivity(screenListClient);
        finish();
    }
}