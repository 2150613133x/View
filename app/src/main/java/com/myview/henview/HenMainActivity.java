package com.myview.henview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.myview.cxview.R;
import com.myview.henview.basis.ADrawingBasisActivity;
import com.myview.henview.canvas.CanvasActivity;
import com.myview.henview.paint.PaintActivity;
import com.myview.henview.text.TextActivity;

/**
 * Created by ly-chenxiao on 08/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class HenMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hen_main);
    }

    public void toDrawingBasisActivity(View view) {
        startActivity(new Intent(HenMainActivity.this, ADrawingBasisActivity.class));
    }

    public void toPaintActivity(View view) {
        startActivity(new Intent(HenMainActivity.this, PaintActivity.class));
    }

    public void toTextActivity(View view) {
        startActivity(new Intent(HenMainActivity.this, TextActivity.class));

    }    public void toCanvasActivity(View view) {
        startActivity(new Intent(HenMainActivity.this, CanvasActivity.class));

    }
}
