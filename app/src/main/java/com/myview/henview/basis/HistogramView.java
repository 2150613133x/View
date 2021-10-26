package com.myview.henview.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 09/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class HistogramView extends View {
    public static final String TAG = "HistogramView";
    private Paint mPaint;
    private Path mPath;
    int[] numbers = {20, 40, 40, 300, 600, 700, 500};
    String[] names = {"Kotlin", "Java", "C++", "C#", "Python", "C", "JS"};
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    private float pre;

    public HistogramView(Context context) {
        super(context);
        init();
    }


    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPath = new Path();
        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }
        pre = 500f / max;
        Log.i(TAG, "max: " + (float) max
                + " min:  " + min + " pre:  " + pre
        );

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#FF018786"));
        drawAxis(canvas);
        int location = 120;
        for (int i = 0; i < numbers.length; i++) {
            drawRect(canvas, numbers[i], location, names[i]);
            location += 120;
        }

    }

    private void drawAxis(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);

        mPath.moveTo(100, 100);
        mPath.rLineTo(0, 500);
        mPath.rLineTo(900, 0);
        canvas.drawPath(mPath, mPaint);
    }

    private void drawRect(Canvas canvas, int value, int location, String name) {
        mPaint.reset();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        RectF rectF = new RectF(location, 600f - (value * pre), location + 100, 600f);
        canvas.drawRect(rectF, mPaint);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.WHITE);
        canvas.drawText(name, location + 50, 650, mPaint);
    }
}
