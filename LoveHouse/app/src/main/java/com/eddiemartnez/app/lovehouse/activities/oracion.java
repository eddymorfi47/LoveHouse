package com.eddiemartnez.app.lovehouse.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.eddiemartnez.app.lovehouse.R;

public class oracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oracion);


        final android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


    }


    public void ora(View view) {

        Toast.makeText (oracion.this ,"Petición Enviada.", Toast.LENGTH_LONG).show();
        finish();
    }
}
