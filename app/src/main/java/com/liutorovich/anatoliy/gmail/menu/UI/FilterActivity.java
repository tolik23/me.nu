package com.liutorovich.anatoliy.gmail.menu.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.liutorovich.anatoliy.gmail.menu.DB.MenuDataBase;
import com.liutorovich.anatoliy.gmail.menu.Fragments.BaseFragment;
import com.liutorovich.anatoliy.gmail.menu.Fragments.FilterFragment;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.R;

/**
 * Created by ToLik on 07.11.2016.
 */

public class FilterActivity extends AppCompatActivity implements Toolbarlistener {

    NavigationDrawer navigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        showFragment(FilterFragment.createInstance(getSupportFragmentManager()), false, false);

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

    public void showFragment(BaseFragment fragment, boolean addToBackStack, boolean clearToBackStak) {
        /// очистить BackStak
        if (clearToBackStak) {
            while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }
        }

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.conteiner, fragment, fragment.getFragmentTag());


        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
