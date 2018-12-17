package com.example.mingi.sewoon.Fix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FixMenuActivity extends AppCompatActivity {

    private ListView listView;
    private FixListAdapter adapter;
    private List<Fix> fixlist;


    TextView txtlist, txtcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView = (ListView) findViewById(R.id.FixListView);
        fixlist = new ArrayList<Fix>();
        adapter = new FixListAdapter(getApplicationContext(), fixlist, this);
        listView.setAdapter(adapter);

        Intent intent = getIntent();

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String title, category, day;
            int no, reply;

            while (count < jsonArray.length()) {

                JSONObject object = jsonArray.getJSONObject(count);

                title = object.getString("title");
                category = object.getString("category");
                day = object.getString("day");
                reply = object.getInt("reply");
                no = object.getInt("no");

                Fix fix = new Fix(title, category, no, day, reply);
                fixlist.add(fix);
                count++;

            }

            txtcount.setText(String.valueOf(count));

        } catch (Exception e) {

            e.printStackTrace();

        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int num = fixlist.get(i).getNo();
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            String image, title, content, category, day,userID;
                            int reply;
                            image = jsonResponse.getString("image");
                            title = jsonResponse.getString("title");
                            content = jsonResponse.getString("content");
                            category = jsonResponse.getString("category");
                            day = jsonResponse.getString("day");
                            reply = jsonResponse.getInt("reply");
                            userID = jsonResponse.getString("userID");
                           int no = jsonResponse.getInt("no");
                            if (success) {

                                // 답변이 없을시
                                if(reply==0){
                                    Intent intent = new Intent(FixMenuActivity.this, FixDetail_Reply_Activity.class);
                                    intent.putExtra("no",Integer.toString(no));
                                    intent.putExtra("image", image);
                                    intent.putExtra("title", title);
                                    intent.putExtra("content", content);
                                    intent.putExtra("category", category);
                                    intent.putExtra("day", day);
                                    intent.putExtra("reply", reply);
                                    intent.putExtra("userID", userID);
                                    FixMenuActivity.this.startActivity(intent);
                                    // 화면전환 넣기 //
                                }else{
                                    Intent intent = new Intent(FixMenuActivity.this, FixDetail_NoReply_Activity.class);


                                    intent.putExtra("image", image);
                                    intent.putExtra("title", title);
                                    intent.putExtra("content", content);
                                    intent.putExtra("category", category);
                                    intent.putExtra("day", day);
                                    intent.putExtra("reply", reply);

                                    FixMenuActivity.this.startActivity(intent);
                                }



                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                };

                FixDetailRequest fixDetailRequest = new FixDetailRequest(fixlist.get(i).getNo(), responseListener);
                RequestQueue queue = Volley.newRequestQueue(FixMenuActivity.this);
                queue.add(fixDetailRequest);


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fixright_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;

        }
        if (id == R.id.join) {
            Intent intent = new Intent(FixMenuActivity.this, FixSubmitActivity.class);

            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
