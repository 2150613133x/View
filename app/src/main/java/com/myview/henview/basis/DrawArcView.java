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
public class DrawArcView extends View {

    private Paint mPaint;

    public DrawArcView(Context context) {
        super(context);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        drawArc(canvas);
    }

    private void drawArc(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        // 绘制扇形
        canvas.drawArc(200, 100, 800, 500, -110, 100, true, mPaint);
        // 绘制弧形
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        // 绘制不封口的弧形
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, mPaint);
    }

}
