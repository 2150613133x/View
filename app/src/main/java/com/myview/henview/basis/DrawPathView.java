package com.myview.henview.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
public class DrawPathView extends View {

    private Paint mPaint;
    private Path mPath;

    public DrawPathView(Context context) {
        super(context);
        init();
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        //一定得设置这个属性
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20);
        drawLine(canvas);
        drawCircle(canvas);
        drawHeart(canvas);
        drawBezierLine(canvas);

    }

    private void drawCircle(Canvas canvas) {
        mPath.reset();
        mPaint.setColor(Color.GREEN);
        mPath.addCircle(300, 800, 200, Path.Direction.CW);
        canvas.drawPath(mPath, mPaint);
    }

    private void drawHeart(Canvas canvas) {
        mPath.reset();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPath.addArc(200, 200, 400, 400, -225, 225);
        mPath.arcTo(400, 200, 600, 400, -180, 225, false);
        mPath.lineTo(400, 542);
        mPath.close();


        canvas.drawPath(mPath, mPaint);
    }

    private void drawLine(Canvas canvas) {
        mPath.moveTo(100, 100);
        mPath.lineTo(300, 100);
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(400, 100);
        mPath.rLineTo(200, 0);
        mPath.moveTo(500, 100);
        mPath.rLineTo(0, 100);
        mPath.moveTo(400, 200);
        mPath.rLineTo(200, 0);
        canvas.drawPath(mPath, mPaint);
    }

    private void drawBezierLine(Canvas canvas) {
        mPath.reset();
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(700, 100);
        mPath.quadTo(900, 200, 1000, 100);
        canvas.drawPath(mPath, mPaint);
    }


}
