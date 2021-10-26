package com.myview.henview.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
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
public class DrawLinearGradientView extends View {

    private Paint mPaint;

    public DrawLinearGradientView(Context context) {
        super(context);
        init();
    }

    public DrawLinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawLinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawLinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mPaint.setStyle(Paint.Style.FILL);
        drawLinerGradient(canvas);
        drawLinerGradientClamp(canvas);
        drawLinerGradientMirror(canvas);
        drawLinerGradientRepeat(canvas);
    }

    private void drawLinerGradient(Canvas canvas) {
        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawCircle(300, 300, 200, mPaint);
    }

    /**
     * @param canvas description: Shader.TileMode.CLAMP 模式，会在渐变超出的范围用边缘的颜色补充
     */
    private void drawLinerGradientClamp(Canvas canvas) {
        Shader shader = new LinearGradient(100, 100 + 400, 500, 500 + 400, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawRect(100, 100 + 400, 500 + 400, 500 + 400, mPaint);
    }

    /**
     * @param canvas description: Shader.TileMode.MIRROR 模式，镜像模式
     */
    private void drawLinerGradientMirror(Canvas canvas) {
        Shader shader = new LinearGradient(100, 100 + 400 + 400 + 10, 500, 500 + 400 + 400 + 10, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
        mPaint.setShader(shader);
        canvas.drawRect(100, 100 + 400 + 400 + 10, 500 + 400, 500 + 400 + 400 + 10, mPaint);
    }

    /**
     * @param canvas description: Shader.TileMode.MIRROR 模式，镜像模式
     */
    private void drawLinerGradientRepeat(Canvas canvas) {
        Shader shader = new LinearGradient(100, 100 + 400 + 400 + 10 + 400 + 10, 500, 500 + 400 + 400 + 10 + 400 + 10, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        mPaint.setShader(shader);
        canvas.drawRect(100, 100 + 400 + 400 + 10 + 400 + 10, 500+400, 500 + 400 + 400 + 10 + 400 + 10, mPaint);
    }


}
