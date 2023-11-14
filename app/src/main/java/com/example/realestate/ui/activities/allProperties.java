package com.example.realestate.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.realestate.R;
import com.example.realestate.ui.adapters.projectAdapter;
import com.example.realestate.models.projectData;

import java.util.List;

public class allProperties extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_properties);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Bundle bundle = getIntent().getExtras();
        List<projectData> item = (List<projectData>) bundle.getSerializable("result");
        RecyclerView recyclerView = findViewById(R.id.rvProjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new projectAdapter(item, R.layout.active_projects_item));
    }
}