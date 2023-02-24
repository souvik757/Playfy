package com.example.playfy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterClass2nd extends RecyclerView.Adapter<AdapterClass2nd.MyViewHolder>{

    //1 . Data source :
    private ModelClass2nd[] listDATA;

    public AdapterClass2nd(ModelClass2nd[] listView) {
        this.listDATA = listView;
    }


    // 4 . Handling click events
    private ItemClickListner itemClickListner ;

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }



    //2 . My view holder class
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textView ;
        public TextView Indexes ;
        public ImageView imageView ;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.arash_song_name) ;
            imageView = itemView.findViewById(R.id.arash_image_view) ;
            Indexes = itemView.findViewById(R.id.indexing) ;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(itemClickListner != null){
                itemClickListner.onCLick(view , getAdapterPosition());
            }
        }
    }


    // 3 . implementing methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()) ;
        View listItem = layoutInflater.inflate(R.layout.alan_walker_list , parent , false) ;
        MyViewHolder viewHolder = new MyViewHolder(listItem) ;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ModelClass2nd MyListDATA = listDATA[position] ;
        holder.textView.setText(listDATA[position].getText());
        holder.imageView.setImageResource(listDATA[position].getImage());
        holder.Indexes.setText(listDATA[position].getIndex());
    }

    @Override
    public int getItemCount() {
        return listDATA.length;
    }
}
