package com.example.mingi.sewoon.Event;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.mingi.sewoon.Shop.Fragment_1F;
import com.example.mingi.sewoon.Shop.Fragment_2F;
import com.example.mingi.sewoon.Shop.Fragment_3F;

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
            return new TourFragment();
        }else if(i==1){
            return new partyFragment();
        }else{
            return new StudyFragment();
        }



    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
