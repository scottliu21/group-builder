package com.example.groupbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.security.acl.Group;
import java.util.ArrayList;

public class MainGroup extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase db;
    DatabaseReference ref;
    ArrayList<Group> list;
    ArrayTypeAdapter<Group> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_group);

        listView = (ListView) findViewById();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("groups");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<Group>(this, R.layout.activity_main_group, R.id.mainGroupInfo, list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    GroupClass groupClass = ds.getValue(GroupClass.class);
                    list.add(GroupClass.getGroupName());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
