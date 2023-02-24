package com.example.playfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

import java.util.zip.Inflater;

public class edit_profile extends AppCompatActivity {
    EditText _name_  , _email_;
    TextView name  , email ;
    Button Save ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        _name_ = findViewById(R.id._user_name_) ;
        name = findViewById(R.id._show_name) ;
        _email_ = findViewById(R.id._user_email_) ;
        email = findViewById(R.id._show_email_) ;
        Save = findViewById(R.id._save_) ;

        if(name.getText().equals(" "))
            _name_.setHint("enter name");
        else
            _name_.setHint("edit name");

        if(email.getText().equals(" "))
            _email_.setHint("enter email");
        else
            _email_.setHint("edit email");



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = _name_.getText().toString() ;
                String y = _email_.getText().toString() ;
                name.setText(x);
                email.setText(y);
                SaveClickedName(x);
                SaveClickedEmail(y);
            }
        });
        DisplayingSavedName();
        DisplayingSavedEmail();
    }
    public void SaveClickedName(String x){
        SharedPreferences shared = getSharedPreferences("USER_NAME" ,
                MODE_PRIVATE) ;
        SharedPreferences.Editor editor = shared.edit() ;
        editor.putString("_User_Name_" , x) ;
        editor.commit() ;
    }
    public void SaveClickedEmail(String y){
        SharedPreferences shared = getSharedPreferences("USER_EMAIL" ,
                MODE_PRIVATE) ;
        SharedPreferences.Editor editor = shared.edit() ;
        editor.putString("_User_Email_" , y) ;
        editor.commit() ;
    }
    public void DisplayingSavedName(){
        SharedPreferences shared = getSharedPreferences("USER_NAME" ,
                MODE_PRIVATE) ;
        String text = shared.getString("_User_Name_" , " ") ;
        name.setText(text);
    }
    public void DisplayingSavedEmail(){
        SharedPreferences shared = getSharedPreferences("USER_EMAIL" ,
                MODE_PRIVATE) ;
        String text = shared.getString("_User_Email_" , " ") ;
        email.setText(text);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}