package com.myview.henview.basis;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.myview.cxview.R;

import java.util.ArrayList;

/**
 * Created by ly-chenxiao on 08/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author ly-chenxiao
 */
public class ADrawingBasisActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_basis);
        init();
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        titles.add("drawColor()");
        titles.add("drawCircle()");
        titles.add("drawRect()");
        titles.add("drawPoint()");
        titles.add("drawOval()");
        titles.add("drawLine()");
        titles.add("drawArc()");
        titles.add("drawPath()");
        titles.add("直方图");
        titles.add("环形");
        titles.add("扇形");
        fragments.add(new DrawColorFragment());
        fragments.add(new DrawCircleFragment());
        fragments.add(new DrawRectFragment());
        fragments.add(new DrawPointFragment());
        fragments.add(new DrawOvalFragment());
        fragments.add(new DrawLineFragment());
        fragments.add(new DrawArcFragment());
        fragments.add(new DrawPathFragment());
        fragments.add(new DrawHistogramFragment());
        fragments.add(new DrawRingFragment());
        fragments.add(new DrawSectorFragment());

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
        tabLayout.getTabAt(5).select();
    }
}
