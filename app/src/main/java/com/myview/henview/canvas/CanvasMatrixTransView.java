package com.myview.henview.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.myview.cxview.R;

/**
 * Created by ly-chenxiao on 11/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:基础的几何变换
 *
 * @author: chenxiao
 */
public class CanvasMatrixTransView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private int transMode = 0;
    private Matrix matrix;

    public CanvasMatrixTransView(Context context) {
        super(context);
        init();
    }

    public CanvasMatrixTransView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasMatrixTransView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanvasMatrixTransView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_iron_man);
        matrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        translateCanvas(canvas);
        rotateCanvas(canvas);
        scaleCanvas(canvas);
        skewCanvas(canvas);
        poly(canvas);

    }

    private void translateCanvas(Canvas canvas) {
        matrix.postTranslate(500, 500);
        canvas.concat(matrix);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    private void rotateCanvas(Canvas canvas) {
        matrix.reset();
        matrix.postRotate(60);
        canvas.concat(matrix);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    private void scaleCanvas(Canvas canvas) {
        matrix.reset();
        matrix.postScale(1.2f, 1.3f);
        canvas.concat(matrix);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    private void skewCanvas(Canvas canvas) {
        matrix.reset();
        matrix.postSkew(1.2f, 1.3f);
        canvas.concat(matrix);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    private void poly(Canvas canvas) {
        canvas.restore();
        matrix.reset();
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        float left = 0f;
        float top = 0f;
        float right = width;
        float bottom = height;
        float[] pointsSrc = {left, top, right, top, left, bottom, right, bottom};
        float[] pointsDst = {left - 10, top + 50, right + 120, top - 90, left + 20, bottom + 30, right + 20, bottom + 60};
        matrix.setPolyToPoly(pointsSrc, 0, pointsDst, 0, 4);
        canvas.concat(matrix);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}
