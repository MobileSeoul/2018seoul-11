package com.example.mingi.sewoon.Fix;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MINGI on 2017-12-09.
 */

public class FixJoinRequest extends StringRequest {

    final static private String URL = "http://scvalsrl.cafe24.com/FixRegister.php";

    private Map<String, String> parameters;

    public FixJoinRequest(String title, String content, String category
            , int no, String strToday, int reply, String image, String userID, Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);


        parameters = new HashMap<>();


        parameters.put("title", title);
        parameters.put("content", content);
        parameters.put("category", category);
        parameters.put("no", no + "");
        parameters.put("day", strToday);
        parameters.put("reply", reply + "");
        parameters.put("image", image);
        parameters.put("userID", userID);
    }

    @Override
    public Map<String, String> getParams() {

        return parameters;
    }


}
