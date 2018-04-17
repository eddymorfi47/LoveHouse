package com.eddiemartnez.app.lovehouse.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eddiemartnez.app.lovehouse.R;

public class social extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social);

        final android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    public void fa(View view) {
        Uri uri = Uri.parse("http://www.facebook.com/lovehousecr/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void yt(View view) {
        Uri ur = Uri.parse("http://www.youtube.com/channel/UCkC4vvJqcaDzQ6rtUg3Ej0w");
        Intent inten = new Intent(Intent.ACTION_VIEW, ur);
        startActivity(inten);
    }

    public void wa(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                Uri.parse("tel:+50685479048")); //
        startActivity(i);
    }
}
