package com.example.mingi.sewoon.Event;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mingi.sewoon.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class TourFragment extends Fragment {


    LinearLayout t_01,t_02,t_03;

    public TourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_tour_fragment, container, false);
    }



    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        t_01 = (LinearLayout)getView().findViewById(R.id.t_01);
        t_02 = (LinearLayout)getView().findViewById(R.id.t_02);
        t_03 = (LinearLayout)getView().findViewById(R.id.t_03);


        t_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage(1);
            }
        });

        t_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage(2);
            }
        });


        t_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage(3);
            }
        });





    }

    public void showImage(int num) {
        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(getActivity());

        if(num==1)
            imageView.setImageResource(R.drawable.t_p_01);
        else if(num==2)
            imageView.setImageResource(R.drawable.t_p_3);
        else
            imageView.setImageResource(R.drawable.t_p_2);


        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }





}