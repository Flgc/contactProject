package com.example.contactproject.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contactproject.R;
import com.example.contactproject.model.Contact;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private final List<Contact> contacts;
    private final Activity activity;

    public ContactAdapter(List<Contact> contacts, Activity activity) {
        this.contacts = contacts;
        this.activity = activity;
    }

    // Return the number of the items in the list
    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Recycle cells when changing position during a consultation
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = activity.getLayoutInflater().inflate(R.layout.contact_list,
                viewGroup, false);
        Contact contact = contacts.get(position);

        // Return the text view element from contact_list.xml
        TextView tvNameContactList = view.findViewById(R.id.tvNameContactList);

        // Update tvNameContactList in contact_list.xml
        tvNameContactList.setText(contact.getName());
        return view;
    }
}
