package com.deilsky.awakeningviewsimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.deilsky.awakening.widget.AwakeningView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AwakeningView.RectangleBuilder.create()
                .fillColor(R.color.colorAccent)
                .strokeColor(R.color.colorPrimary)
                .strokeSize(1)
                .connerAll(5)
                .build().target(findViewById(R.id.tv_main1))
                .alpha(255)
                .dashGap(5).dashWidth(10)
                .build();
        AwakeningView.RectangleBuilder.create()
                .fillColor(R.color.colorAccent)
                .strokeColor(R.color.colorPrimary)
                .strokeSize(1)
                .connerAll(5)
                .build().target(findViewById(R.id.tv_main2)).alpha(255).build();
        AwakeningView.CircleBuilder.create()
                .fillColor(R.color.colorAccent)
                .strokeColor(R.color.colorPrimary)
                .strokeSize(1).build().target(findViewById(R.id.tv_main3)).build();
    }
}
