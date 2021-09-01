package com.example.realestate.allFragments;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realestate.R;
import com.example.realestate.Retrofit;
import com.example.realestate.activities.SearchResult;
import com.example.realestate.activities.allProperties;
import com.example.realestate.projectData;
import com.example.realestate.projectAdapter;
import com.example.realestate.roomFiles.projectRepository;
import com.example.realestate.roomFiles.projectViewmodel;
import com.example.realestate.serviceAdapter;
import com.example.realestate.serviceData;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class buyFragment extends Fragment {

    private RecyclerView recyclerView;
    private static projectRepository projectRepository;
    private projectViewmodel projectViewmodel;
    private projectAdapter projectAdapter;
    Button search_btn;
    TextInputLayout textField;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy, container, false);

        TextView viewAll = view.findViewById(R.id.viewAll);
        viewAll.setPaintFlags(viewAll.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        recyclerView = view.findViewById(R.id.recyclerView);
        textField = view.findViewById(R.id.projectSearch);
        EditText tt = view.findViewById(R.id.place);
        search_btn = view.findViewById(R.id.search);

        search_btn.setOnClickListener(v -> {

            String place = tt.getText().toString();
            if(place.isEmpty()){
                textField.setError("Cant be empty");
            }else {
                projectViewmodel.searchResult(requireActivity().getApplication(),
                        place).observe(getViewLifecycleOwner(), new Observer<List<projectData>>() {
                    @Override
                    public void onChanged(List<projectData> projectData) {
                        Bundle b = new Bundle();
                        b.putSerializable("result", (Serializable) projectData);
                        Intent i = new Intent(view.getContext(), SearchResult.class);
                        i.putExtras(b);
                        view.getContext().startActivity(i);
                    }
                });
            }
        });

        viewAll.setOnClickListener(v -> {
            setRecyclerView(view, false);
        });

        RecyclerView service_recyclerview = view.findViewById(R.id.recyclerView2);
        service_recyclerview.setLayoutManager(new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.HORIZONTAL,false));


        projectRepository = new projectRepository(requireActivity().getApplication());
        List<projectData> projectData = new ArrayList<>();
        projectAdapter = new projectAdapter(projectData, R.layout.popular_item);
        projectViewmodel = new ViewModelProvider(this).get(projectViewmodel.class);
        getProjectList();
        setRecyclerView(view, true);


        ArrayList<serviceData> services = new ArrayList<>();
        services.add(new serviceData("#C9A0B6", "Bungalow", R.drawable.bungalow));
        services.add(new serviceData("#3C8DAD", "Flats", R.drawable.apartment));
        services.add(new serviceData("#343A40", "FarmHouse", R.drawable.farmhouse));

        service_recyclerview.setHasFixedSize(true);
        service_recyclerview.setAdapter(new serviceAdapter(services));
        return view;
    }

    private void setRecyclerView(View view,Boolean flag){

        projectViewmodel.getProjects().observe(getViewLifecycleOwner(), new Observer<List<com.example.realestate.projectData>>() {
            @Override
            public void onChanged(List<projectData> projectData) {

                if(flag) {
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(projectAdapter);
                    projectAdapter.getProjects(projectData);
                }else{
                    Bundle b = new Bundle();
                    b.putSerializable("result", (Serializable) projectData);
                    Intent i = new Intent(view.getContext(), allProperties.class);
                    i.putExtras(b);
                    view.getContext().startActivity(i);
                }
            }
        });
    }

    private void getProjectList(){

        Call<List<projectData>> projectInfoCall = Retrofit.GetServices().getProjectsInfo();
        projectInfoCall.enqueue(new Callback<List<projectData>>() {

            @Override
            public void onResponse(Call<List<projectData>> call, Response<List<projectData>> response) {

                projectRepository.insert(response.body());
            }

            @Override
            public void onFailure(Call<List<projectData>> call, Throwable t) {
                Log.d("Error" , t.getMessage());
                Toast.makeText(getView().getContext(), "Try to connect to Internet!", Toast.LENGTH_LONG).show();
            }
        });
    }

}