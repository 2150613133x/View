package com.myview.henview.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 12/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class SquareImageView extends androidx.appcompat.widget.AppCompatImageView {
    public SquareImageView(@NonNull Context context) {
        super(context);
    }

    public SquareImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //执行父类测量算法
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取已测得的宽高
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        //利用获取的宽高计算新的宽高
        if (measuredHeight < measuredWidth) {
            measuredWidth = measuredHeight;
        } else {
            measuredHeight = measuredWidth;
        }
        //调用 setMeasureDimension() 保存新计算的宽高
        setMeasuredDimension(measuredWidth, measuredHeight);

        //全新定制View 的尺寸
        //View 计算出的宽高
/*        measuredHeight = ...;
        measuredWidth = ...;*/
        //通过 父View 的尺寸限制进行修正后的尺寸
        int resolveHeight = resolveSize(measuredHeight, heightMeasureSpec);
        int resolveWidth = resolveSize(measuredWidth, widthMeasureSpec);
        //调用 setMeasureDimension() 保存新计算的宽高
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    /**
     * Description:.
     *
     * @param size        子View 测量的尺寸
     * @param measureSpec 父View 的尺寸限制
     * @author ly-chenxiao
     * @date 13/10/2021 10:32 AM
     */
    private int myResolveSize(int size, int measureSpec) {
        int result;
        //父View 的尺寸限制
        int specSize = MeasureSpec.getSize(measureSpec);
        //父View 的限制方式
        int specMode = MeasureSpec.getMode(measureSpec);
        switch (specMode) {
            //父View 限制方式为 MeasureSpec.EXACTLY(确定值)，则返回值为 父View 传入的尺寸值
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            //父View 限制方式为 MeasureSpec.AT_MOST(剩余空间值)，则比较 父View 传入的尺寸值和 自己计算的尺寸值，最小值
            case MeasureSpec.AT_MOST:
                if (specSize > size) {
                    result = size;
                } else {
                    result = specSize;
                }
                break;
            //父View 限制方式为 MeasureSpec.UNSPECIFIED(无限制)，则返回自己计算的尺寸值
            case MeasureSpec.UNSPECIFIED:
            default:
                result = size;
        }
        return result;
    }
}
