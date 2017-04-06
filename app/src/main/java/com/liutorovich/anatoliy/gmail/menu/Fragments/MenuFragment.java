package com.liutorovich.anatoliy.gmail.menu.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.liutorovich.anatoliy.gmail.menu.Adapters.MenuAdapter;
import com.liutorovich.anatoliy.gmail.menu.Adapters.RestaurantAdapter;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.Models.Restaurant;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;

import java.util.List;

/**
 * Created by ToLik on 09.12.2016.
 */

public class MenuFragment extends BaseFragment{

    public static final String ARG_CATEGORY_ID = "category_id";
    private int position;
    private Toolbarlistener mToolbarlistener;

    public static  List<Restaurant> list;

    private static final String TAG = MenuFragment.class.getSimpleName();

    public static MenuFragment createInstance(FragmentManager fragmentManager,int categoryId) {

        MenuFragment myFragment = (MenuFragment) fragmentManager.findFragmentByTag(MenuFragment.TAG);
        Bundle args = new Bundle();
        args.putSerializable(ARG_CATEGORY_ID, categoryId);
        if(myFragment == null){

            myFragment = new MenuFragment();
        }
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = (int) getArguments().getSerializable(ARG_CATEGORY_ID);
        System.out.println("++++++++++++++++++++++++++  "+position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_menu, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_menu);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        MenuAdapter adapter = new MenuAdapter(getContext(), RestaurantAdapter.list,position,getActivity());
        recyclerView.setAdapter(adapter);
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
        inflater.inflate(R.menu.menu_two, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_call:
                startActivity(new Intent(getActivity(), OrderActivity.class));        }

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
