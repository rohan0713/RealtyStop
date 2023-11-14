package com.example.realestate.models;

import java.util.List;

public class ProjectResponse {

    List<projectData> projects;

    public ProjectResponse(List<projectData> list) {
        this.projects = list;
    }

    public List<projectData> getList() {
        return projects;
    }

    public void setList(List<projectData> list) {
        this.projects = list;
    }
}
