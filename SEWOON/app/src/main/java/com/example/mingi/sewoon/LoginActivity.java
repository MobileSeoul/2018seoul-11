package com.example.mingi.sewoon;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.Fix.FixSubmitActivity;


import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    String userID,userName;
    String userPassword;
    String check2;
    private  AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        builder = new AlertDialog.Builder(LoginActivity.this);

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final Button loginButton = (Button) findViewById(R.id.loginButton);
        final TextView registerButton = (TextView) findViewById(R.id.registerButton);


        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }

        });


        // 로그인 버튼 클릭
        loginButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                userID = idText.getText().toString();
                userPassword = passwordText.getText().toString();

                if (idText.getText().toString().equals("") || passwordText.getText().toString().equals("")) {
                    builder.setMessage(" 아이디 및 비밀번호를 확인해주세요. ")
                            .setNegativeButton("확인", null)
                            .create()
                            .show();
                }else {


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            try {
                                // 제이슨 생성
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {  // 성공
                                    Log.d("  로그인 상공 : ", "");
                                    userID = jsonResponse.getString("userID");
                                    userPassword = jsonResponse.getString("userPassword");
                                    userName = jsonResponse.getString("userName");
                                    check2 = jsonResponse.getString("check2");
                                    SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                                    //auto의 loginId와 loginPwd에 값을 저장해 줍니다.
                                    SharedPreferences.Editor autoLogin = auto.edit();
                                    autoLogin.putString("userID", userID);
                                    autoLogin.putString("check2", check2);
                                    autoLogin.putString("userName", userName);
                                    autoLogin.commit();
                                    Log.d("로그인", "아이디 : " + userID + "  " + check2 + "   " + userName);

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    //  intent.putExtra("userID", userID);
                                    //  intent.putExtra("userPassword", userPassword);
                                    LoginActivity.this.startActivity(intent);
                                    // 화면전환 넣기 //
                                    finish();
                                } else {
                                    builder.setMessage(" 아이디 및 비밀번호를 확인해주세요. ")
                                            .setNegativeButton("확인", null)
                                            .create()
                                            .show();
                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    };

                    // 로그인 리퀘스트 생성
                    LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

                    // 요청
                    queue.add(loginRequest);
                }

            }


        });


    }
}
