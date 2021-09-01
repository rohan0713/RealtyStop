package com.example.realestate.allFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.realestate.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class monitorFragment extends Fragment {


    BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monitor, container, false);
        bottomNavigationView = view.findViewById(R.id.bottomnavgview);

        if (savedInstanceState == null) {
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new projectsFragment()).commit();

        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment = null;

                switch (menuItem.getItemId()) {

                    case R.id.project:

                        fragment = new projectsFragment();
                        break;

                    case R.id.live:
                        fragment = new cameraFragment();
                        break;

                    case R.id.profile:

                        fragment = new profileFragment();
                        break;
                    case R.id.review:

                        fragment = new feedbackFragment();
                        break;

                }
                assert fragment != null;
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, fragment).commit();
                return true;
            }
        });

        return view;
    }
}