package com.example.realestate.roomFiles;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.realestate.projectData;

@Database(entities = {projectData.class} , version = 4)
public abstract class database extends RoomDatabase {

    public abstract projectDAO projectDAO();
    public static final String Database_Name = "Database";

    private static volatile database instance;

    public static database getInstance(Context context){

            synchronized (database.class){
                if(instance == null)
                {
                    instance= Room.databaseBuilder(context,database.class,
                            Database_Name)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        return instance;
    }

    static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(instance);
        }
    };
    static class PopulateAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private final projectDAO projectDAO;
        PopulateAsyncTask(database countryDatabase)
        {
            projectDAO = countryDatabase.projectDAO();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
