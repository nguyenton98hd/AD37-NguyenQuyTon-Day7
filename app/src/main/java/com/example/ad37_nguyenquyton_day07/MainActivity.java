package com.example.ad37_nguyenquyton_day07;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contactList;
    RecyclerView recyclerView;
    AdapterContact adapterContact;
    View vAdd;
    int mPosition = -1;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    TextView txtFriend, txtMess;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        recyclerView = findViewById(R.id.rvList);
        vAdd = findViewById(R.id.vAdd);
        contactList = new ArrayList<>();
        txtFriend = findViewById(R.id.friend);
        txtMess = findViewById(R.id.message);
        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = preferences.edit();
        imageView = findViewById(R.id.image2);
        contactList.add(new Contact("Mr.A", "Hello, How are you?", true));
        contactList.add(new Contact("Mr.B", "Can you give me some?", false));
        contactList.add(new Contact("Mr.C", "", false));
        contactList.add(new Contact("Mr.D", "", false));
        contactList.add(new Contact("Mr.E", "Yes. I am", true));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL, false);
        adapterContact = new AdapterContact(contactList, getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterContact);
        vAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Update.class);
                intent.putExtra("name", "");
                startActivityForResult(intent, 115);
            }
        });
        txtMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.fly);
                editor.putBoolean("messages", false);
                editor.commit();
                adapterContact.notifyDataSetChanged();
                vAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                        popupMenu.show();
                    }
                });

            }

        });
        txtFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.people);
                editor.putBoolean("messages", true);
                editor.commit();
                adapterContact.notifyDataSetChanged();

            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    }

