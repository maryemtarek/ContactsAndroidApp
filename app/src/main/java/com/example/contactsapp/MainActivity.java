package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerViewAdaptor adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView Recyclerview = findViewById(R.id.recyclerView);
        final ArrayList <Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact(R.drawable.image1,"Ahmed","0122242565"));
        contacts.add(new Contact(R.drawable.image2,"Mohamed","01122245556"));
        contacts.add(new Contact(R.drawable.image3,"Ali","0141666565566"));
        contacts.add(new Contact(R.drawable.image4,"Amr","0126561664626"));

        adapter = new RecyclerViewAdaptor(contacts);
        Recyclerview.setLayoutManager(layoutManager );
        Recyclerview.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(Recyclerview.getContext(),
                layoutManager.getOrientation());
        Recyclerview.addItemDecoration(dividerItemDecoration);
        adapter.setOnClickListener(new RecyclerViewAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(),ConntactActivity.class);
                intent.putExtra("contactInfo",contacts.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongClickListener(int position) {
                contacts.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

    }
}