package com.example.mingi.sewoon.MyMenu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.MyMenu.From;
import com.example.mingi.sewoon.MyMenu.FromListAdapter;
import com.example.mingi.sewoon.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FromListActivity extends AppCompatActivity {

    private ListView listView;
    private FromListAdapter adapter;
    private List<From> fixlist;


    TextView txtlist, txtcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView = (ListView) findViewById(R.id.FixListView);
        fixlist = new ArrayList<From>();
        adapter = new FromListAdapter(getApplicationContext(), fixlist, this);
        listView.setAdapter(adapter);

        Intent intent = getIntent();

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String title, name, day, content;


            if(jsonArray.length()==0) {
                Drawable drawable = getResources().getDrawable(R.drawable.nocarlist);
                ImageView imageView = (ImageView) findViewById(R.id.imageView1);
                imageView.setImageDrawable(drawable);
            }


            while (count < jsonArray.length()) {

                JSONObject object = jsonArray.getJSONObject(count);

                title = object.getString("title");
                content = object.getString("content");
                day = object.getString("day");
                name  = object.getString("fromUserName");


                From from = new From(title, content, name, day);
                fixlist.add(from);
                count++;

            }

            txtcount.setText(String.valueOf(count));

        } catch (Exception e) {

            e.printStackTrace();

        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(FromListActivity.this, FromDetailActivity.class);
                intent.putExtra("name", fixlist.get(i).getFromUserName());
                intent.putExtra("title", fixlist.get(i).getTitle());
                intent.putExtra("content", fixlist.get(i).getContent());
                intent.putExtra("day", fixlist.get(i).getDay());
                FromListActivity.this.startActivity(intent);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
