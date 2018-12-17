package com.example.mingi.sewoon.Fix;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MINGI on 2017-12-09.
 */

public class FixReply_Update_Request extends StringRequest {

    final static private String URL = "http://scvalsrl.cafe24.com/FixReplyUpdate.php";

    private Map<String, String> parameters;

    public FixReply_Update_Request(int no ,Response.Listener<String> listener) {

        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();

        parameters.put("no", no+"");

    }

    @Override
    public Map<String, String> getParams() {

        return parameters;
    }


}
