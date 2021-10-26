package com.myview.henview.paint;

import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.myview.cxview.R;

/**
 * Created by ly-chenxiao on 08/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class DrawMaskFilterFragment extends Fragment {
    public DrawMaskFilterFragment() {
        super(R.layout.fragment_draw_mask_filter_gradient);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DrawMaskFilterView maskFilterView = (DrawMaskFilterView) getActivity().findViewById(R.id.maskFilterView);
        View normalModeBtn = getActivity().findViewById(R.id.normalModeBtn);
        View solidModeBtn = getActivity().findViewById(R.id.solidModeBtn);
        View outModeBtn = getActivity().findViewById(R.id.outModeBtn);
        View innerModeBtn = getActivity().findViewById(R.id.innerModeBtn);

        normalModeBtn.setOnClickListener(v -> {
            maskFilterView.changeMode(BlurMaskFilter.Blur.NORMAL);
        });
        solidModeBtn.setOnClickListener(v -> {
            maskFilterView.changeMode(BlurMaskFilter.Blur.SOLID);
        });
        outModeBtn.setOnClickListener(v -> {
            maskFilterView.changeMode(BlurMaskFilter.Blur.OUTER);
        });
        innerModeBtn.setOnClickListener(v -> {
            maskFilterView.changeMode(BlurMaskFilter.Blur.INNER);
        });
    }
}
