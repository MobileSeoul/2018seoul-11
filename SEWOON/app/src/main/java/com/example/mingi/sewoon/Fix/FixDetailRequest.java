package com.example.mingi.sewoon.Fix;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MINGI on 2018-04-27.
 */

public class FixDetailRequest extends StringRequest {
    final static private String URL = "http://scvalsrl.cafe24.com/FixDetail.php";
    private Map<String, String> parameters;

    public FixDetailRequest(int no, Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("no", no+"");


    }


    @Override
    public Map<String, String> getParams() {

        return parameters;
    }

}
