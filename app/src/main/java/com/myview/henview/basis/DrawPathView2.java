package com.myview.henview.basis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
public class DrawPathView2 extends View {

    private Paint mPaint;
    private Path mPath;

    public DrawPathView2(Context context) {
        super(context);
        init();
    }

    public DrawPathView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawPathView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawPathView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20);
        draw2CircleEvenOdd(canvas);
        draw2CircleWinding(canvas);
        draw2CircleWinding2(canvas);
    }

    private void draw2CircleWinding(Canvas canvas) {
        mPath.reset();
        mPaint.setColor(Color.BLACK);
        mPath.addCircle(200, 200, 150, Path.Direction.CW);
        mPath.addCircle(400, 200, 150, Path.Direction.CW);
        mPath.setFillType(Path.FillType.WINDING);
        canvas.drawPath(mPath, mPaint);
    }

    private void draw2CircleEvenOdd(Canvas canvas) {
        mPath.reset();
        mPaint.setColor(Color.BLACK);
        mPath.addCircle(700, 200, 150, Path.Direction.CW);
        mPath.addCircle(900, 200, 150, Path.Direction.CW);
        mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(mPath, mPaint);
    }

    private void draw2CircleWinding2(Canvas canvas) {
        mPath.reset();
        mPaint.setColor(Color.BLACK);
        mPath.addCircle(200, 500, 150, Path.Direction.CW);
        mPath.addCircle(400, 500, 150, Path.Direction.CCW);
        mPath.setFillType(Path.FillType.WINDING);
        canvas.drawPath(mPath, mPaint);
    }
}
