package com.myview.henview.paint;

import static android.graphics.Shader.TileMode.*;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
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
public class DrawRadialGradientView extends View {

    private Paint mPaint;
    public TileMode mode = CLAMP;

    public DrawRadialGradientView(Context context) {
        super(context);
        init();
    }

    public DrawRadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawRadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawRadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        switch (mode) {
            case CLAMP:
                drawRadialGradientClamp(canvas);
                break;
            case REPEAT:
                drawRadialGradientRepeat(canvas);
                break;
            case MIRROR:
                drawRadialGradientMirror(canvas);
                break;
            default:
                drawRadialGradient(canvas);
                break;
        }
    }

    public void drawRadialGradient(TileMode mode) {
        this.mode = mode;
        invalidate();
    }

    private void drawRadialGradient(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(500, 500, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), CLAMP);
        mPaint.setShader(radialGradient);
        canvas.drawCircle(500, 500, 200, mPaint);
    }

    private void drawRadialGradientClamp(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(500, 500, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), CLAMP);
        mPaint.setShader(radialGradient);
        canvas.drawCircle(500, 500, 500, mPaint);
    }

    private void drawRadialGradientRepeat(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(500, 500, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), REPEAT);
        mPaint.setShader(radialGradient);
        canvas.drawCircle(500, 500, 500, mPaint);
    }

    private void drawRadialGradientMirror(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(500, 500, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), MIRROR);
        mPaint.setShader(radialGradient);
        canvas.drawCircle(500, 500, 500, mPaint);
    }
}
