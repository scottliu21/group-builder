package com.example.groupbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

public class ViewGroups extends AppCompatActivity {

    public static final String GROUP_NAME = "stuff";
    public static final String USER_NAME = "otherstuff";

    ListView listViewGroups;

    List<GroupClass> groups;

    DatabaseReference dbGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_groups);

        dbGroups = FirebaseDatabase.getInstance().getReference("groups");

        listViewGroups = (ListView) findViewById(R.id.listViewGroup);

        groups = new ArrayList<>();

        listViewGroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                GroupClass groupClass = groups.get(i);

                Intent intent = new Intent(getApplicationContext(), null);

                intent.putExtra(GROUP_NAME, groupClass.getGroupName());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        dbGroups.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                groups.clear();

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    GroupClass groupClass = postSnapshot.getValue(GroupClass.class);
                }

                GroupList groupAdapter = new GroupList(ViewGroups.this, groups);
                listViewGroups.setAdapter(groupAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
