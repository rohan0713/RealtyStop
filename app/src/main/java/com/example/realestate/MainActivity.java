package com.example.realestate;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView buy = findViewById(R.id.buy);
        buy.setTextColor(getResources().getColor(R.color.black));
        buy.setPaintFlags(buy.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG | Color.GREEN);
        FrameLayout frameLayout = findViewById(R.id.fragmentContainer);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new buyFragment()).commit();
    }
}