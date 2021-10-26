package com.myview.henview.paint;

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
 * Created by ly-chenxiao on 09/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class PaintActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hen_activity_paint);
        init();
    }

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        titles.add("LinearGradiant");
        titles.add("RadialGradiant");
        titles.add("SweepGradiant");
        titles.add("BitmapShader");
        titles.add("ComposeShader");
        titles.add("ColorFilter");
        titles.add("ShadowLayer");
        titles.add("MaskFilter");

        fragments.add(new DrawLinearGradientFragment());
        fragments.add(new DrawRadialGradientFragment());
        fragments.add(new DrawSweepGradientFragment());
        fragments.add(new DrawBitmapShaderFragment());
        fragments.add(new DrawComposeShaderFragment());
        fragments.add(new DrawColorFilterFragment());
        fragments.add(new DrawShadowLayerFragment());
        fragments.add(new DrawMaskFilterFragment());

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
