package com.liutorovich.anatoliy.gmail.menu.UI;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.liutorovich.anatoliy.gmail.menu.DB.MenuDataBase;
import com.liutorovich.anatoliy.gmail.menu.Fragments.MapFragment;
import com.liutorovich.anatoliy.gmail.menu.Fragments.SearchFragment;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ToLik on 07.11.2016.
 */

public class SearchActivity extends AppCompatActivity implements Toolbarlistener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    NavigationDrawer navigationDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        MenuDataBase db = new MenuDataBase(this);
        int count = db.getContactsCount();
        navigationDrawer=new NavigationDrawer(this, toolbar,count);
        navigationDrawer.drawer();

    }

    @Override
    public void onBackPressed() {
        // Закрываем Navigation Drawer по нажатию системной кнопки "Назад" если он открыт
        if (navigationDrawer.drawerResult.isDrawerOpen()) {
            navigationDrawer.drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SearchFragment(), "Заведения");
        adapter.addFragment(new MapFragment(), "Карта");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}