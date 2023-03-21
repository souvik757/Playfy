package com.example.playfy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class songs_library_activity4 extends AppCompatActivity {

    ListView _recycler_ ;
    // using ModelClass2nd as model class & respective adapter of same ->
    static ModelClassSaved[] _songs_ ;
    TextView _lastSavedSong_ ;
    Button _back_ ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_library4);

        _recycler_ = findViewById(R.id._recycler_liked_) ;
        _lastSavedSong_ = findViewById(R.id._lastsong_) ;
        _back_ = findViewById(R.id._back_) ;
        _back_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AdapterClassSaved adapterClassSaved = new AdapterClassSaved(this , ModelClassSaved._list);
        _recycler_.setAdapter(adapterClassSaved);
        _recycler_.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelClassSaved modelClassSaved =(ModelClassSaved) _recycler_.getItemAtPosition(position) ;
                Intent i = new Intent(getApplicationContext() , playerActivity.class) ;
                i.putExtra("NameOfSong" , ModelClassSaved._list.get(position).getText()) ;
                i.putExtra("NameOfLib" , "Liked Songs") ;
                String x = ModelClassSaved._list.get(position).getText() ;
                SaveClickedText(x) ;
                DisplayingSavedText() ;
                startActivity(i) ;
            }
        });
    }
    public void SaveClickedText(String x){
        SharedPreferences shared = getSharedPreferences("LastPlayed" ,
                MODE_PRIVATE) ;
        SharedPreferences.Editor editor = shared.edit() ;
        editor.putString("KEYLIKE" , x) ;
        editor.commit() ;
    }
    public void DisplayingSavedText(){
        SharedPreferences shared = getSharedPreferences("LastPlayed" ,
                MODE_PRIVATE) ;
        String text = shared.getString("KEYLIKE" , " ") ;
        _lastSavedSong_.setText(text);
    }
}