package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Locale;

/**
 * Created by ly-chenxiao on 11/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:设置换行时下移距离
 *
 * @author: chenxiao
 */
public class TextFontSpacingView extends View {

    private Paint mPaint;


    public TextFontSpacingView(Context context) {
        super(context);
        init();
    }

    public TextFontSpacingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        canvas.drawText("雨骨", 100, 100, mPaint);
        canvas.drawText("雨骨", 100, 100 + mPaint.getFontSpacing(), mPaint);
        canvas.drawText("雨骨", 100, 100 + mPaint.getFontSpacing() * 2, mPaint);
    }
}
