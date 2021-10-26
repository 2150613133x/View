package com.myview.henview.layout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.myview.cxview.R;

/**
 * Created by ly-chenxiao on 08/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class SquareImageFragment extends Fragment {
    float bottomMargin = 48f;
    float minWidth = 100f;
    float minHeight = 100f;
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener;

    public SquareImageFragment() {
        super(R.layout.fragment_square_image);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        SquareImageView squareImageView = (SquareImageView) activity.findViewById(R.id.squareImageView);
        LinearLayout parentLayout = (LinearLayout) activity.findViewById(R.id.parentLayout);
        SeekBar widthSeekbar = (SeekBar) activity.findViewById(R.id.widthSeekbar);
        SeekBar heightSeekbar = (SeekBar) activity.findViewById(R.id.heightSeekbar);


        seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ViewGroup.LayoutParams layoutParams = parentLayout.getLayoutParams();
                layoutParams.width = (int) (minWidth + (parentLayout.getWidth()
                        - minWidth) * widthSeekbar.getProgress() / 100);
                layoutParams.height = (int) (minHeight + (parentLayout.getHeight()
                        - bottomMargin - minHeight) * heightSeekbar.getProgress() / 100);
                parentLayout.setLayoutParams(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        heightSeekbar.setOnSeekBarChangeListener(seekBarChangeListener);
        widthSeekbar.setOnSeekBarChangeListener(seekBarChangeListener);
    }
}
