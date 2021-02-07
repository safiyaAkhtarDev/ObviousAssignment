package com.safiya.obviousassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<GridImages> gridImagesArrayList;
    RecyclerView recycler_offer;
    GridImagesAdapter gridImagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_offer = findViewById(R.id.recycler_offer);


        gridImagesArrayList = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                GridImages gridImages = new GridImages();
                gridImages.setDate(jsonObject.getString("date"));
                gridImages.setExplanation(jsonObject.getString("explanation"));
                gridImages.setUrl(jsonObject.getString("url"));
                gridImages.setHdurl(jsonObject.getString("hdurl"));
                gridImages.setMedia_type(jsonObject.getString("media_type"));
                gridImages.setService_version(jsonObject.getString("service_version"));
                gridImages.setTitle(jsonObject.getString("title"));
                gridImagesArrayList.add(gridImages);
            }
            recycler_offer.setLayoutManager(new GridLayoutManager(this, 2));

            Collections.sort(gridImagesArrayList, new StringDateComparator());

            gridImagesAdapter = new GridImagesAdapter(this, gridImagesArrayList);
            recycler_offer.setAdapter(gridImagesAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}