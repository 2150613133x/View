package com.myview.henview.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
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
public class CanvasNormalTransView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private int transMode = 0;

    public CanvasNormalTransView(Context context) {
        super(context);
        init();
    }

    public CanvasNormalTransView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasNormalTransView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanvasNormalTransView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_iron_man);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        translateCanvas(canvas);
        rotateCanvas(canvas);
        scaleCanvas(canvas);
        skewCanvas(canvas);

    }

    private void translateCanvas(Canvas canvas) {
        canvas.translate(300, 300);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    private void rotateCanvas(Canvas canvas) {
        canvas.rotate(60);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    private void scaleCanvas(Canvas canvas) {
        canvas.scale(1.2f, 1.3f);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    private void skewCanvas(Canvas canvas) {
        canvas.skew(1.2f, 1.3f);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}
