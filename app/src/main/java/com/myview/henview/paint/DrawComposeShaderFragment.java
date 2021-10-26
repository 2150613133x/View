package com.myview.henview.paint;

import android.graphics.PorterDuff;
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
public class DrawComposeShaderFragment extends Fragment {
    public DrawComposeShaderFragment() {
        super(R.layout.fragment_draw_compose_shader_gradient);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View changeComposeModeBtn = getActivity().findViewById(R.id.changeComposeModeBtn);
        DrawComposeShaderView composeShaderView = getActivity().findViewById(R.id.composeShaderView);
        changeComposeModeBtn.setOnClickListener(v -> {
            composeShaderView.changeMode(PorterDuff.Mode.DST_IN);
        });
    }
}
