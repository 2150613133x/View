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
public class DrawRectView extends View {

    private Paint mPaint;

    public DrawRectView(Context context) {
        super(context);
        init();
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        drawStrokeRect(canvas);
        drawFillRect(canvas);
        drawFillAndStrokeRect(canvas);
        drawRoundRect(canvas);
    }

    private void drawStrokeRect(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect = new Rect(50, 50, 400, 300);
        canvas.drawRect(rect, mPaint);
    }

    private void drawFillRect(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL);
        Rect rect = new Rect(500, 50, 850, 300);
        canvas.drawRect(rect, mPaint);
    }

    private void drawFillAndStrokeRect(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        Rect rect = new Rect(50, 400, 400, 650);
        canvas.drawRect(rect, mPaint);
    }
    private void drawRoundRect(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        RectF rect = new RectF(50, 800, 400, 1050);
        canvas.drawRoundRect(rect,50,50, mPaint);
    }

}
