package com.myview.henview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.myview.cxview.R;

/**
 * Created by ly-chenxiao on 08/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class DrawColorFilterView extends View {

    private Paint mPaint;
    private Bitmap ironManBitmap;
    private Bitmap jingDongBitmap;
    private BitmapShader bitmapShader;

    public DrawColorFilterView(Context context) {
        super(context);
        init();
    }

    public DrawColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        ironManBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_iron_man);
        jingDongBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jingdong);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        ColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        mPaint.setColorFilter(lightingColorFilter);
        int height = ironManBitmap.getHeight();
        int width = ironManBitmap.getWidth();
        canvas.drawBitmap(ironManBitmap, 0, 0, mPaint);
    }

}
