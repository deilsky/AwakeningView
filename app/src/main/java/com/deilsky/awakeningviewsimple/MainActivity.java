package com.deilsky.awakeningviewsimple;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.deilsky.awakening.widget.AwakeningView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AwakeningView.RectangleBuilder.create()
                .fillColor(ContextCompat.getColor(this,R.color.colorAccent))
                .strokeSize(ContextCompat.getColor(this,R.color.colorPrimary))
                .strokeSize(1)
                .connerAll(30)
                .build().target(findViewById(R.id.tv_main1),findViewById(R.id.tv_main2)).alpha(255).build();
    }
}
