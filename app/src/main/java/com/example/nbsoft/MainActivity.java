package com.example.nbsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private final int DELAY_MILLIS = 5100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.plavo));

        ConstraintLayout layout = findViewById(R.id.main);
        AnimationDrawable animacija = (AnimationDrawable) layout.getBackground();
        animacija.setEnterFadeDuration(5000);
        animacija.setExitFadeDuration(5000);
        animacija.start();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this, ListaProizvoda.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }, DELAY_MILLIS);
    }
}
