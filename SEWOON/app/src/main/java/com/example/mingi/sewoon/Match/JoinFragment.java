package com.example.mingi.sewoon.Match;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mingi.sewoon.R;


public class JoinFragment extends Fragment {

    Button btn;
    public JoinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_join_fragment, container, false);
    }


    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        btn = (Button)getView().findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSdDqD5o6Mp5w_5ONFNFHKcVcIbglHHZ_xS4OOtbGbEVwwBFHw/viewform"));
                startActivity(intent);


            }
        });

    }


}