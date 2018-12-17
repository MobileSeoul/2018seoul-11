package com.example.mingi.sewoon;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MINGI on 2017-12-09.
 */

public class RegisterRequest extends StringRequest {

    final static  private String URL = "http://scvalsrl.cafe24.com/Register2.php";

    private Map<String, String> parameters;

    public RegisterRequest(String userID , String userPassword, String userName, String phone , String check2,
                           Response.Listener<String> listener){

        super(Method.POST,URL , listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("phone", phone);
        Log.d("김민기", "RegisterRequest: " + check2);
        parameters.put("check2", check2);

    }

    @Override
    public Map<String, String> getParams(){

        return parameters;
    }


}
