package com.example.playfy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity2 extends AppCompatActivity implements ItemClickListner {

    TextView greet ; // Greeting Textview
    RecyclerView recyclerView ; // Recycler view
    ModelClass1st[] listData ; // data source
    Button _logInPage_ ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        greet = findViewById(R.id.txt1) ; // Initializing Greeting Textview
        _logInPage_ = findViewById(R.id._LOGINPAGE_) ;
        _logInPage_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() , edit_profile.class));
            }
        });
        ConstraintLayout LayOut = findViewById(R.id._layout_) ;
        // Greeting -
        Calendar c = Calendar.getInstance() ;
        int Hour = c.get(Calendar.HOUR_OF_DAY) ;
        if( (Hour >= 1 && Hour <= 4)
            || (Hour >= 21 && Hour <= 23)
                || Hour == 0 ) {
            greet.setText("Good night");
            LayOut.setBackground(getDrawable(R.drawable._drawable_gradient_2nd));

        }
        else if(Hour >= 5 && Hour <= 11) {
            greet.setText("Good Morning");
            LayOut.setBackground(getDrawable(R.drawable.gradient2nd));
        }
        else if(Hour >=12 && Hour <= 14)
            greet.setText("Good noon");
        else if(Hour >= 15 && Hour <= 17)
            greet.setText("Good afternoon");
        else if(Hour >= 18 && Hour <= 20) {
            greet.setText("Good evening");
            LayOut.setBackground(getDrawable(R.drawable._drawable_gradient_2nd));
            greet.setTextColor(getColor(R.color.white));
        }
        recyclerView = findViewById(R.id.recyclerView1st) ;

        listData = new ModelClass1st[]{
                new ModelClass1st(R.drawable._liked_songs_bg, "Liked Songs" , songs_library_activity4.class ,
                        getDrawable(R.drawable.verticle_color_4)
                        ,getDrawable(R.drawable.horizontal_color_4)),
                new ModelClass1st(R.drawable.new_bg_2_alan , "Alan Walker" , songs_library_activity1.class ,
                        getDrawable(R.drawable.verticle_color_1)
                        ,getDrawable(R.drawable.horizontal_color_1)) ,
                new ModelClass1st(R.drawable.arash_2 , "Arash" , songs_library_activity2.class ,
                        getDrawable(R.drawable.verticle_color_2)
                        ,getDrawable(R.drawable.horizontal_color_2)) ,
                new ModelClass1st(R.drawable._lofi_bg_ , "Lofi beats" , songs_library_activity3.class ,
                        getDrawable(R.drawable.verticle_color_3)
                        ,getDrawable(R.drawable.horizontal_color_3))
        } ;

        AdapterClass1st adapterClass1st = new AdapterClass1st(listData) ;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterClass1st) ;
        adapterClass1st.setItemClickListner(this);
    }


    @Override
    public void onCLick(View view, int pos) {
        startActivity(new Intent(getApplicationContext() , listData[pos].name));
    }
}