package com.liutorovich.anatoliy.gmail.menu.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
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

import com.liutorovich.anatoliy.gmail.menu.Adapters.RestaurantAdapter;
import com.liutorovich.anatoliy.gmail.menu.Interface.RestaurantService;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.Models.Restaurant;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ToLik on 07.11.2016.
 */

public class SwipeFragment extends BaseFragment {

//    List<Restaurant> list = new ArrayList<>();

    private Toolbarlistener mToolbarlistener;

    private static final String TAG = SwipeFragment.class.getSimpleName();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://###########/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private RestaurantService service = retrofit.create(RestaurantService.class);


    public static SwipeFragment createInstance(FragmentManager fragmentManager) {

        SwipeFragment myFragment = (SwipeFragment) fragmentManager.findFragmentByTag(SwipeFragment.TAG);

        if(myFragment == null){

            myFragment = new SwipeFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_swipe, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


            Call<List<Restaurant>> call = service.sortDistance();
        try {
            Response<List<Restaurant>> response = call.execute();
            List<Restaurant> list = response.body();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!_______________________________________");

            RestaurantAdapter adapter = new RestaurantAdapter(getContext(),list);
            recyclerView.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }


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
                startActivity(new Intent(getActivity(), OrderActivity.class));
        }

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
