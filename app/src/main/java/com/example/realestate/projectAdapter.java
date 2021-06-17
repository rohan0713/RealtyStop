package com.example.realestate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class projectAdapter extends RecyclerView.Adapter<projectAdapter.projectViewHolder> {

    ArrayList<dummyData> projects;

    @NonNull
    @Override
    public projectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, parent, false);
        return new projectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull projectAdapter.projectViewHolder holder, int position) {

        holder.Bind(projects.get(position));
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    projectAdapter(ArrayList<dummyData> projects){
        this.projects = projects;
    }

    public static class projectViewHolder extends RecyclerView.ViewHolder {

        public projectViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void Bind(dummyData property){

            TextView price = itemView.findViewById(R.id.price);
            price.setText(property.price);

            TextView property_name = itemView.findViewById(R.id.name);
            property_name.setText(property.name);

            TextView state = itemView.findViewById(R.id.state);
            state.setText(property.place);

            ImageView property_image = itemView.findViewById(R.id.buildingIMage);
            property_image.setImageResource(property.image);
        }
    }
}
