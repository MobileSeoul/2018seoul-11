package com.example.mingi.sewoon.Shop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mingi.sewoon.Event.StudyFragment;
import com.example.mingi.sewoon.Event.TourFragment;
import com.example.mingi.sewoon.Event.partyFragment;

/**
 * Created by HNAbbasi on 8/18/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;

    public ViewPagerAdapter(FragmentManager fm, String[] tabs) {
        super(fm);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new Fragment_all();
        }else if(i==1){
            return new Fragment_1F();
        }else if(i==2){
            return new Fragment_2F();
        }else if(i==3){
            return new Fragment_3F();
        }else{
            return new Fragment_4F();
        }



    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
