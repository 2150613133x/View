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
 * Description:
 *
 * @author: chenxiao
 */
public class CanvasClipView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Path clipPath;

    public CanvasClipView(Context context) {
        super(context);
        init();
    }

    public CanvasClipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanvasClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_iron_man);
        clipPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipRect(new Rect(100, 100, 200, 300));
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        canvas.restore();
        clipPath.moveTo(300, 300);
        clipPath.lineTo(600, 600);
        clipPath.lineTo(300, 600);
        clipPath.close();
        canvas.clipPath(clipPath);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}
