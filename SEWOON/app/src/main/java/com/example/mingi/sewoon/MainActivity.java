package com.example.mingi.sewoon;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mingi.sewoon.Event.Event;
import com.example.mingi.sewoon.Event.EventMenuActivity;
import com.example.mingi.sewoon.Fix.FixMenuActivity;
import com.example.mingi.sewoon.Fix.FixSubmitActivity;
import com.example.mingi.sewoon.Match.MatchMenuActivity;
import com.example.mingi.sewoon.MyMenu.MyMenuActivity;
import com.example.mingi.sewoon.Shop.Shop;
import com.example.mingi.sewoon.Shop.ShopMenuActivity;
import com.example.mingi.sewoon.Trip.TripMenuActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    StringBuffer stringBuffer;
    ArrayList<Shop> members;
    ListView listview = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup menu1 = (ViewGroup) findViewById(R.id.lay1);
        ViewGroup menu2 = (ViewGroup) findViewById(R.id.lay2);
        ViewGroup menu3 = (ViewGroup) findViewById(R.id.lay3);
        ViewGroup menu4 = (ViewGroup) findViewById(R.id.lay4);
        ViewGroup menu5 = (ViewGroup) findViewById(R.id.lay5);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TripMenuActivity.class);
                MainActivity.this.startActivity(intent);
                // 화면전환 넣기 //

            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                // new BackgroundTask().execute();

                Intent intent = new Intent(MainActivity.this, ShopMenuActivity.class);
                MainActivity.this.startActivity(intent);
                // 화면전환 넣기 //


            }
        });

        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                // new BackgroundTask().execute();

                Intent intent = new Intent(MainActivity.this, MatchMenuActivity.class);
                MainActivity.this.startActivity(intent);
                // 화면전환 넣기 //


            }
        });

        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                // new BackgroundTask().execute();

                Intent intent = new Intent(MainActivity.this, EventMenuActivity.class);
                MainActivity.this.startActivity(intent);
                // 화면전환 넣기 //


            }
        });


        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundTask().execute();
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
*/



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mymenu) {

            Intent intent = new Intent(MainActivity.this, MyMenuActivity.class);
            MainActivity.this.startActivity(intent);

        } else if (id == R.id.nav_info) {
            Intent intent = new Intent(MainActivity.this, ShopMenuActivity.class);
            MainActivity.this.startActivity(intent);
            // 화면전환 넣기 //

        } else if (id == R.id.nav_fix) {
            new BackgroundTask().execute();

        } else if (id == R.id.nav_matching) {
            Intent intent = new Intent(MainActivity.this, MatchMenuActivity.class);
            MainActivity.this.startActivity(intent);
        }else if (id == R.id.nav_event) {
            Intent intent = new Intent(MainActivity.this, EventMenuActivity.class);
            MainActivity.this.startActivity(intent);

        }else if (id == R.id.nav_logout) {

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = auto.edit();
            //editor.clear()는 auto에 들어있는 모든 정보를 기기에서 지웁니다.
            editor.clear();
            editor.commit();
            Toast.makeText(MainActivity.this, "로그아웃 하였습니다", Toast.LENGTH_SHORT).show();
            finish();

            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "http://scvalsrl.cafe24.com/FixList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null) {

                    stringBuilder.append(temp + "\n");

                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (Exception e) {

                e.printStackTrace();

            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        public void onPostExecute(String result) {

            Intent intent = new Intent(MainActivity.this, FixMenuActivity.class);
            intent.putExtra("userList", result);
            MainActivity.this.startActivity(intent);

            overridePendingTransition(0, 0);

        }

    }



}
