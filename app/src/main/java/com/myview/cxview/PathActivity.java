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
public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        DrawBoardView drawBoardView = (DrawBoardView) findViewById(R.id.drawBoardView);

        findViewById(R.id.clearBtn).setOnClickListener(v -> {
            drawBoardView.clearBoard();
        });
    }
}
