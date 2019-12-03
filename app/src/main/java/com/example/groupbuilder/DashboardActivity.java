package com.example.groupbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView MainGroup, OtherGroups, AddGroup, MyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Define CardViews
        MainGroup = (CardView) findViewById(R.id.MainGroupID);
        OtherGroups = (CardView) findViewById(R.id.OtherGroupID);
        AddGroup = (CardView) findViewById(R.id.AddGroupID);
        MyProfile = findViewById(R.id.MyProfileID);

        // Add onClickListeners to each Card
        MainGroup.setOnClickListener(this);
        OtherGroups.setOnClickListener(this);
        AddGroup.setOnClickListener(this);
        MyProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id. AddGroupID : i = new Intent(this, AddGroup.class );
                 startActivity(i); break;
            case R.id.MainGroupID : i = new Intent(this, GroupList.class);
                 startActivity(i); break;
            case R.id.OtherGroupID : i = new Intent(this, OtherGroups.class);
                 startActivity(i); break;
            case R.id.MyProfileID : i = new Intent(this, ViewProfile.class);
                 startActivity(i); break;
            default: break;
        }
    }
}
