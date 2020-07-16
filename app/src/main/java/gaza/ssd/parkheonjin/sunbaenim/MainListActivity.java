package gaza.ssd.parkheonjin.sunbaenim;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    ViewPager viewPager;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.main_title);
        setContentView(R.layout.activity_main_list);

        relativeLayout = (RelativeLayout) findViewById(R.id.lab2_container);
        viewPager = (ViewPager) findViewById(R.id.lab2_viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.lab2_tabs);
        tabLayout.setupWithViewPager(viewPager);
        Intent intent = getIntent();
        TabLayout.Tab tab = null;

        int index = intent.getIntExtra("index", 0);
        if (index == 0) {
            tab = tabLayout.getTabAt(0);
        } else if (index == 1) {
            tab = tabLayout.getTabAt(1);
        } else if (index == 2) {
            tab = tabLayout.getTabAt(2);
        } else if (index == 3) {
            tab = tabLayout.getTabAt(3);
        } else if (index == 4) {
            tab = tabLayout.getTabAt(4);
        } else if (index == 5) {
            tab = tabLayout.getTabAt(5);
        } else if (index == 6) {
            tab = tabLayout.getTabAt(6);
        } else if (index == 7) {
            tab = tabLayout.getTabAt(7);
        } else if (index == 8) {
            tab = tabLayout.getTabAt(8);
        }
        tab.select();
        tabLayout.addOnTabSelectedListener(this);

    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments = new ArrayList<Fragment>();
        private String titles[] = new String[] {"한식", "분식", "치킨", "중식", "피자", "보쌈", "기타"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new KoreaFoodFragment());
            fragments.add(new FlourBasedFoodFragment());
            fragments.add(new ChickenFoodFragment());
            fragments.add(new ChineseFoodFragment());
            fragments.add(new PizzaFragment());
            fragments.add(new MeatFragment());
            fragments.add(new EtcFoodFragment());
        }

        @Override
        public Fragment getItem(int i) {
            return this.fragments.get(i);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.activity_slide_in2, R.anim.activity_slide_out2);
        }
    }
}