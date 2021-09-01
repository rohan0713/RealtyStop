package com.example.realestate.roomFiles;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.realestate.projectData;
import com.example.realestate.roomFiles.database;
import com.example.realestate.roomFiles.projectDAO;
import com.example.realestate.serviceData;

import java.util.List;

public class projectRepository {

    private final database projectDatabase;
    private final LiveData<List<projectData>> getProjects;

    public projectRepository(Application application)
    {
        projectDatabase=database.getInstance(application);
        getProjects=projectDatabase.projectDAO().showProjects();
    }

    public LiveData<List<projectData>> getAllProjects()
    {
        return getProjects;
    }

    public LiveData<List<projectData>> getSearched(Application application, String place){

        return database.getInstance(application).projectDAO().getThem(place);
    }

    public LiveData<List<projectData>> getList(Application application, String type){

        return database.getInstance(application).projectDAO().getList(type);
    }

    public void insert(List<projectData> ProjectsList){
        new InsertAsynTask(projectDatabase).execute(ProjectsList);
    }

    static class InsertAsynTask extends AsyncTask<List<projectData>,Void,Void> {
        private final projectDAO ProjectDao;
        InsertAsynTask(database ProjectDatabase)
        {
            ProjectDao = ProjectDatabase.projectDAO();
        }

        @Override
        protected Void doInBackground(List<projectData>... lists) {
            ProjectDao.insert(lists[0]);
            return null;
        }
    }
}
