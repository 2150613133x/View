package com.myview.henview.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
public class DrawOvalView extends View {

    private Paint mPaint;

    public DrawOvalView(Context context) {
        super(context);
        init();
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        drawStrokeOver(canvas);

        drawFillCircle(canvas);
        drawFillAndStrokeOver(canvas);
    }

    private void drawFillCircle(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL);
        RectF rect = new RectF(500, 50, 850, 300);
        canvas.drawOval(rect, mPaint);
    }

    private void drawStrokeOver(Canvas canvas) {
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        RectF rect = new RectF(50, 50, 400, 300);
        canvas.drawOval(rect, mPaint);
    }

    private void drawFillAndStrokeOver(Canvas canvas) {
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLUE);
        RectF rect = new RectF(50, 400, 400, 650);
        canvas.drawOval(rect, mPaint);
    }


}
