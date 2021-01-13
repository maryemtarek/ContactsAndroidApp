package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ConntactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conntact);

        ImageView image = findViewById(R.id.imageView);
        TextView Name = findViewById(R.id.name);
        TextView Phone = findViewById(R.id.phone);


        Intent intent = getIntent();
        Contact contact = (Contact)intent.getSerializableExtra("contactInfo");
        image.setImageResource(contact.getContact_Image());
        Name.setText(contact.getContact_name());
        Phone.setText(contact.getPhoneNumber());


    }
}