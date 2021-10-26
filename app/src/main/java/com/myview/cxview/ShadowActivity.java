package com.myview.cxview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by ly-chenxiao on 22/09/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class ShadowActivity extends AppCompatActivity {
    private boolean showShadow = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);
        findViewById(R.id.showShadowBtn).setOnClickListener(v -> {
            showShadow = !showShadow;
            ShadowLayerView shadowLayerView = (ShadowLayerView) findViewById(R.id.shadowView);
            shadowLayerView.onShowShadow(showShadow);
        });
    }
}
