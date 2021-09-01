package com.example.realestate.roomFiles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.realestate.projectData;
import com.example.realestate.roomFiles.projectRepository;
import com.example.realestate.serviceData;

import java.util.List;

public class projectViewmodel extends AndroidViewModel {

    private final projectRepository Repository;
    private final LiveData<List<projectData>> getProjects;

    public projectViewmodel(@NonNull Application application) {
        super(application);
        Repository = new projectRepository(application);
        getProjects = Repository.getAllProjects();
    }

    public void insert(List<projectData> list)
    {
        Repository.insert(list);
    }

    public LiveData<List<projectData>> getProjects()
    {
        return getProjects;
    }

    public LiveData<List<projectData>> searchResult(Application application, String place){
        return Repository.getSearched(application, place);
    }

    public LiveData<List<projectData>> service(Application application, String type){
        return Repository.getList(application, type);
    }
}
