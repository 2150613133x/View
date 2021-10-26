package com.myview.cxview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by ly-chenxiao on 16/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class PropertyAnimActivity extends AppCompatActivity {
    private static final String TAG = "animator";

    private TextView animView1;
    private TextView animView2;
    private ValueAnimator valueAnimator;

    private int count = 3;
    private int index = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        animView1 = findViewById(R.id.animView1);
        animView2 = findViewById(R.id.animView2);
        findViewById(R.id.viewAnimBtn).setOnClickListener(view -> {
            startViewAnim();
        });
        findViewById(R.id.valueAnimBtn).setOnClickListener(view -> {
            starValueAnim();
        });

        animView1.setOnClickListener(view -> {
            Toast.makeText(this, "点击了View", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.cancelAnimBtn).setOnClickListener(view -> {
            if (null != valueAnimator) {
                valueAnimator.removeAllListeners();
            }
        });

        findViewById(R.id.startAnimSet).setOnClickListener(v -> {

            ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(animView1, "alpha", 0, 1);
            ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(animView2, "scaleX", 0, 2);
            alphaAnimator.setDuration(1000);
            scaleXAnimator.setDuration(1000);
            scaleXAnimator.setRepeatCount(ValueAnimator.INFINITE);
            AnimatorSet animationSet = new AnimatorSet();
            animationSet.playSequentially(alphaAnimator, scaleXAnimator);
            animationSet.setDuration(2000);
            animationSet.start();
        });

        findViewById(R.id.objectAnimBtn).setOnClickListener(v -> {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(animView1, "alpha", 0, 1, 0);
            objectAnimator.setDuration(1000);
            objectAnimator.start();
        });

        findViewById(R.id.startChargeBtn).setOnClickListener(v -> {
                    PowerView powerView = (PowerView) findViewById(R.id.powerView);
                    powerView.startAnim();
                }
        );


        findViewById(R.id.startLoadingBtn).setOnClickListener(view -> {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100, 0);
            valueAnimator.setDuration(1000);
            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
            int left = animView1.getLeft();
            int right = animView1.getRight();
            int top = animView1.getTop();
            int bottom = animView1.getBottom();
            valueAnimator.addUpdateListener(animator -> {
                int value = (int) animator.getAnimatedValue();
                animView1.layout(left, top - value, right, bottom - value);
            });
            valueAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {

                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                    index++;
                    switch (index % count) {
                        case 0:
                            animView1.setBackground(getResources().getDrawable(R.drawable.loading_ball_blue));
                            break;
                        case 1:
                            animView1.setBackground(getResources().getDrawable(R.drawable.loading_ball_red));
                            break;
                        case 2:
                            animView1.setBackground(getResources().getDrawable(R.drawable.loading_ball_yellow));
                            break;
                    }
                }
            });
            valueAnimator.start();
        });

        findViewById(R.id.valueOfObjectAnimBtn).setOnClickListener(v -> {
            TypeEvaluator typeEvaluator = new TypeEvaluator<Character>() {
                @Override
                public Character evaluate(float fraction, Character startValue, Character endValue) {
                    return (char) ((int) startValue + fraction * ((int) endValue - (int) startValue));
                }
            };
            ValueAnimator valueAnimator = ValueAnimator.ofObject(typeEvaluator, 'A', 'Z');
            valueAnimator.addUpdateListener(animation -> {
                Character animatedValue = (Character) animation.getAnimatedValue();
                animView1.setText(animatedValue.toString());
            });
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.setDuration(20000);
            valueAnimator.start();
        });
    }

    private void starValueAnim() {
        valueAnimator = ValueAnimator.ofInt(0, 200);
        valueAnimator.setDuration(5000);
        valueAnimator.setRepeatCount(3);
        int left = animView1.getLeft();
        int right = animView1.getRight();
        int top = animView1.getTop();
        int bottom = animView1.getBottom();
        valueAnimator.setEvaluator(new TypeEvaluator<Integer>() {
            @Override
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return (int) (200 + startValue + fraction * (endValue - startValue));
            }
        });
        valueAnimator.addUpdateListener(animator -> {
            int animatedValue = (int) animator.getAnimatedValue();
//            Log.i(TAG, "value: " + animatedValue);
            animView1.layout(left + animatedValue, top, right + animatedValue, bottom);
        });

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.i(TAG, "Start");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.i(TAG, "End");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.i(TAG, "Cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.i(TAG, "Repeat");
            }
        });
        valueAnimator.start();
    }

    private void startViewAnim() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 0);
        translateAnimation.setDuration(5000);
        animView1.startAnimation(translateAnimation);
    }
}
