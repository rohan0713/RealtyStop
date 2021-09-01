package com.example.realestate;

import java.util.List;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Retrofit {

    private static final String base_url = "http://10.0.2.2:3000/";

    public static Services Services = null;
    public static Services GetServices(){

        if(Services == null){

            retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Services = retrofit.create(Services.class);
        }
        return Services;
    }
    public interface Services{

        @GET("projects")
        Call<List<projectData>> getProjectsInfo();

        @GET("activeProjects")
        Call<List<projectData>> getActiveProjects();
    }
}
