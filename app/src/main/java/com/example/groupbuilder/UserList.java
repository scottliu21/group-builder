package com.example.groupbuilder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserList extends ArrayAdapter<User> {
    private Activity context;
    List<User> users;

    public UserList(Activity context, List<User> users){
        super(context, R.layout.activity_group_list, users);
        this.context = context;
        this.users = users;
    }

    //@Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.user_list, null,  true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewUser);

        User user = users.get(position);
        textViewName.setText(user.getName());
        textViewName.setText(user.getEmail());
        textViewName.setText(user.getMajor());
        textViewName.setText(user.getYear());

        return listViewItem;
    }

}
