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
import android.widget.Button;

import com.liutorovich.anatoliy.gmail.menu.Adapters.RestaurantAdapter;
import com.liutorovich.anatoliy.gmail.menu.Interface.RestaurantService;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.Models.Restaurant;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;
import com.liutorovich.anatoliy.gmail.menu.UI.SearchActivity;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.liutorovich.anatoliy.gmail.menu.Fragments.MainMenuFragment.map;

/**
 * Created by ToLik on 07.11.2016.
 */

public class SearchFragment extends BaseFragment {

    private Toolbarlistener mToolbarlistener;

    public static  List<Restaurant> list;

    private static final String TAG = SearchFragment.class.getSimpleName();


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://###########/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private RestaurantService service = retrofit.create(RestaurantService.class);


    public static SearchFragment createInstance(FragmentManager fragmentManager) {

        SearchFragment myFragment = (SearchFragment) fragmentManager.findFragmentByTag(SearchFragment.TAG);

        if(myFragment == null){

            myFragment = new SearchFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Button mBtnRating = (Button) view.findViewById(R.id.btn_rating_sort);
        Button mBtnDistance = (Button) view.findViewById(R.id.btn_distance_sort);
        Button mBtnKategory = (Button) view.findViewById(R.id.btn_kategory_sort);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Call<List<Restaurant>> call = service.searsch(map);
        try {
            Response<List<Restaurant>> response = call.execute();
            list = response.body();

            System.out.println(list.toString());

            RestaurantAdapter adapter = new RestaurantAdapter(getContext(),list);
            recyclerView.setAdapter(adapter);


        } catch (IOException e) {
            e.printStackTrace();
        }

        mBtnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(map.get("sort").equals("rating")){

                }else{
                    map.put("sort","rating");
                    getActivity().finish();
                    startActivity(new Intent(getActivity(), SearchActivity.class));
                }

            }
        });

        mBtnDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(map.get("sort").equals("distanceToUser")){

                }else{
                    map.put("sort","distanceToUser");
                    getActivity().finish();
                    startActivity(new Intent(getActivity(), SearchActivity.class));
                }
            }
        });

        mBtnKategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(map.get("sort").equals("classOfRestaurant")){

                }else{
                    map.put("sort","classOfRestaurant");
                    getActivity().finish();
                    startActivity(new Intent(getActivity(), SearchActivity.class));
                }
            }
        });

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
