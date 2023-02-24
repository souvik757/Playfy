package com.example.playfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(() -> {
            MediaPlayer.create(this , R.raw.welcome).start();
            startActivity(new Intent(getApplicationContext() , MainActivity2.class));
            finish();
        }, 1400) ;
    }
}