package com.example.groupbuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.internal.bind.ArrayTypeAdapter;

import org.w3c.dom.Text;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

public class GroupList extends ArrayAdapter<GroupClass> {
    private Activity context;
    List<GroupClass> groupClassList;

    public GroupList(@NonNull Context context, List<GroupClass> group) {
        super(context, R.layout.activity_group_list, group);
        this.context = (Activity) context;
        this.groupClassList = group;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_group_list, null, true);

        TextView textViewGroup = (TextView) listViewItem.findViewById(R.id.MainGroupID);

        GroupClass groupClass = groupClassList.get(position);
        textViewGroup.setText(groupClass.getGroupName());

        return listViewItem;
    }
}
