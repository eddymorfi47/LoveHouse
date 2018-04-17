package com.eddiemartnez.app.lovehouse.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.eddiemartnez.app.lovehouse.UsersControl;
import com.eddiemartnez.app.lovehouse.util.Adapter;

import com.eddiemartnez.app.lovehouse.R;

public class MainActivity extends AppCompatActivity  {
private DrawerLayout mDrawerlayout;
private ActionBarDrawerToggle mToggle;
private NavigationView navigationView;
private Adapter mSectionsPagerAdapter;
private static Context QuickContext;
private static RecyclerView recyclerView;
private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);

        navigationView = findViewById(R.id.nav_view);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(navigationView !=null){
            setupDrawerContent(navigationView);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setupDrawerContent(NavigationView navigationView){

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i = item.getItemId();
                if(i == R.id.pray){
                    Intent  intent = new Intent(getApplication(),oracion.class);
                    startActivity(intent);
                }

                if(i == R.id.lyrics){
                    Intent  intent = new Intent(getApplication(),canciones.class);
                    startActivity(intent);
                }
                if(i == R.id.verse){
                    Intent  intent = new Intent(getApplication(),versiculo.class);
                    startActivity(intent);
                }
                if(i == R.id.social){
                    Intent  intent = new Intent(getApplication(),social.class);
                    startActivity(intent);
                }
                if(i == R.id.about){
                    Intent  intent = new Intent(getApplication(),acerca.class);
                    startActivity(intent);
                }
                if(i == R.id.userscontrol){
                    Intent  intent = new Intent(getApplication(),UsersControl.class);
                    startActivity(intent);
                }
                return false;
            }
        });

    }










}
