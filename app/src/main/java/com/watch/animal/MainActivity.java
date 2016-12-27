package com.watch.animal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mainCardView)
                .setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, WatchDetailActivity.class));
    }
}
