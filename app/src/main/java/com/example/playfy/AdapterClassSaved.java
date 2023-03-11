package com.example.playfy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClassSaved extends ArrayAdapter<ModelClassSaved> {

    public AdapterClassSaved(Context context, List<ModelClassSaved> _list_) {
        super(context, 0 , _list_);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ModelClassSaved modelClassSaved = getItem(position) ;
        if(convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.alan_walker_list , parent , false) ;

        TextView songname = convertView.findViewById(R.id.arash_song_name) ;
        TextView index = convertView.findViewById(R.id.indexing) ;
        ImageView imageView = convertView.findViewById(R.id.arash_image_view) ;
        songname.setText(" "+modelClassSaved.getText());
        imageView.setImageResource(modelClassSaved.getImage());
        index.setText(" "+(ModelClassSaved._list.indexOf(modelClassSaved)+1));
        return convertView;
    }
}

