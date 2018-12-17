package com.example.mingi.sewoon;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private  AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup01);

        final EditText idText= (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        final EditText phoneText = (EditText) findViewById(R.id.phone);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        builder = new AlertDialog.Builder(RegisterActivity.this);

        Button registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (idText.getText().toString().equals("")) {

                    builder.setMessage(" 아이디를 입력해주세요 ")
                            .setNegativeButton("확인", null)
                            .create()
                            .show();

                } else if (passwordText.getText().toString().equals("")) {

                    builder.setMessage(" 비밀번호를 입력해주세요 ")
                            .setNegativeButton("확인", null)
                            .create()
                            .show();
                } else {

                    int id = rg.getCheckedRadioButtonId();
                    //getCheckedRadioButtonId() 의 리턴값은 선택된 RadioButton 의 id 값.
                    RadioButton rb = (RadioButton) findViewById(id);
                    String check2 = rb.getText().toString();


                    String userID = idText.getText().toString();
                    String userPassword = passwordText.getText().toString();
                    String userName = nameText.getText().toString();
                    String phone = phoneText.getText().toString();


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("회원 등록에 성공 했습니다.")
                                            .setPositiveButton("확인", null)
                                            .create()
                                            .show();
                                    finish();

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("회원 등록에 실패 했습니다.")
                                            .setNegativeButton("다시시도", null).create().show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    RegisterActivity.this.startActivity(intent);

                                }

                            } catch (JSONException e) {

                                e.printStackTrace();
                            }


                        }


                    };

                    RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName, phone, check2, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);

                }

            }
        });
    }
}

