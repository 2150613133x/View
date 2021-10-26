package com.myview.cxview;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 22/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 */
public class ShadowLayerView extends View {
    private boolean showShadow = true;

    private Paint paint;

    public ShadowLayerView(Context context) {
        super(context);
        init();
    }


    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showShadow) {
            paint.setShadowLayer(1, 10, 10, Color.GRAY);
        } else {
            paint.clearShadowLayer();
        }
        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
        canvas.drawText("dog", 100, 100, paint);
        canvas.drawCircle(300, 100, 50, paint);

    }

    public void onShowShadow(boolean showShadow) {
        this.showShadow = showShadow;
        postInvalidate();
    }
}
