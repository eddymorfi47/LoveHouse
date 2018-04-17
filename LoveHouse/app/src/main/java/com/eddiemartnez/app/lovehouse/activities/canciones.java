package com.eddiemartnez.app.lovehouse.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eddiemartnez.app.lovehouse.R;

public class canciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canciones);

        final android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }
}
