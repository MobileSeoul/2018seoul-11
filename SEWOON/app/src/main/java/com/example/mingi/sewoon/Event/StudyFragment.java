package com.example.mingi.sewoon.Event;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mingi.sewoon.R;


public class StudyFragment extends Fragment {
    LinearLayout s_01,s_02,s_03;
    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_study_fragment, container, false);
    }



    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        s_01 = (LinearLayout)getView().findViewById(R.id.s_01);
       s_02 = (LinearLayout)getView().findViewById(R.id.s_02);
        s_03 = (LinearLayout)getView().findViewById(R.id.s_03);


        s_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage(1);
            }
        });

        s_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImage(2);
            }
        });
        s_03.setOnClickListener(new View.OnClickListener() {
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
            imageView.setImageResource(R.drawable.s_p_1);
        else if(num==2)
            imageView.setImageResource(R.drawable.s_p_2);
        else
            imageView.setImageResource(R.drawable.s_p_3);


        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }





}