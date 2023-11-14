package com.example.realestate.ui.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestate.R;
import com.example.realestate.models.projectData;
import com.example.realestate.models.serviceData;

import java.util.ArrayList;
import java.util.List;

public class serviceAdapter extends RecyclerView.Adapter<serviceAdapter.serviceViewHolder> {

    List<projectData> list;

    @Override
    public serviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services, parent, false);
        return new serviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull serviceViewHolder holder, int position) {

        holder.Bind(services.get(position));
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    ArrayList<serviceData> services;
    public serviceAdapter(ArrayList<serviceData> services){
        this.services = services;
    }

    public static class serviceViewHolder extends RecyclerView.ViewHolder{

        public serviceViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void Bind(serviceData service){

            TextView service_name = itemView.findViewById(R.id.service_name);
            service_name.setText(service.name);

            ImageView service_image = itemView.findViewById(R.id.service_image);
            service_image.setImageResource(service.image);

            CardView cardView = itemView.findViewById(R.id.cardView);
            cardView.setCardBackgroundColor(Color.parseColor(service.background_color));

        }
    }
}
