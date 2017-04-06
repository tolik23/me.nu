package com.liutorovich.anatoliy.gmail.menu.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.liutorovich.anatoliy.gmail.menu.DB.MenuDataBase;
import com.liutorovich.anatoliy.gmail.menu.Fragments.BaseFragment;
import com.liutorovich.anatoliy.gmail.menu.R;

/**
 * Created by ToLik on 09.12.2016.
 */

public class MenuActivity extends AppCompatActivity{


    public static final String EXTRA_CATEGORY_ID = "com.liutorovich.anatoliy.gmail.menu.view.categoryId";
    NavigationDrawer navigationDrawer;

    public static Intent newIntent(Context packageContext, int categoryId){
        Intent intent = new Intent(packageContext, MenuActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID, categoryId);
        return intent;
    }



    private int position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        int categoryId = (int) getIntent().getSerializableExtra(EXTRA_CATEGORY_ID);
                System.out.println("-----------------  "+categoryId);
//        showFragment(MenuFragment.createInstance(getSupportFragmentManager(),categoryId), false, false);

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
