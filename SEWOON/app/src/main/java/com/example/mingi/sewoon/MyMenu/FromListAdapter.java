package com.example.mingi.sewoon.MyMenu;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mingi.sewoon.R;

import java.util.List;


public class FromListAdapter extends BaseAdapter {

    private Context context;
    private List<From> userList;
    private Activity parentActivity;



    public FromListAdapter(Context context, List<From> userList, Activity parentActivity) {
        this.context = context;
        this.userList = userList;
        this.parentActivity = parentActivity;

    }


    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int i, View v, ViewGroup viewGroup) {

        PersonViewHolder viewHolder;

        if(v==null) {
            v = View.inflate(context, R.layout.from, null);
            viewHolder = new PersonViewHolder();


            viewHolder. from_name = (TextView) v.findViewById(R.id.from_name);
            viewHolder. from_title = (TextView) v.findViewById(R.id.from_title);
            viewHolder. from_day = (TextView) v.findViewById(R.id.from_day);
            viewHolder. from_content = (TextView) v.findViewById(R.id.from_content);

            v.setTag(viewHolder);
        }
        else
        {
            viewHolder = (PersonViewHolder) v.getTag();
        }

        viewHolder.from_name.setText(userList.get(i).getFromUserName() +" 장인");
        viewHolder. from_title.setText(userList.get(i).getTitle());
        viewHolder.from_day.setText(userList.get(i).getDay());
        viewHolder.from_content.setText(userList.get(i).getContent());
        return v;


    }


    public class PersonViewHolder
    {
        public TextView from_name ;
        public TextView from_title ;
        public TextView from_day ;
        public TextView from_content ;

    }

}
