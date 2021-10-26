package com.myview.henview.text;

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
 * Created by ly-chenxiao on 11/10/2021
 * Email: chenxiao@szlanyou.com
 * Description:
 *
 * @author: chenxiao
 */
public class TextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        init();
    }
    private TabLayout tabLayout;

    private ViewPager viewPager;
    private ArrayList<String> titles = new ArrayList<>();

    private ArrayList<Fragment> fragments = new ArrayList<>();

    private void init() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        titles.add("setTextSize");
        titles.add("setTextPath");
        titles.add("StaticLayout(换行)");
        titles.add("setTextType");
        titles.add("setTextLocal");
        titles.add("setTextFontSpacing(下移距离)");
        titles.add("FontMetrics (确定文本的位置)");
        titles.add("TextBound");


        fragments.add(new TextSizeFragment());
        fragments.add(new TextPathFragment());
        fragments.add(new TextStaticLayoutFragment());
        fragments.add(new TextTypefaceFragment());
        fragments.add(new TextLocalFragment());
        fragments.add(new TextFontSpacingFragment());
        fragments.add(new TextMatrixFragment());
        fragments.add(new TextBoundFragment());


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
