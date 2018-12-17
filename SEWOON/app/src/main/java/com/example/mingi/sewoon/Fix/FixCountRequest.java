package com.example.mingi.sewoon.Fix;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class FixCountRequest extends StringRequest {
    final static  private String URL = "http://scvalsrl.cafe24.com/FixCount.php";

    private Map<String, String> parameters;

    public FixCountRequest(Response.Listener<String> listener){
        super(Method.POST,URL , listener, null);
    }




    @Override
    public Map<String, String> getParams(){

        return parameters;

    }


}
