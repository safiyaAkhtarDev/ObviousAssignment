package com.safiya.obviousassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity {
    ArrayList<GridImages> gridImagesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        gridImagesArrayList= getIntent().<GridImages>
                getParcelableArrayListExtra("gridImagesArrayList");


        CardStackView cardStackView = findViewById(R.id.stack_view);
        cardStackView.setLayoutManager(new CardStackLayoutManager(this));
        cardStackView.setAdapter(new CardStackAdapter(this,gridImagesArrayList));
    }
}