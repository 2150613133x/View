package com.myview.henview.canvas;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.myview.cxview.R;
import com.myview.henview.text.TextBoundFragment;
import com.myview.henview.text.TextFontSpacingFragment;
import com.myview.henview.text.TextLocalFragment;
import com.myview.henview.text.TextMatrixFragment;
import com.myview.henview.text.TextPathFragment;
import com.myview.henview.text.TextSizeFragment;
import com.myview.henview.text.TextStaticLayoutFragment;
import com.myview.henview.text.TextTypefaceFragment;

import java.util.ArrayList;

/**
 * Created by ly-chenxiao on 11/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class CanvasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        init();
    }

    private TabLayout tabLayout;

    private ViewPager viewPager;
    private ArrayList<String> titles = new ArrayList<>();

    private ArrayList<Fragment> fragments = new ArrayList<>();

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        titles.add("clip(裁切)");
        titles.add("几何变换(常规)");
        titles.add("几何变换(Matrix)");


        fragments.add(new CanvasClipFragment());
        fragments.add(new CanvasNormalTransFragment());
        fragments.add(new CanvasMatrixTransFragment());


        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return titles.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).select();
    }
}
