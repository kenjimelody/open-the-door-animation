package com.superhardcode.testdooranimation;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Thanisak Piyasaksiri on 10/17/2016 AD.
 */

public class MainActivity extends AppCompatActivity implements Animator.AnimatorListener, View.OnClickListener {

    private Animation animation1;
    private boolean isOpen = false;

    private ImageView door_left = null;
    private ImageView door_right = null;

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
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onResume() {

        super.onResume();

        if(door_left != null && door_right != null && isOpen) {
            //openthedoor();
        }
    }

    private void init() {

        door_left = (ImageView) findViewById(R.id.door_left);
        door_right = (ImageView) findViewById(R.id.door_right);

        door_left.setOnClickListener(this);
        door_right.setOnClickListener(this);
    }

    private void openthedoor() {

        if(!isOpen) {
            isOpen = true;
            door_left.setPivotX(0);
            door_left.animate().setDuration(1000).rotationY(45).setListener(this).start();

            door_right.setPivotX(BitmapFactory.decodeResource(getResources(), R.drawable.door_2).getWidth());
            door_right.animate().setDuration(1000).rotationY(-45).setListener(this).start();
        } else {
            isOpen = false;
            door_left.setPivotX(0);
            door_left.animate().setDuration(1000).rotationY(0).setListener(this).start();

            door_right.setPivotX(BitmapFactory.decodeResource(getResources(), R.drawable.door_2).getWidth());
            door_right.animate().setDuration(1000).rotationY(0).setListener(this).start();
        }
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.door_left:
                openthedoor();
                break;
            case R.id.door_right:
                openthedoor();
                break;
            default:
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {

        /*
        if(isOpen) {
            startActivity(new Intent(this, GalleryActivity.class));
            overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        }
        */
    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
