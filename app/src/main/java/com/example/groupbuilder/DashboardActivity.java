package com.example.groupbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView MainGroup, OtherGroups, AddGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Define CardViews
        MainGroup = (CardView) findViewById(R.id.MainGroupID);
        OtherGroups = (CardView) findViewById(R.id.OtherGroupID);
        AddGroup = (CardView) findViewById(R.id.AddGroupID);

        // Add onClickListeners to each Card
        MainGroup.setOnClickListener(this);
        OtherGroups.setOnClickListener(this);
        AddGroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id. AddGroupID : i = new Intent(this, AddGroup.class );
                 startActivity(i); break;
            case R.id.MainGroupID : i = new Intent(this, MainGroup.class);
                 startActivity(i); break;
            case R.id.OtherGroupID : i = new Intent(this, OtherGroups.class);
                 startActivity(i); break;
            default: break;
        }
    }
}
