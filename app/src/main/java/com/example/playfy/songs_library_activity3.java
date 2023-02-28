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

import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;
import jp.wasabeef.recyclerview.animators.FadeInUpAnimator;

public class songs_library_activity3 extends AppCompatActivity implements ItemClickListner{

    Button Back ; // to go back to previous page
    Button Like ; // to like artist
    int count = 1 ;// variable to change button background and conditions
    ModelClass2nd[] Song_List ; // Data source array
    RecyclerView recyclerView ; // recycler view
    TextView _lastSavedSong_  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_library3);

        Back = findViewById(R.id.backBTN) ; // Initialize back button
        // setting on click event for back button
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
                new ModelClass2nd(R.drawable.lofi_bg , "Emerging" , "1") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Concrete Dreams" , "2") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Outside World" , "3") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Longing" , "4") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Feels Like Flying" , "5") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Lemon Affair" , "6") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Blue Light" , "7") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Flora" , "8") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Flying Dreams" , "9") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Econto" , "10") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Puzzle pieces" , "11") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Fauna" , "12") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Firj" , "13") ,
                new ModelClass2nd(R.drawable.lofi_bg , "High Rise" , "14") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Field Guide" , "15") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Axiom" , "16") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Dad Shoes" , "17") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Dream Catcher" , "18") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Lilac" , "19") ,
                new ModelClass2nd(R.drawable.lofi_bg , "Sleepy Eyes" , "20") ,
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
        i.putExtra("NameOfLib" , "Lofi beats") ;
        i.putExtra("position" , pos) ;
        String x = Song_List[pos].getText() ;
        _lastSavedSong_.setText(x);
        SaveClickedText(x) ;
        startActivity(i);
    }
    public void SaveClickedText(String x){
        SharedPreferences shared = getSharedPreferences("LastPlayed" ,
                MODE_PRIVATE) ;
        SharedPreferences.Editor editor = shared.edit() ;
        editor.putString("KEY3" , x) ;
        editor.commit() ;
    }
    public void DisplayingSavedText(){
        SharedPreferences shared = getSharedPreferences("LastPlayed" ,
                MODE_PRIVATE) ;
        String text = shared.getString("KEY3" , " ") ;
        _lastSavedSong_.setText(text);
    }
}