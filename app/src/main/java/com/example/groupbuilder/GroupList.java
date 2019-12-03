package com.example.groupbuilder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.security.acl.Group;
import java.util.List;

public class GroupList extends ArrayAdapter<GroupClass> {
    private Activity context;
    List<GroupClass> groups;

    public GroupList(Activity context, List<GroupClass> groups){
        super(context, R.layout.group_list_layout, groups);
        this.context = context;
        this.groups = groups;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.group_list_layout, null, true);
        TextView textViewTsil1 = (TextView) listViewItem.findViewById(R.id.thsi1);
        TextView textViewTsil2 = (TextView) listViewItem.findViewById(R.id.thsi2);

        GroupClass groupClass = groups.get(position);
        textViewTsil1.setText(groupClass.getGroupName());
        textViewTsil2.setText(groupClass.getGroupLeader());

        return listViewItem;
    }
}
