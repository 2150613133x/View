package com.myview.cxview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 07/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class CanvasOperationView extends Button {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Path path;
    private Matrix matrix;
    private int picWidth;
    private int picHeight;
    private Camera camera;
    private ObjectAnimator animator;

    public CanvasOperationView(Context context) {
        super(context);
        init(context);
    }

    public CanvasOperationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CanvasOperationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public CanvasOperationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.jingdong);
        mPaint = new Paint();
        matrix = new Matrix();
        camera = new Camera();

        picWidth = mBitmap.getWidth();
        picHeight = mBitmap.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void startAnim() {
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX", 1);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY", 1);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha", 1);
        animator = ObjectAnimator.ofPropertyValuesHolder(this, holder1, holder2, holder3);
        animator.setDuration(3000);
        animator.start();
    }

}
