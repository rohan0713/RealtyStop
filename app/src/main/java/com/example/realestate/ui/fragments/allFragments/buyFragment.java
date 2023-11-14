package com.example.realestate.ui.fragments.allFragments;

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
import com.example.realestate.data.remote.Retrofit;
import com.example.realestate.models.ProjectResponse;
import com.example.realestate.ui.activities.SearchResult;
import com.example.realestate.ui.activities.allProperties;
import com.example.realestate.models.projectData;
import com.example.realestate.ui.adapters.projectAdapter;
import com.example.realestate.roomFiles.projectRepository;
import com.example.realestate.roomFiles.projectViewmodel;
import com.example.realestate.ui.adapters.serviceAdapter;
import com.example.realestate.models.serviceData;
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

//        TextView viewAll = view.findViewById(R.id.viewAll);
//        viewAll.setPaintFlags(viewAll.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
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

//        viewAll.setOnClickListener(v -> {
//            setRecyclerView(view, false);
//        });

        RecyclerView service_recyclerview = view.findViewById(R.id.recyclerView2);
        service_recyclerview.setLayoutManager(new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        projectRepository = new projectRepository(requireActivity().getApplication());
        List<projectData> projectData = new ArrayList<>();
        projectAdapter = new projectAdapter(projectData, R.layout.popular_item);
        projectViewmodel = new ViewModelProvider(this).get(projectViewmodel.class);
        getProjectList();
        setRecyclerView(view, true);


        ArrayList<serviceData> services = new ArrayList<>();
        services.add(new serviceData("#C9A0B6", "Bungalow", R.drawable.bungalow));
        services.add(new serviceData("#E5D4FF", "Apartments", R.drawable.apartment));
        services.add(new serviceData("#A3B763", "FarmHouse", R.drawable.farmhouse));

        service_recyclerview.setHasFixedSize(true);
        service_recyclerview.setAdapter(new serviceAdapter(services));
        return view;
    }

    private void setRecyclerView(View view,Boolean flag){

        projectViewmodel.getProjects().observe(getViewLifecycleOwner(), new Observer<List<projectData>>() {
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

        Call<ProjectResponse> projectInfoCall = Retrofit.GetServices().getProjectsInfo();
        projectInfoCall.enqueue(new Callback<ProjectResponse>() {

            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {

                Log.d("project", response.body().getList().toString());
                assert response.body() != null;
                projectRepository.insert(response.body().getList());
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d("Error" , t.getMessage());
                Toast.makeText(getView().getContext(), "Try to connect to Internet!", Toast.LENGTH_LONG).show();
            }
        });
    }

}