package com.myview.cxview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 22/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 */
public class PictureShadowView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Bitmap bitmap;

    public PictureShadowView(Context context) {
        super(context);
        init();
    }

    public PictureShadowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PictureShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PictureShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jingdong);
        bitmap = mBitmap.extractAlpha();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        mPaint.setColor(Color.GRAY);
        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(bitmap, null, new Rect(500, 50,
                500 + bitmap.getWidth(), 50 + bitmap.getHeight()), mPaint);
        canvas.drawBitmap(mBitmap, null, new Rect(490, 40, 490 + mBitmap.getWidth(), 40 + mBitmap.getHeight()), mPaint);
    }
}
