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
            Intent intent = new Intent(MainActivity.this, ProductList.class);
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
        AnimationDrawable animation = (AnimationDrawable) layout.getBackground();
        animation.setEnterFadeDuration(DELAY_MILLIS);
        animation.setExitFadeDuration(DELAY_MILLIS);
        animation.start();
        stopAnimation(animation, DELAY_MILLIS);
    }
}
