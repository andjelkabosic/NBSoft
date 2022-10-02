package com.example.nbsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetaljiProizvoda extends AppCompatActivity {

    private TextView brand;
    private TextView name;
    private TextView price;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji_proizvoda);

        brand = findViewById(R.id.ime);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        image = findViewById(R.id.image);

        String ime = getIntent().getStringExtra("Ime");
        String brend = getIntent().getStringExtra("Brend");
        String cena = getIntent().getStringExtra("Cena");
        String slika = getIntent().getStringExtra("Slika");

        name.setText(ime);
        brand.setText(brend);
        price.setText(cena);
        Glide.with(this).load(slika).into(image);


    }
}
