package com.myview.henview.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 11/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:用户文本超长时换行
 *
 * @author: chenxiao
 */
public class TextStaticLayoutView extends View {

    private TextPaint mPaint;
    private String string1;
    private String string2;

    public TextStaticLayoutView(Context context) {
        super(context);
        init();
    }

    public TextStaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextStaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TextStaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new TextPaint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(50);
        string1 = "测试Testing测试Testing测试Testing测试Testing测试Testing";
//        canvas.drawText(string1, 200, 300, mPaint);
        string2 = "测试Testing\n测试Testing\n测试Testing\n测试Testing";
//        canvas.drawText(string2, 200, 400, mPaint);

        StaticLayout staticLayout1 = new StaticLayout(string1, mPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        StaticLayout staticLayout2 = new StaticLayout(string2, mPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        canvas.save();
        canvas.translate(50, 100);
        staticLayout1.draw(canvas);
        canvas.translate(0, 200);
        staticLayout2.draw(canvas);
        canvas.restore();
    }
}
