package com.example.realestate;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class buyFragment extends Fragment {

    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy, container, false);

        TextView viewAll = view.findViewById(R.id.viewAll);
        viewAll.setPaintFlags(viewAll.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView service_recyclerview = view.findViewById(R.id.recyclerView2);
        service_recyclerview.setLayoutManager(new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.HORIZONTAL,false));

        ArrayList<dummyData> projects = new ArrayList<>();
        projects.add(new dummyData(1, R.drawable.mahadev,
                "Rs.60Lacs", "Mahadev Apartment", "Uttam Nagar, New Delhi-08",
                "Mahadev Builders and Developers provides you Luxury 2, 3 & 4 BHK Builder Floors Apartment at Mahadev Apartment in the heart Dwarka (Sector - 23).",
                "Mr. Sudhir Kumar", "9787383832"));

        projects.add(new dummyData(2, R.drawable.sb_residency,
                "Rs.13lac - Rs.62lac", "SB Residency", "Dwarka Mor, New Delhi-08",
                "SB Residency Project is one of the popular residential projects that is located in Dwarka Mor, New Delhi. This project offers 1, 2, 3 & 4 BHK Luxurious builder floor with modern amenities for the comfort of residents.",
                "Mr. Sanjay", "9233997832"));

        projects.add(new dummyData(3, R.drawable.amprapali,
                "Rs.22lac - Rs.50Lac", "Amrapalis", "karol Bagh, New Delhi-08",
                "Mahadev Builders and Developers provides you Luxury 2, 3 & 4 BHK Builder Floors Apartment at Mahadev Apartment in the heart Dwarka (Sector - 23).",
                "Mr. Sudhir Kumar", "9787383832"));

        projects.add(new dummyData(4, R.drawable.pratap_homes,
                "Rs.60Lacs", "Mahadev Apartment", "Uttam Nagar, New Delhi-08",
                "Mahadev Builders and Developers provides you Luxury 2, 3 & 4 BHK Builder Floors Apartment at Mahadev Apartment in the heart Dwarka (Sector - 23).",
                "Mr. Sudhir Kumar", "9787383832"));

        projects.add(new dummyData(5, R.drawable.priya_apartment,
                "Rs.60Lacs", "Mahadev Apartment", "Uttam Nagar, New Delhi-08",
                "Mahadev Builders and Developers provides you Luxury 2, 3 & 4 BHK Builder Floors Apartment at Mahadev Apartment in the heart Dwarka (Sector - 23).",
                "Mr. Sudhir Kumar", "9787383832"));

        projects.add(new dummyData(6, R.drawable.mitya_homes,
                "Rs.60Lacs", "Mahadev Apartment", "Uttam Nagar, New Delhi-08",
                "Mahadev Builders and Developers provides you Luxury 2, 3 & 4 BHK Builder Floors Apartment at Mahadev Apartment in the heart Dwarka (Sector - 23).",
                "Mr. Sudhir Kumar", "9787383832"));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new projectAdapter(projects));

        ArrayList<serviceData> services = new ArrayList<>();
        services.add(new serviceData("#C9A0B6", "Bungalow", R.drawable.bungalow));
        services.add(new serviceData("#3C8DAD", "Flats", R.drawable.apartment));
        services.add(new serviceData("#343A40", "FarmHouse", R.drawable.farmhouse));
        services.add(new serviceData("#CEE5D0", "Rent", R.drawable.rent));
        services.add(new serviceData("#346751", "Plots", R.drawable.plots));

        service_recyclerview.setHasFixedSize(true);
        service_recyclerview.setAdapter(new serviceAdapter(services));
        return view;
    }
}