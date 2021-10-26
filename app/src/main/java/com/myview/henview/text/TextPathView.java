package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Locale;

/**
 * Created by ly-chenxiao on 11/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class TextPathView extends View {

    private Paint mPaint;

    public TextPathView(Context context) {
        super(context);
        init();
    }

    public TextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mPaint.setTextSize(50);
        mPaint.setTextSize(50);
        mPaint.setTextLocale(Locale.CHINA);
        canvas.drawText("雨骨", 100, 100, mPaint);
        mPaint.setTextLocale(Locale.TAIWAN);
        canvas.drawText("雨骨", 100, 200, mPaint);
        mPaint.setTextLocale(Locale.JAPAN);
        canvas.drawText("雨骨", 100, 300, mPaint);
    }
}
