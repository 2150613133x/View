package com.myview.henview.paint;

import android.graphics.Shader;
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
public class DrawRadialGradientFragment extends Fragment {
    public DrawRadialGradientFragment() {
        super(R.layout.fragment_draw_radial_gradient);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DrawRadialGradientView radialGradientView = (DrawRadialGradientView) getActivity().findViewById(R.id.radialGradientView);
        View showRadialClampBtn = getActivity().findViewById(R.id.showRadialClampBtn);
        View showRadialMirrorBtn = getActivity().findViewById(R.id.showRadialMirrorBtn);
        View showRadialRepeatBtn = getActivity().findViewById(R.id.showRadialRepeatBtn);

        showRadialClampBtn.setOnClickListener(v -> {
            radialGradientView.drawRadialGradient(Shader.TileMode.CLAMP);
        });
        showRadialMirrorBtn.setOnClickListener(v -> {
            radialGradientView.drawRadialGradient(Shader.TileMode.MIRROR);
        });
        showRadialRepeatBtn.setOnClickListener(v -> {
            radialGradientView.drawRadialGradient(Shader.TileMode.REPEAT);
        });
    }


}
