package com.myview.henview.layout;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ly-chenxiao on 13/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class TestViewGroup extends ViewGroup {

    private int childHeightSpec;

    public TestViewGroup(Context context) {
        super(context);
    }
  
    public TestViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TestViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int usedSize = 0;
        //ViewGroup 的测量过程，根据ViewGroup 的可用空间、限制模式和 子View 的LayoutParams 确定子View的测量
        //计算ViewGroup 的可用空间、限制模式
        int selfHeightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int selfHeightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            LayoutParams lp = childView.getLayoutParams();
            switch (lp.height) {
                case MATCH_PARENT:
                    if (selfHeightSpecMode == MeasureSpec.AT_MOST || selfHeightSpecMode == MeasureSpec.EXACTLY) {
                        childHeightSpec = MeasureSpec.makeMeasureSpec(selfHeightSpecSize - usedSize, MeasureSpec.EXACTLY);
                    } else {//MeasureSpec.UNSPECIFIED
                        childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                case WRAP_CONTENT:
                    if (selfHeightSpecMode == MeasureSpec.AT_MOST || selfHeightSpecMode == MeasureSpec.EXACTLY) {
                        childHeightSpec = MeasureSpec.makeMeasureSpec(selfHeightSpecSize - usedSize, MeasureSpec.AT_MOST);
                    } else {//MeasureSpec.UNSPECIFIED
                        childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }
                    break;
                default://确定值
                    childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);

            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
