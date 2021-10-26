package com.myview.cxview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 22/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class TextPaintView extends View {
    private static final String TAG = "TextPaintView";

    private Paint paint;

    public TextPaintView(Context context) {
        super(context);
        paint = new Paint();
    }

    public TextPaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public TextPaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    public TextPaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int baselineX = 800;
        int baselineY = 200;


        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        canvas.drawPoint(baselineX, baselineY, paint);
        paint.setTextSize(100);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.LEFT);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        Log.i(TAG, "top" + fontMetrics.top);
        float topY = fontMetrics.top + baselineY;
        float bottomY = fontMetrics.bottom + baselineY;
        float ascentY = fontMetrics.ascent + baselineY;
        float descentY = fontMetrics.descent + baselineY;
/*
        canvas.drawLine(0, baselineY, 3000, baselineY, paint);
        canvas.drawLine(0, topY, 3000, topY, paint);
        canvas.drawLine(0, bottomY, 3000, bottomY, paint);
        canvas.drawLine(0, ascentY, 3000, ascentY, paint);
        canvas.drawLine(0, descentY, 3000, descentY, paint);


        canvas.drawText("A'abghhhhhhdfajsgf.", baselineX, baselineY, paint);
*/
/*
        Path path = new Path();
        path.moveTo(300, 400);
        path.lineTo(300, 600);
        path.lineTo(600, 700);
        path.close();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);

        path.reset();

        path.moveTo(10, 10);
        RectF rectF = new RectF(100, 10, 300, 100);
        canvas.drawRect(rectF, paint);
        path.arcTo(rectF, 0, 270,true);
        canvas.drawPath(path, paint);*/
/*        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawRect(new Rect(100, 10, 300, 100), paint);
        canvas.drawPoint(50,50,paint);
        canvas.translate(50, 50);
        canvas.drawRect(new Rect(100, 10, 300, 100), paint);*/
        canvas.drawColor(Color.BLACK);
        canvas.clipRect(new Rect(100, 10, 300, 100));
        canvas.drawColor(Color.BLUE);

    }
}
