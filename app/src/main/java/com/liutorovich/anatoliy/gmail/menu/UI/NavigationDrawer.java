package com.liutorovich.anatoliy.gmail.menu.UI;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.liutorovich.anatoliy.gmail.menu.R;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

/**
 * Created by ToLik on 09.02.2017.
 */

public class NavigationDrawer {

    public Drawer.Result drawerResult = null;
    private Activity mActivity;
    private Toolbar mToolbar;
    private int mCount;

    public NavigationDrawer (Activity activity, Toolbar toolbar, int a){

        mActivity=activity;
        mToolbar=toolbar;
        mCount=a;
    }

    public void drawer (){
        drawerResult = new Drawer()
                .withActivity(mActivity)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_eye).withBadge(String.valueOf(mCount)).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_github).withIdentifier(3)
                )

                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        InputMethodManager inputMethodManager = (InputMethodManager) mActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(mActivity.getCurrentFocus().getWindowToken(), 0);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    // Обработка клика
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (position == 1) {

                                mActivity.startActivity(new Intent(mActivity, MainActivity.class));

                        }else {
                            if (position==2){
                                if(mCount != 0){
                                    mActivity.startActivity(new Intent(mActivity, OrderHistoryActivity.class));
                                }else{
                                    Toast.makeText(mActivity, "История заказов пуста", Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                if(position==3){
                                    Toast.makeText(mActivity, mActivity.getString(((Nameable) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                })
                .build();

    }


}
