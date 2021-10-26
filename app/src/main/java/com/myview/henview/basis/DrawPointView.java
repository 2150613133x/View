package com.myview.henview.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
public class DrawPointView extends View {

    private Paint mPaint;

    public DrawPointView(Context context) {
        super(context);
        init();
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        drawSquarePoint(canvas);
        drawRoundPoint(canvas);
        drawButtPoint(canvas);
        drawMultiPoint(canvas);
    }

    private void drawSquarePoint(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        //必须设置这个宽度，否则不显示点，使用这个属性控制点的大小
        mPaint.setStrokeWidth(50);
        //默认为正方形的点
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(100, 100, mPaint);
    }

    private void drawRoundPoint(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(100, 200, mPaint);
    }

    private void drawButtPoint(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(200, 100, mPaint);
    }

    private void drawMultiPoint(Canvas canvas) {
        mPaint.setColor(Color.GREEN);
        float[] points = {300, 100, 400, 100, 300, 200, 400, 200};
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoints(points, mPaint);
    }


}
