package com.myview.cxview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 16/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class PowerView extends View {

    Paint strokePaint;
    Paint fillPaint;
    private ObjectAnimator objectAnimator;
    int powerValue = 0;

    public void setPower(int powerValue) {
        this.powerValue = powerValue;
        invalidate();
    }

    public PowerView(Context context) {
        super(context);
        init();
    }

    public PowerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PowerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PowerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        strokePaint = new Paint();
        strokePaint.setColor(0xFF000000);
        strokePaint.setStrokeWidth(2);
        strokePaint.setStyle(Paint.Style.STROKE);
        fillPaint = new Paint();
        fillPaint.setStrokeWidth(2);
        fillPaint.setColor(0xFF03DAC5);
        fillPaint.setStyle(Paint.Style.FILL);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect1 = new Rect(0, 0, 100, 50);
        Rect rect2 = new Rect(2, 2, powerValue, 48);
        canvas.drawRect(rect1, strokePaint);
        canvas.drawRect(rect2, fillPaint);
    }

    public void startAnim() {
        if (objectAnimator == null) {
            objectAnimator = ObjectAnimator.ofInt(this, "power", 0, 100);
            objectAnimator.setDuration(2000);
            objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
            objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        }
        objectAnimator.start();
    }


}
