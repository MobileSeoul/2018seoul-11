package com.example.mingi.sewoon.Fix;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.MainActivity;
import com.example.mingi.sewoon.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FixReplyActivity extends AppCompatActivity {

    private AlertDialog.Builder builder;
    Button cencel, join;
    EditText fixTitle, fixContent;
    TextView fixname;
    String no;
    String ReUserID, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_reply);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        ReUserID = intent.getStringExtra("ReUserID");
        no = intent.getStringExtra("no");
        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
        userName = auto.getString("userName", null);




        builder = new AlertDialog.Builder(FixReplyActivity.this);

        fixname = (TextView) findViewById(R.id.fixname);
        fixTitle = (EditText) findViewById(R.id.fixTitle);
        fixContent = (EditText) findViewById(R.id.fixContent);

        join = (Button) findViewById(R.id.join);
        cencel = (Button) findViewById(R.id.cencel);

        fixname.setText(userName);

        cencel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fixTitle.getText().toString().equals("")) {

                    builder.setMessage(" 제목을 입력해주세요 ")
                            .setNegativeButton("확인", null)
                            .create()
                            .show();

                } else if (fixContent.getText().toString().equals("")) {

                    builder.setMessage(" 내용을 입력해주세요 ")
                            .setNegativeButton("확인", null)
                            .create()
                            .show();

                } else {


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success) {


                                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try {
                                                JSONObject jsonResponse = new JSONObject(response);
                                                boolean success = jsonResponse.getBoolean("success");

                                                if (success) {
                                                    builder.setMessage("성공적으로 등록 되었습니다")
                                                            .setPositiveButton("확인", null)
                                                            .create()
                                                            .show();

                                                    Intent intent = new Intent(FixReplyActivity.this, MainActivity.class);
                                                    FixReplyActivity.this.startActivity(intent);
                                                    finish();


                                                }

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }

                                        }


                                    };


                                    FixReply_Update_Request fixReply_update_request = new FixReply_Update_Request(Integer.parseInt(no), responseListener);
                                    RequestQueue queue = Volley.newRequestQueue(FixReplyActivity.this);

                                    queue.add(fixReply_update_request);


                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                    };

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Calendar c1 = Calendar.getInstance();
                    String strToday = sdf.format(c1.getTime());


                    FixReJoinRequest fixReJoinRequest = new FixReJoinRequest(fixTitle.getText().toString(), fixContent.getText().toString(),  strToday, ReUserID, userName, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(FixReplyActivity.this);

                    queue.add(fixReJoinRequest);


                }


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
