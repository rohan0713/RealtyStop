package com.example.realestate.ui.fragments.allFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.realestate.R;
import com.example.realestate.data.remote.Retrofit;
import com.example.realestate.models.ProjectResponse;
import com.example.realestate.ui.adapters.projectAdapter;
import com.example.realestate.models.projectData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class projectsFragment extends Fragment {

    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects, container, false);
        recyclerView = view.findViewById(R.id.rvProjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getProjectList();
        return view;
    }

    private void getProjectList(){

        Call<ProjectResponse> moviesInfoCall = Retrofit.GetServices().getActiveProjects();
        moviesInfoCall.enqueue(new Callback<ProjectResponse>() {

            @Override
            public void onResponse(Call<ProjectResponse> call, Response<ProjectResponse> response) {

                List<projectData> pl = response.body().getList();
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(new projectAdapter(pl, R.layout.active_projects_item));
            }

            @Override
            public void onFailure(Call<ProjectResponse> call, Throwable t) {
                Log.d("Error" , t.getMessage());
                Toast.makeText(getView().getContext(), "Try to connect to Internet!", Toast.LENGTH_LONG).show();
            }
        });
    }
}