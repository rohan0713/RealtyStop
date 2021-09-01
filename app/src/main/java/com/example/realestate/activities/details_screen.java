package com.example.realestate.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.realestate.R;
import com.squareup.picasso.Picasso;

public class details_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Button enq = findViewById(R.id.enquiry);
        TextView name = findViewById(R.id.property_name);
        TextView price = findViewById(R.id.property_price);
        TextView location = findViewById(R.id.property_location);
        TextView owner = findViewById(R.id.owner_name);
        ImageView image = findViewById(R.id.poster_image);
        TextView address = findViewById(R.id.address);
        TextView description = findViewById(R.id.description);

//        ActionBar actionBar = getSupportActionBar();
//
//        assert actionBar != null;
//        actionBar.setTitle(getIntent().getStringExtra("name"));

        name.setText(getIntent().getStringExtra("name"));
        price.setText(getIntent().getStringExtra("price"));
        location.setText(getIntent().getStringExtra("location"));
        owner.setText(getIntent().getStringExtra("owner"));
        Picasso.get().load(getIntent().getStringExtra("image")).
                placeholder(R.drawable.loading).
                fit().into(image);
        description.setText(getIntent().getStringExtra("description"));
        address.setText("Address:\n" +getIntent().getStringExtra("address"));

        enq.setOnClickListener(v -> {
            String num = "tel:+91" + getIntent().getStringExtra("number");
            Uri uri = Uri.parse(num);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}