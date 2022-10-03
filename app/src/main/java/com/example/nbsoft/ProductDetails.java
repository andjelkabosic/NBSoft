package com.example.nbsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductDetails extends AppCompatActivity {

    private TextView brandView;
    private TextView nameView;
    private TextView priceView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        brandView = findViewById(R.id.brand);
        nameView = findViewById(R.id.name);
        priceView = findViewById(R.id.price);
        imageView = findViewById(R.id.image);

        String name = getIntent().getStringExtra("Name");
        String brand = getIntent().getStringExtra("Brand");
        String price = getIntent().getStringExtra("Price");
        String image = getIntent().getStringExtra("Image");

        nameView.setText(name);
        brandView.setText(brand);
        priceView.setText(price+" $");
        Glide.with(this).load(image).into(imageView);


    }
}
