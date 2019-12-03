package com.example.groupbuilder;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ViewProfile extends AppCompatActivity {
    String flName, userYear, userMajor;

    EditText flNameInput, userYearInput, userMajorInput;
    Button saveProfile;

    final FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref = db.getReference("/");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        flNameInput = findViewById(R.id.userFLName);
        userYearInput = findViewById(R.id.userGrade);
        userMajorInput = findViewById(R.id.userMajor);
        saveProfile = findViewById(R.id.saveProfileButton);

        saveProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                flName = flNameInput.getText().toString();
                userYear = userYearInput.getText().toString();
                userMajor = userMajorInput.getText().toString();

                User newUser = new User();
                newUser.setEmail(user.getEmail());
                newUser.setName(flName);
                newUser.setYear(userYear);
                newUser.setMajor(userMajor);
                newUser.setInGroup(false);

                DatabaseReference usersRef = ref.child("users");
                Map<String, User> users = new HashMap<>();
                users.put(newUser.getName(), newUser);
                usersRef.push().setValue(users);

                Toast.makeText(ViewProfile.this, "Profile has been saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewProfile.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }
}
