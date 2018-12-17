package com.example.mingi.sewoon.Fix;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mingi.sewoon.R;

import java.util.List;


public class FixListAdapter extends BaseAdapter {

    private Context context;
    private List<Fix> userList;
    private Activity parentActivity;


    public FixListAdapter(Context context, List<Fix> userList, Activity parentActivity) {
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

        if (v == null) {
            v = View.inflate(context, R.layout.fix, null);
            viewHolder = new PersonViewHolder();





            viewHolder.category = (TextView) v.findViewById(R.id.fix_category);
            viewHolder.title = (TextView) v.findViewById(R.id.fix_title);
            viewHolder.reply = (ImageView) v.findViewById(R.id.fix_reply);
            viewHolder.no = (TextView) v.findViewById(R.id.fix_no);
            viewHolder.day = (TextView) v.findViewById(R.id.fix_day);

            v.setTag(viewHolder);
        } else {
            viewHolder = (PersonViewHolder) v.getTag();
        }

        // 미답변 일시
        if(userList.get(i).getReply()==0){
            viewHolder.reply.setImageResource(R.drawable.reply_0);


        }else{
            viewHolder.reply.setImageResource(R.drawable.reply_1);
        }

        String title = userList.get(i).getTitle();
        if(title.length()>=18){
            title=title.substring(0,18 );
            title = title + "...";
        }

        viewHolder.category.setText("["+userList.get(i).getCategory()+"]");
        viewHolder.title.setText(title);
        viewHolder.day.setText("sewoon  |  "+userList.get(i).getDay());
        viewHolder.no.setText((String.valueOf(userList.get(i).getNo())));


        return v;


    }


    public class PersonViewHolder {
        public TextView category;
        public TextView title;
        public TextView day;
        public TextView no;
        public ImageView reply;

    }

}
