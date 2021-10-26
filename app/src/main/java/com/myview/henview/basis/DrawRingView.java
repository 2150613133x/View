package com.myview.henview.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 08/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class DrawRingView extends View {

    private Paint mPaint;
    private int viewHeight;
    private int viewWidth;
    private int radius;
    private int total = 100;
    private int value = 50;

    public DrawRingView(Context context) {
        super(context);
        init();
    }

    public DrawRingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawRingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawRingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewHeight = getHeight();
        viewWidth = getWidth();
        radius = 300;
        mPaint.setAntiAlias(true);
        drawArc(canvas);
    }

    private void drawArc(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(40);
        RectF rectF = new RectF(viewWidth / 2 - radius, viewHeight / 2 - radius, viewWidth / 2 + radius, viewHeight / 2 + radius);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawArc(rectF,130,140,false,mPaint);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, -90, 20, false, mPaint);
        mPaint.setColor(Color.CYAN);
        canvas.drawArc(rectF,-70,30,false,mPaint);
        mPaint.setColor(Color.parseColor("#FF018786"));
        canvas.drawArc(rectF,-40,30,false,mPaint);
        mPaint.setColor(Color.parseColor("#FFC107"));
        canvas.drawArc(rectF,-10,140,false,mPaint);


    }

}
