package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
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
public class TextTypefaceView extends View {

    private Paint mPaint;

    public TextTypefaceView(Context context) {
        super(context);
        init();
    }

    public TextTypefaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextTypefaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextTypefaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(50);
        mPaint.setTypeface(Typeface.DEFAULT);
        canvas.drawText("测试Testing", 100, 100, mPaint);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText("测试Testing", 100, 200, mPaint);
        mPaint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("测试Testing", 100, 300, mPaint);
        mPaint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("测试Testing", 100, 400, mPaint);
//        mPaint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));
//        canvas.drawText("测试Testing", 100, 400, mPaint);
    }
}
