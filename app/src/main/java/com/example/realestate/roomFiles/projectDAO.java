package com.example.realestate.roomFiles;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.realestate.projectData;
import com.example.realestate.serviceData;

import java.util.List;

@Dao
public interface projectDAO {

    @Query("Select * from projects")
    LiveData<List<projectData>> showProjects();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<projectData> projectList);

    @Query("Select * from projects where place = :place")
    LiveData<List<projectData>> getThem(String place);

    @Query("Select * from projects where type = :type")
    LiveData<List<projectData>> getList(String type);
}
