package com.myview.cxview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

public class ViewAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);
        TextView tv = findViewById(R.id.tv);
        findViewById(R.id.startScaleAnim).setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(ViewAnimActivity.this, R.anim.scale_anim);
            animation.setInterpolator(new BounceInterpolator());
            tv.startAnimation(animation);
        });
        findViewById(R.id.startAlphaAnim).setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(ViewAnimActivity.this, R.anim.alpha_anim);
            animation.setInterpolator(new Interpolator() {
                @Override
                public float getInterpolation(float v) {
                    return 0;
                }
            });
            tv.startAnimation(animation);
        });
        findViewById(R.id.startRotateAnim).setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(ViewAnimActivity.this, R.anim.rotate_anim);
            animation.setInterpolator(new CycleInterpolator(3));
            tv.startAnimation(animation);
        });
        findViewById(R.id.startTranslateAnim).setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(ViewAnimActivity.this, R.anim.translate_anim);
            animation.setInterpolator(new CycleInterpolator(3));
            tv.startAnimation(animation);
        });
        findViewById(R.id.startSetAnim).setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(ViewAnimActivity.this, R.anim.set_anim);
            tv.startAnimation(animation);
        });

        findViewById(R.id.startCodeSetAnim).setOnClickListener(view -> {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1f);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 2f, 0f, 2f
                    , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720f
                    , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(rotateAnimation);

            animationSet.setDuration(3000);
            animationSet.setFillAfter(true);
            tv.startAnimation(animationSet);
        });

        findViewById(R.id.relateAnim).setOnClickListener(view -> {
            Animation alphaAnimation = AnimationUtils.loadAnimation(ViewAnimActivity.this, R.anim.alpha_anim);
            Animation rotateAnimation = AnimationUtils.loadAnimation(ViewAnimActivity.this, R.anim.rotate_anim);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    tv.startAnimation(rotateAnimation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            tv.startAnimation(alphaAnimation);
        });
    }
}