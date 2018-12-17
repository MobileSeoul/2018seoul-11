package com.example.mingi.sewoon.Fix;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MINGI on 2017-12-09.
 */

public class FixReJoinRequest extends StringRequest {

    final static private String URL = "http://scvalsrl.cafe24.com/FixRegister2.php";

    private Map<String, String> parameters;

    public FixReJoinRequest(String title, String content
            , String strToday,String toUser,String fromUserName, Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);


        parameters = new HashMap<>();


        parameters.put("title", title);
        parameters.put("content", content);
        parameters.put("day", strToday);
        parameters.put("toUser", toUser);
        parameters.put("fromUserName", fromUserName);
    }

    @Override
    public Map<String, String> getParams() {

        return parameters;
    }


}
