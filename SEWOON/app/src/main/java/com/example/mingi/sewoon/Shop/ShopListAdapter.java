package com.example.mingi.sewoon.Shop;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.mingi.sewoon.R;
import com.example.mingi.sewoon.Shop.Shop;

import java.util.List;

/**
 * Created by choi on 2017-05-08.
 */

public class ShopListAdapter extends BaseAdapter {
    private Context context;
    private List<Shop> userList;


    public ShopListAdapter(Context context, List<Shop> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View v,  ViewGroup viewGroup) {

        PersonViewHolder viewHolder;

        if(v==null) {
            v = View.inflate(context, R.layout.shop, null);
            viewHolder = new PersonViewHolder();

            viewHolder.name =(TextView)v.findViewById(R.id.shop_name);
            viewHolder.item =(TextView)v.findViewById(R.id.shop_item);
            viewHolder.location =(TextView)v.findViewById(R.id.shop_location);
            viewHolder.category =(TextView)v.findViewById(R.id.shop_category);
            viewHolder. imageView= (ImageView) v.findViewById(R.id.shop_photo);

            v.setTag(viewHolder);

        }
        else
        {
            viewHolder = (PersonViewHolder) v.getTag();
        }


        viewHolder.name.setText(userList.get(position).getName());
        viewHolder.location.setText(userList.get(position).getLocation());
        viewHolder.item.setText(userList.get(position).getItem());
        viewHolder. category.setText(userList.get(position).getCategory());
        Glide.with(context).load("http://scvalsrl.cafe24.com/uploads/" + userList.get(position).getPhoto()).into(viewHolder.imageView);



        return v;
    }


    public class PersonViewHolder
    {
        public TextView name ;
        public TextView item ;
        public TextView location ;
        public TextView category ;
        public ImageView imageView;

    }





}
