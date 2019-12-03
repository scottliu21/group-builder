package com.example.groupbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewGroup extends AppCompatActivity {

    public static final String GROUP_NAME = "groupName";
    public static final String USER_ID = "userName";

    TextView textViewGroupNames;
    ListView listViewGroups;

    List<GroupClass> groupClasses;

    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        Intent intent = getIntent();

        databaseUsers = FirebaseDatabase.getInstance().getReference("groups").child(intent.getStringExtra(USER_ID));
        textViewGroupNames = (TextView) findViewById(R.id.textViewGroup);
        listViewGroups = findViewById(R.id.listGroups);

        groupClasses = new ArrayList<>();

        textViewGroupNames.setText(intent.getStringExtra(GROUP_NAME));
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                groupClasses.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    GroupClass groupClass = postSnapshot.getValue(GroupClass.class);
                    groupClasses.add(groupClass);
                }

                GroupList groupAdapter = new GroupList(ViewGroup.this, groupClasses);
                listViewGroups.setAdapter(groupAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

