package com.myview.henview.paint;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 22/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 */
public class DrawMaskFilterView extends View {
    private boolean showShadow = true;
    private BlurMaskFilter.Blur mode = BlurMaskFilter.Blur.NORMAL;

    private Paint paint;

    public DrawMaskFilterView(Context context) {
        super(context);
        init();
    }


    public DrawMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint.setColor(Color.BLACK);
        paint.setTextSize(25);
        paint.setAntiAlias(true);
    }

    public void changeMode(BlurMaskFilter.Blur mode) {
        this.mode = mode;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setMaskFilter(new BlurMaskFilter(50, mode));
        canvas.drawCircle(300, 300, 200, paint);

    }


}
