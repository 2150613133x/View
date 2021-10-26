package com.myview.cxview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 23/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 */
public class SosView extends View {

    private Paint bgPaint;
    private Paint textPaint;
    private int viewHeight;
    private int viewWidth;
    private Paint circlePaint;
    private float scale1;
    private float scale2;
    private float scale3;
    private float scale4;
    private float scale5;

    public SosView(Context context) {
        super(context);
    }

    public SosView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SosView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SosView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewHeight = getHeight();
        viewWidth = getWidth();
    }

    private void init() {
        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        startAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circlePaint.setStrokeWidth(20);
        circlePaint.setColor(0XFF6B8098);
        circlePaint.setMaskFilter(new BlurMaskFilter(40, BlurMaskFilter.Blur.NORMAL));
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, scale1, circlePaint);
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, scale2, circlePaint);
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, scale3, circlePaint);
        bgPaint.setShader(new LinearGradient(viewWidth / 2 - 100, viewHeight / 2 - 100,
                viewWidth / 2 - 100, viewHeight / 2 + 100, 0xFFEC0500, 0xFF961413, Shader.TileMode.CLAMP));
        bgPaint.setMaskFilter(new BlurMaskFilter(40, BlurMaskFilter.Blur.SOLID));
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, 100, bgPaint);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(64);
        textPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
        float baselineY = viewHeight / 2 + distance;
        canvas.drawText("SOS", viewWidth / 2, baselineY, textPaint);
    }

    private void startAnim() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this, "scale1", 80, 280);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this, "scale2", 80, 280);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(this, "scale3", 80, 280);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(this, "scale4", 80, 280);
        ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(this, "scale5", 80, 280);
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator1.setDuration(2000);
        objectAnimator2.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator2.setDuration(2000);
        objectAnimator3.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator3.setDuration(2000);
        objectAnimator4.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator4.setDuration(2000);
        objectAnimator5.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator5.setDuration(2000);
        objectAnimator2.setStartDelay(500);
        objectAnimator3.setStartDelay(600);
        objectAnimator4.setStartDelay(700);
        objectAnimator5.setStartDelay(800);
        objectAnimator1.start();
        objectAnimator2.start();
        objectAnimator3.start();
        objectAnimator4.start();
        objectAnimator5.start();
    }

    public void setScale1(float mScale) {
        this.scale1 = mScale;
        invalidate();
    }

    public void setScale2(float mScale) {
        this.scale2 = mScale;
        invalidate();
    }

    public void setScale3(float mScale) {
        this.scale3 = mScale;
        invalidate();
    }

    public void setScale4(float mScale) {
        this.scale4 = mScale;
        invalidate();
    }

    public void setScale5(float mScale) {
        this.scale5 = mScale;
        invalidate();
    }
}
