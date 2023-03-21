package com.example.playfy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class songs_library_activity2 extends AppCompatActivity implements ItemClickListner{

    Button Like ; // to like artist
    int count = 1 ;// variable to change button background and conditions
    ModelClass2nd[] Song_List ; // Data source array
    RecyclerView recyclerView ; // recycler view
    TextView _lastSavedSong_  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_library2);


        Like = findViewById(R.id.LikeBTN) ; // initializing like button
        Like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++ ;
                if(count%2 == 0) {
                    Like.setBackground(getDrawable(R.drawable.baseline_favorite_24));
                    Snackbar.make(view , "Liked" , Snackbar.LENGTH_LONG).show();
                }
                else
                    Like.setBackground(getDrawable(R.drawable.baseline_favorite_border_24)) ;
            }
        });

        // initializing recycler view
        recyclerView = findViewById(R.id.songs_recycler_view_1st) ;

        // initializing data source
        Song_List = new ModelClass2nd[]{
                new ModelClass2nd(R.drawable.arash_1 , "Broken Angel" , "1") ,
                new ModelClass2nd(R.drawable.arash_2 , "One Night" , "2") ,
                new ModelClass2nd(R.drawable.arash_3 , "Angels Lullaby" , "3") ,
                new ModelClass2nd(R.drawable.arash_4 , "One Day" , "4")
        } ;

        AdapterClass2nd adapterClass2nd = new AdapterClass2nd(Song_List) ;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterClass2nd);
        adapterClass2nd.setItemClickListner(this);
        _lastSavedSong_ = findViewById(R.id.lastSong) ;
        DisplayingSavedText() ;
    }

    @Override
    public void onCLick(View view, int pos) {
        Intent i = new Intent(this , playerActivity.class) ;
        i.putExtra("NameOfSong" , Song_List[pos].getText()) ;
        i.putExtra("NameOfLib" , "Arash") ;
        String x = Song_List[pos].getText() ;
        _lastSavedSong_.setText(x);
        SaveClickedText(x) ;
        startActivity(i);
    }
    public void SaveClickedText(String x){
        SharedPreferences shared = getSharedPreferences("LastPlayed" ,
                MODE_PRIVATE) ;
        SharedPreferences.Editor editor = shared.edit() ;
        editor.putString("KEY2" , x) ;
        editor.commit() ;
    }
    public void DisplayingSavedText(){
        SharedPreferences shared = getSharedPreferences("LastPlayed" ,
                MODE_PRIVATE) ;
        String text = shared.getString("KEY2" , " ") ;
        _lastSavedSong_.setText(text);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
