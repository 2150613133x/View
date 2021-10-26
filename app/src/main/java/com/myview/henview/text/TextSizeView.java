package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
public class TextSizeView extends View {

    private Paint mPaint;
    private float textSize;

    public TextSizeView(Context context) {
        super(context);
        init();
    }

    public TextSizeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(textSize);
        canvas.drawText("测试Testing", 200, 300, mPaint);
    }
}
