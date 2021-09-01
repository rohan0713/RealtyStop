package com.example.realestate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestate.activities.details_screen;
import com.squareup.picasso.Picasso;

import java.util.List;

public class projectAdapter extends RecyclerView.Adapter<projectAdapter.projectViewHolder> {

    Context context;
    List<projectData> projects;
    int layout;

    @NonNull
    @Override
    public projectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
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

    public projectAdapter(List<projectData> projects, int layout){
        this.projects = projects;
        this.layout = layout;
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
            Picasso.get().load(property.image).placeholder(R.drawable.loading).fit().into(property_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(view.getContext(), details_screen.class);
                    i.putExtra("name" , property.name);
                    i.putExtra("price" , property.price);
                    i.putExtra("location" , property.place);
                    i.putExtra("owner" , property.agent);
                    i.putExtra("image" , property.image);
                    i.putExtra("description" , property.description);
                    i.putExtra("address", property.address);
                    i.putExtra("number", property.number);
                    view.getContext().startActivity(i);
                }
            });
        }
    }

    public void getProjects(List<projectData> projects)
    {
        this.projects = projects;
    }
}
