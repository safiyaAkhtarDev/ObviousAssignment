package com.safiya.obviousassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    Context context;
    ArrayList<GridImages> gridlist = new ArrayList<>();
    private long mLastClickTime = 0;

    public CardStackAdapter(Context context, ArrayList<GridImages> gridlist) {
        this.context = context;
        this.gridlist = gridlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.swipabble_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(gridlist.get(position).getUrl()).into(holder.image);
        holder.txt_title.setText(gridlist.get(position).getTitle());
        holder.txt_description.setText(gridlist.get(position).getExplanation());

    }

    @Override
    public int getItemCount() {
        return gridlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView image;
        private TextView txt_title, txt_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_description = itemView.findViewById(R.id.txt_description);

        }
    }
}

