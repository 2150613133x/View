package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 11/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class TextBoundView extends View {

    private Paint mPaint;
    private float baseline;

    public TextBoundView(Context context) {
        super(context);
        init();
    }

    public TextBoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextBoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextBoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(100);
        baseline = 100f;
        canvas.drawText("abcdefghijk", baseline, 100, mPaint);
        Rect bounds = new Rect();
        mPaint.getTextBounds("abcdefghijk", 0, "abcdefghijk".length(), bounds);
        bounds.left += 100;
        bounds.top += 100;
        bounds.right += 100;
        bounds.bottom += 100;

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(bounds, mPaint);

    }
}
