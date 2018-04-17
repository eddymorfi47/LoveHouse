package com.eddiemartnez.app.lovehouse.db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.eddiemartnez.app.lovehouse.R;
import com.raizlabs.android.dbflow.config.FlowManager;

public class objeto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);
        FlowManager.init(this);
    }
}
