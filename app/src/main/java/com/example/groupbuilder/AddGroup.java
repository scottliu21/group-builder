package com.example.groupbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddGroup extends AppCompatActivity {
    String gName, gLeader, gDescription;
    int gCount;

    EditText gNameInput, gCountInput, gDescriptionInput;
    Button addGroup;

    final FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref = db.getReference("/");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        gNameInput = findViewById(R.id.gName);
        gCountInput = findViewById(R.id.gMemCount);
        gDescriptionInput = findViewById(R.id.gDescription);
        addGroup = findViewById(R.id.addGroupButton);

        gLeader = user.getEmail();

        addGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gName = gNameInput.getText().toString();
                gCount = Integer.valueOf(gCountInput.getText().toString());
                gDescription = gDescriptionInput.getText().toString();

                GroupClass newGroup = new GroupClass();
                newGroup.setGroupName(gName);
                newGroup.setGroupLeader(gLeader);
                newGroup.setMemCount(gCount);
                newGroup.setDescription(gDescription);

                DatabaseReference groupsRef = ref.child("groups");
                Map<String, GroupClass> groups = new HashMap<>();
                groups.put(gName, newGroup);
                groupsRef.setValue(groups);

                Toast.makeText(AddGroup.this, "Group has been created", Toast.LENGTH_SHORT);
                Intent intent = new Intent(AddGroup.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }
}
