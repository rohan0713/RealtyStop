package com.example.realestate.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;

import com.example.realestate.R;
import com.example.realestate.ui.adapters.projectAdapter;
import com.example.realestate.models.projectData;

import java.util.List;

public class SearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search_result);
        TextView header = findViewById(R.id.header_title);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Bundle bundle = getIntent().getExtras();
        List<projectData> item = (List<projectData>) bundle.getSerializable("result");
        if(item.size()!=0) {
            header.setText("Searched Keyword: " + "'" + item.get(0).place + "'");
        }else{
            header.setText("NO DATA FOUND");
        }
//        List<projectData> list = getIntent().getParcelableExtra("result");
        RecyclerView recyclerView = findViewById(R.id.rvProjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new projectAdapter(item, R.layout.active_projects_item));
    }
}