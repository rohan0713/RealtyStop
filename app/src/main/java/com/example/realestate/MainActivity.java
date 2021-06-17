package com.example.realestate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    TabLayout tabLayout;
    TabItem buy,sell,monitor;
    ViewPager viewPager;
    pageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        buy = findViewById(R.id.buy);
        sell = findViewById(R.id.sell);
        monitor = findViewById(R.id.monitor);
        viewPager = findViewById(R.id.viewPager);
        pageAdapter = new pageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        ColorStateList colorStateList = sell.getTextColors();
//        buy.setTextColor(getResources().getColor(R.color.black));
//        buy.setPaintFlags(buy.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG | Color.GREEN);
//        FrameLayout frameLayout = findViewById(R.id.fragmentContainer);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new buyFragment()).commit();
//
//        sell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                buy.setPaintFlags(View.INVISIBLE);
//                buy.setTextColor(colorStateList);
//                sell.setTextColor(getResources().getColor(R.color.black));
//                sell.setPaintFlags(sell.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG | Color.GREEN);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new sellFragment()).commit();
//
//            }
//        });
//
//        buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sell.setPaintFlags(View.INVISIBLE);
//                sell.setTextColor(colorStateList);
//                buy.setTextColor(getResources().getColor(R.color.black));
//                buy.setPaintFlags(buy.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG | Color.GREEN);
//                FrameLayout frameLayout = findViewById(R.id.fragmentContainer);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new buyFragment()).commit();
//
//            }
//        });
    }
}