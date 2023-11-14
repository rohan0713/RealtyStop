package com.example.realestate.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestate.R;
import com.example.realestate.models.projectData;
import com.example.realestate.ui.activities.details_screen;

import java.util.ArrayList;

public class activeProjectAdapter extends RecyclerView.Adapter<activeProjectAdapter.projectViewHolder> {

    Context context;
    ArrayList<projectData> projects;

    @NonNull
    @Override
    public projectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.active_projects_item, parent, false);
        return new projectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull projectViewHolder holder, int position) {

        holder.Bind(projects.get(position));
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public activeProjectAdapter(ArrayList<projectData> projects){
        this.projects = projects;
    }

    static class projectViewHolder extends RecyclerView.ViewHolder {

        public projectViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void Bind(projectData property){

            TextView price = itemView.findViewById(R.id.price);
            price.setText(property.price);

            TextView property_name = itemView.findViewById(R.id.name);
            property_name.setText(property.name);

            TextView state = itemView.findViewById(R.id.state);
            state.setText(property.place);

            ImageView property_image = itemView.findViewById(R.id.buildingIMage);
            property_image.setImageResource(R.drawable.mahadev);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(view.getContext(), details_screen.class);
                    i.putExtra("name" , property.name);
                    i.putExtra("price" , property.price);
                    i.putExtra("location" , property.place);
                    i.putExtra("owner" , property.agent);
                    i.putExtra("image" , R.drawable.mahadev);
                    i.putExtra("description" , property.description);
                    view.getContext().startActivity(i);
                }
            });
        }
    }
}
