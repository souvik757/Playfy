package com.example.playfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class profile extends AppCompatActivity {
    Button BackToPrev , _edit_page_;
    TextView US ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        US = findViewById(R.id._user_name_) ;
        BackToPrev = findViewById(R.id._back_to_prev_) ;
        BackToPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish() ;
            }
        });
        _edit_page_ = findViewById(R.id._go_to_edit_page_) ;
        _edit_page_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() , edit_profile.class));
            }
        });
        Intent i0 = getIntent() ;
        String User_Name = i0.getStringExtra("USER NAME") ;
        US.setText(User_Name);
    }
}