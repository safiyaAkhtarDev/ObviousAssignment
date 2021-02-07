package com.safiya.obviousassignment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GridImagesAdapter extends RecyclerView.Adapter<GridImagesAdapter.ViewHolder> {

    Context context;
    ArrayList<GridImages> gridlist = new ArrayList<>();
    private long mLastClickTime = 0;

    public GridImagesAdapter(Context context, ArrayList<GridImages> gridlist) {
        this.context = context;
        this.gridlist = gridlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_list_grid, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d("safiyas sorted date",gridlist.get(position).getDate());

        Glide.with(context).load(gridlist.get(position).getUrl()).into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we want the clicked image to show first...
                GridImages gridImages=gridlist.get(position);
                gridlist.remove(position);
                gridlist.add(0,gridImages);
                Intent intent=new Intent(context,DescriptionActivity.class);
                intent.putParcelableArrayListExtra("gridImagesArrayList",gridlist);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gridlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

        }
    }
}

