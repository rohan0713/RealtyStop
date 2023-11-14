package com.example.realestate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.realestate.ui.fragments.allFragments.buyFragment;
import com.example.realestate.ui.fragments.allFragments.monitorFragment;
import com.example.realestate.ui.fragments.allFragments.sellFragment;

public class pageAdapter extends FragmentPagerAdapter {

    int tab_count;
    public pageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tab_count = behavior;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new buyFragment();
        }
        if (position == 1) {
            return new sellFragment();
        } else {

            return new monitorFragment();
        }
    }

    @Override
    public int getCount() {
        return tab_count;
    }
}
