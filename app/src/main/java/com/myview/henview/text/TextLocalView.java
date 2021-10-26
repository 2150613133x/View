package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
public class TextLocalView extends View {

    private Paint mPaint;
    private Path mPath;

    public TextLocalView(Context context) {
        super(context);
        init();
    }

    public TextLocalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextLocalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextLocalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(50);

        mPath.moveTo(200, 200);
        mPath.rLineTo(200, 200);
        mPath.rLineTo(100, -50);
        mPath.rLineTo(0, 200);
        canvas.drawTextOnPath("测试Testing测试Testing", mPath, 10, 10, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath, mPaint);
    }
}
