package com.myview.cxview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by ly-chenxiao on 07/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class CanvasActivity extends Activity {

    private CanvasOperationView canvasOperationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_view);
        canvasOperationView = (CanvasOperationView) findViewById(R.id.canvasOperationView);
    }

    public void startAnim(View view) {
        canvasOperationView.startAnim();
    }
}
