package com.myview.henview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
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
public class DrawComposeShaderView extends View {

    private Paint mPaint;
    private Bitmap ironManBitmap;
    private Bitmap icBitmap;
    private PorterDuff.Mode mode = PorterDuff.Mode.SRC_OVER;

    public DrawComposeShaderView(Context context) {
        super(context);
        init();
    }

    public DrawComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        ironManBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_iron_man);
        icBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_iron_man);
    }

    public void changeMode(PorterDuff.Mode mode) {
        this.mode = mode;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        BitmapShader bitmapShader1 = new BitmapShader(ironManBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        BitmapShader bitmapShader2 = new BitmapShader(icBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //这里通过 PorterDuff.Mode 来改变 两个Shader结合的方式 https://rengwuxian.com/ui-1-2/
        //Alpha 合成 ( Alpha Compositing )
        ComposeShader composeShader = new ComposeShader(bitmapShader1, bitmapShader2, mode);
        mPaint.setShader(composeShader);
        canvas.drawRect(0, 0, 600, 600, mPaint);
    }

}
