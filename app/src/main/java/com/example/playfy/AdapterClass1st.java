package com.example.playfy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterClass1st extends RecyclerView.Adapter<AdapterClass1st.MyViewHolder> {


    // 4 .
    private ItemClickListner itemClickListner ;

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    // 1 . Data Source :
    private ModelClass1st[] ListData ;

    public AdapterClass1st(ModelClass1st[] Listdata){ this.ListData = Listdata ; }


    // 2 . Making My View holder :
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView img ;
        public TextView  text ;
        public View view_1 ;
        public View view_2 ;

        public MyViewHolder(View listItem){
            super(listItem);
            img = listItem.findViewById(R.id.imageView) ;
            text = listItem.findViewById(R.id.txtSong) ;
            view_1 = listItem.findViewById(R.id.custom_color1) ;
            view_2 = listItem.findViewById(R.id.custom_color2) ;
            listItem.setOnClickListener(this);
        }

        // click listener method
        @Override
        public void onClick(View view) {
            if(itemClickListner != null){
                itemClickListner.onCLick(view , getAdapterPosition());
            }
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()) ;
        View listItem = layoutInflater.inflate(R.layout.my_list_view , parent , false) ;
        MyViewHolder ViewHolder = new MyViewHolder(listItem) ;
        return ViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ModelClass1st MyListdata = ListData[position] ;
        holder.text.setText(ListData[position].getText());
        holder.img.setImageResource(ListData[position].getImage());
        holder.view_1.setBackground(ListData[position].getDrawable1());
        holder.view_2.setBackground(ListData[position].getDrawable2());
    }

    @Override
    public int getItemCount() {
        return ListData.length ;
    }


}
