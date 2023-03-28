package com.example.playfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView _logo_ ;
    ImageView _load_ ;
    TextView _txt_ ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _logo_ = findViewById(R.id.imageView4) ;
        _load_ = findViewById(R.id._load_) ;
        _txt_ = findViewById(R.id.application_name) ;
        _logo_.setAnimation(AnimationUtils.loadAnimation(this , R.anim._fade_));
        _txt_.setAnimation(AnimationUtils.loadAnimation(this , R.anim._blink_));
        _load_.setAnimation(AnimationUtils.loadAnimation(this , R.anim.rotate));

        new Handler().postDelayed(() -> {
            MediaPlayer.create(this , R.raw.welcome).start();
            startActivity(new Intent(getApplicationContext() , MainActivity2.class));
            finish();
        }, 1400) ;
    }
}