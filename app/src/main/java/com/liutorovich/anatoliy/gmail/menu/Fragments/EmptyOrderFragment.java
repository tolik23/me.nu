package com.liutorovich.anatoliy.gmail.menu.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.R;

/**
 * Created by ToLik on 22.02.2017.
 */

public class EmptyOrderFragment extends BaseFragment {

    private Toolbarlistener mToolbarlistener;
    private static final String TAG = EmptyOrderFragment.class.getSimpleName();


    public static EmptyOrderFragment createInstance(FragmentManager fragmentManager) {

        EmptyOrderFragment myFragment = (EmptyOrderFragment) fragmentManager.findFragmentByTag(EmptyOrderFragment.TAG);

        if(myFragment == null){

            myFragment = new EmptyOrderFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_order_empty, container, false);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Toolbarlistener){
            mToolbarlistener =(Toolbarlistener) context;
            setHasOptionsMenu(true);
        }
    }

    @Override
    public void onDetach() {
        mToolbarlistener=null;
        super.onDetach();
        setHasOptionsMenu(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }
}
