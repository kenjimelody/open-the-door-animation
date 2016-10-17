package com.superhardcode.testdooranimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Thanisak Piyasaksiri on 10/17/2016 AD.
 */

public class GalleryActivity extends AppCompatActivity {

    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }
}