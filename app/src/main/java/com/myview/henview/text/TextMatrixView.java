package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
public class TextMatrixView extends View {

    private Paint mPaint;
    private float baseline;

    public TextMatrixView(Context context) {
        super(context);
        init();
    }

    public TextMatrixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextMatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextMatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float top = fontMetrics.top;
        float ascent = fontMetrics.ascent;
        float bottom = fontMetrics.bottom;
        float descent = fontMetrics.descent;
        baseline = 100f;
        mPaint.setColor(Color.RED);
        canvas.drawLine(0, baseline, 1000, baseline, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(0, baseline + top, 1000, baseline + top, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawLine(0, baseline + ascent, 1000, baseline + ascent, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawLine(0, baseline + descent, 1000, baseline + descent, mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.drawLine(0, baseline + bottom, 1000, baseline + bottom, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("abcdefghijk", baseline, 100, mPaint);
    }
}
