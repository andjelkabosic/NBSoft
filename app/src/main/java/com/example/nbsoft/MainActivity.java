package com.example.nbsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private final int DELAY_MILLIS = 7000;
    private void stopAnimation(AnimationDrawable anim, int time){
        final AnimationDrawable a = anim;
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
             a.stop();
            Intent intent = new Intent(MainActivity.this, ListaProizvoda.class);
            MainActivity.this.startActivity(intent);
            MainActivity.this.finish();
            }
        }, time);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.main);
        AnimationDrawable animacija = (AnimationDrawable) layout.getBackground();
        animacija.setEnterFadeDuration(DELAY_MILLIS);
        animacija.setExitFadeDuration(DELAY_MILLIS);
        animacija.start();
        stopAnimation(animacija, DELAY_MILLIS);
    }
}
