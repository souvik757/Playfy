package com.example.playfy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.TimeUnit;

public class playerActivity extends AppCompatActivity {

    TextView _song_  , _progressTimer_ , _timeView_ , _current_status_ , _lib_name_ ;
    Button _play_ , _fast_ , _back_ , _page_back_ ;
    MediaPlayer player ;
    ImageView imageView ;
    SeekBar progressbar ;
    int count = 1 ;

    // variables to handle seekbar and timer :
    double startTime = 0 ;
    double finalTime = 0 ;
    int OneTimeOnly = 0 ;
    int forwardTime = 4000 ;
    int backwardTime = 4000 ;

    // variable to handle first time player
    int _first_open_ = -1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        _first_open_++ ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        _song_ = findViewById(R.id.songName) ;
        _play_ = findViewById(R.id.playBTN) ;
        _fast_ = findViewById(R.id.fast) ;
        _back_ = findViewById(R.id.back) ;
        imageView = findViewById(R.id.imageView2) ;
        _timeView_ = findViewById(R.id.TimeView) ;
        _progressTimer_ = findViewById(R.id.StartTime) ;
        progressbar = findViewById(R.id.seekBar) ;
        _current_status_ = findViewById(R.id.status) ;
        _lib_name_ = findViewById(R.id.LibName) ;
        _page_back_ = findViewById(R.id.backBTN) ;
        progressbar.setClickable(false) ;

        Intent i = getIntent() ;
        int Adapter_position = i.getIntExtra("position" , 0) ;
        String lib_context = i.getStringExtra("NameOfLib") ;
        _lib_name_.setText(lib_context);
        String _Song_Name_ = i.getStringExtra("NameOfSong") ;
        //---
        if (_Song_Name_.equals("Above The Sky")){
            _song_.setText("Above The Sky");
            player = MediaPlayer.create(getApplicationContext(), R.raw._above_the_sky_);
            imageView.setImageResource(R.drawable.new_bg_1_alan);
        }
        if(_Song_Name_.equals("Dennis")){
            _song_.setText("Dennis");
            player = MediaPlayer.create(getApplicationContext() , R.raw._dennis_) ;
            imageView.setImageResource(R.drawable.new_bg_1_alan);
        }
        if(_Song_Name_.equals("Faded")){
            _song_.setText("Faded");
            player = MediaPlayer.create(getApplicationContext() , R.raw._faded_) ;
            imageView.setImageResource(R.drawable.new_bg_1_alan);
        }
        if(_Song_Name_.equals("Flying Dreams")){
            _song_.setText("Flying Dreams");
            player = MediaPlayer.create(getApplicationContext() , R.raw._flying_dreams_) ;
            imageView.setImageResource(R.drawable.new_bg_1_alan);
        }
        if(_Song_Name_.equals("Golden Alley")){
            _song_.setText("Golden Alley");
            player = MediaPlayer.create(getApplicationContext() , R.raw._golden_alley_) ;
            imageView.setImageResource(R.drawable.new_bg_2_alan);
        }
        if(_Song_Name_.equals("Hymn For The Weekend")){
            _song_.setText("Hymn For The Weekend");
            player = MediaPlayer.create(getApplicationContext() , R.raw._hymn_for_the_weekend_) ;
            imageView.setImageResource(R.drawable.new_bg_2_alan);
        }
        if(_Song_Name_.equals("Sing me to sleep")){
            _song_.setText("Sing me to sleep");
            player = MediaPlayer.create(getApplicationContext() , R.raw._sing_me_to_sleep_) ;
            imageView.setImageResource(R.drawable.new_bg_2_alan);
        }
        if(_Song_Name_.equals("Spectre")){
            _song_.setText("Spectre");
            player = MediaPlayer.create(getApplicationContext() , R.raw._spectre_) ;
            imageView.setImageResource(R.drawable.new_bg_2_alan);
        }
        //---
        if(_Song_Name_.equals("Broken Angel")){
            _song_.setText("Broken Angel");
            player = MediaPlayer.create(getApplicationContext() , R.raw.broken_angel) ;
            imageView.setImageResource(R.drawable.arash_1);
        }
        if(_Song_Name_.equals("One Night")){
            _song_.setText("One Night");
            player = MediaPlayer.create(getApplicationContext() , R.raw.one_night_in_dubai) ;
            imageView.setImageResource(R.drawable.arash_2);
        }
        if(_Song_Name_.equals("Angels Lullaby")){
            _song_.setText("Angels Lullaby");
            player = MediaPlayer.create(getApplicationContext() , R.raw.angels_lullaby) ;
            imageView.setImageResource(R.drawable.arash_3);
        }
        if(_Song_Name_.equals("One Day")){
            _song_.setText("One Day");
            player = MediaPlayer.create(getApplicationContext() , R.raw.one_day_i_am_gonna_fly_away) ;
            imageView.setImageResource(R.drawable.arash_4);
        }
        //---
        if(_Song_Name_.equals("Emerging")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._emerging_1) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Concrete Dreams")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._concrete_dreams_2) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Outside World")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._outside_world_3) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Longing")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._longing_4) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Feels Like Flying")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._feels_like_flying_5) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Lemon Affair")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._lemon_love_affair_6) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Blue Light")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._blue_light_7) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Flora")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._flora_8) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Flying Dreams")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._flying_dreams_) ;//9
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Econto")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._econto_10) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Puzzle pieces")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._puzzle_pieces_11) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Fauna")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._fauna_12) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Firj")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._firj_13) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("High Rise")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._high_rise_14) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Field Guide")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._field_guide_for_the_night_sky_15) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Axiom")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._axiom_16) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Dad Shoes")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._dad_shoes_17) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Dream Catcher")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._dreamcatcher_18) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Lilac")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._lilac_19) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        if(_Song_Name_.equals("Sleepy Eyes")){
            _song_.setText(_Song_Name_);
            player = MediaPlayer.create(getApplicationContext() , R.raw._sleepy_eyes_20) ;
            imageView.setImageResource(R.drawable.lofi_bg);
        }
        //---


        if(_first_open_ == 0) {
            _current_status_.setText("playing");
            player.start();
            ProgressSeekBar();
        }
        _play_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++ ;
                if(count%2 != 0) {
                    _play_.setBackground(getDrawable(R.drawable.baseline_pause_circle_24));
                    _current_status_.setText("playing");
                    player.start();
                    ProgressSeekBar();
                }
                else
                {
                    _play_.setBackground(getDrawable(R.drawable.baseline_play_circle_24));
                    _current_status_.setText("paused");
                    player.pause();
                }
            }
        });
// skip 4 second's -->
        _fast_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = (int) startTime ;
                if((temp+forwardTime) > finalTime)
                    Snackbar.make(view , "can't jump forward" , Snackbar.LENGTH_LONG).show();
                else{
                    startTime += forwardTime ;
                    player.seekTo((int) startTime);
                    Snackbar.make(view , "4 sec's" , Snackbar.LENGTH_LONG).show() ;
                }
            }
        });
// backward 4 second's -->
        _back_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = (int) startTime ;
                if((temp-backwardTime) > 0)
                {
                    startTime -= backwardTime ;
                    player.seekTo((int) startTime);
                    Snackbar.make(view , "4 sec's" , Snackbar.LENGTH_LONG).show() ;
                }
                else
                    Snackbar.make(view , "can't go back" , Snackbar.LENGTH_LONG).show();
            }
        });

        _page_back_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish() ;
                player.stop();
            }
        });
    }
    public void ProgressSeekBar(){
        startTime = player.getCurrentPosition() ;
        finalTime = player.getDuration() ;
        if(OneTimeOnly == 0)
        {
            progressbar.setMax((int) finalTime);
            OneTimeOnly = 1 ;
        }
        _timeView_.setText(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)+" : "+
                (TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
        progressbar.setProgress((int) startTime) ;
        new Handler().postDelayed(UpdateSongTime , 100) ;
    }
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            startTime = player.getCurrentPosition() ;
            _progressTimer_.setText(TimeUnit.MILLISECONDS.toMinutes((long) startTime)+" : "+
                    (TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))));
            progressbar.setProgress((int) startTime) ;
            new Handler().postDelayed(this , 100) ;
        }
    } ;

    // back press events :
    public boolean onKeyDown(int KeyCode , KeyEvent event){
        if(KeyCode == KeyEvent.KEYCODE_BACK){
            onBackPressed();
            finish() ;
            player.stop();
            return true ;
        }
        return super.onKeyDown(KeyCode , event);
    }
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.up_to_down , R.anim.down_to_up);
    }
}