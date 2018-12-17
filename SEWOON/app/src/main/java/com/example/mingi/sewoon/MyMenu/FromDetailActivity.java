package com.example.mingi.sewoon.MyMenu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.MainActivity;
import com.example.mingi.sewoon.R;
import com.example.mingi.sewoon.Shop.ShopMenuActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FromDetailActivity extends AppCompatActivity {

    String reply;
    TextView title, content, name, day;
    Button reply_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        name = (TextView) findViewById(R.id.name);
        day = (TextView) findViewById(R.id.day);

        Intent intent = getIntent();


        name.setText(intent.getStringExtra("name")+" 장인");
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
        day.setText(intent.getStringExtra("day"));


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if( id == android.R.id.home){

            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);


    }


}
