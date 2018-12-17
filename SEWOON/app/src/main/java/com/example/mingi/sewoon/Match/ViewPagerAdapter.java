package com.example.mingi.sewoon.Match;

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
            return new MListFragment();
        }else{
            return new JoinFragment();
        }



    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
