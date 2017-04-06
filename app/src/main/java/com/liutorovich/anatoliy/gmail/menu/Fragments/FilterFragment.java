package com.liutorovich.anatoliy.gmail.menu.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.liutorovich.anatoliy.gmail.menu.Adapters.ExpandableListAdapter;
import com.liutorovich.anatoliy.gmail.menu.Interface.RestaurantService;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.Models.Filter_Parametrses;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.liutorovich.anatoliy.gmail.menu.R.id.exListView;

/**
 * Created by ToLik on 07.11.2016.
 */

public class FilterFragment extends BaseFragment {

    private Toolbarlistener mToolbarlistener;

    List<String> groupName;
    List<Integer> iconGroup;
    HashMap<String, List<String>> expDetails;
    Filter_Parametrses filter;

    private static final String TAG = FilterFragment.class.getSimpleName();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://178.124.206.44/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private RestaurantService service = retrofit.create(RestaurantService.class);


    public static FilterFragment createInstance(FragmentManager fragmentManager) {

        FilterFragment myFragment = (FilterFragment) fragmentManager.findFragmentByTag(FilterFragment.TAG);

        if(myFragment == null){

            myFragment = new FilterFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_filter, container, false);

        ExpandableListView mExListView = (ExpandableListView) view.findViewById(exListView);
        Button mActFilterBtn = (Button) view.findViewById(R.id.btn_actyon_filter);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Call<Filter_Parametrses> call = service.filter();
        try {

            Response<Filter_Parametrses> response = call.execute();
            filter  = (Filter_Parametrses) response.body();

            prepareListData();
            groupName = new ArrayList<String>();
            List<String> listKitchen = new ArrayList<String>();
            List<String> listDish = new ArrayList<String>();
            List<String> listKlass = new ArrayList<String>();
            List<String> listType = new ArrayList<String>();
            List<String> listOthers = new ArrayList<String>();
            List<String> listRating = new ArrayList<String>();
            List<List<String>> lists = new ArrayList<List<String>>();



            System.out.println("_______________________________________"+filter.toString());

            for(int i=0; i<filter.parametrses.size() ; i++){
                groupName.add(filter.parametrses.get(i).getFilterSectionName());
            }

            for(int i=0; i<filter.parametrses.size() ; i++){
                for(int j=0; j<filter.parametrses.get(i).filtersList.size(); j++){
                    if(filter.parametrses.get(i).getId() == (1)){
                        listKitchen.add(filter.parametrses.get(i).filtersList.get(j).getFilterName());
                    }
                    if(filter.parametrses.get(i).getId() == (2)){
                        listDish.add(filter.parametrses.get(i).filtersList.get(j).getFilterName());
                    }
                    if(filter.parametrses.get(i).getId() == (3)){
                        listKlass.add(filter.parametrses.get(i).filtersList.get(j).getFilterName());
                    }
                    if(filter.parametrses.get(i).getId() == (4)){
                        listType.add(filter.parametrses.get(i).filtersList.get(j).getFilterName());
                    }
                    if(filter.parametrses.get(i).getId() == (5)){
                        listOthers.add(filter.parametrses.get(i).filtersList.get(j).getFilterName());
                    }
                    if(filter.parametrses.get(i).getId() == (6)){
                        listRating.add(filter.parametrses.get(i).filtersList.get(j).getFilterName());
                    }

                }

            }

            for(int i=0; i<listKitchen.size() ; i++){
                System.out.println("listKitchen  "+listKitchen.get(i));
            }

            for(int i=0; i<listDish.size() ; i++){
                System.out.println("listDish  "+listDish.get(i));
            }

            for(int i=0; i<listKlass.size() ; i++){
                System.out.println("listKlass  "+listKlass.get(i));
            }

            for(int i=0; i<listType.size() ; i++){
                System.out.println("listType  "+listType.get(i));
            }

            for(int i=0; i<listOthers.size() ; i++){
                System.out.println("listOthers  "+listOthers.get(i));
            }
            for(int i=0; i<listRating.size() ; i++){
                System.out.println("listRating  "+listRating.get(i));
            }

            lists.add(listKitchen);
            lists.add(listDish);
            lists.add(listKlass);
            lists.add(listType);
            lists.add(listOthers);
            lists.add(listRating);

             expDetails = new HashMap<>();
            for (int i = 0; i<groupName.size(); i++){
                expDetails.put(groupName.get(i), lists.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ExpandableListAdapter listAdapter = new ExpandableListAdapter(getContext(), groupName, expDetails, iconGroup);
        mExListView.setAdapter(listAdapter);

        mActFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!_______________________________________");

                for (Map.Entry e : ExpandableListAdapter.mChildCheckStates.entrySet()){
                    System.out.println(e.getKey()+" "+e.getValue());

                    int i=0;
                    for (boolean entry : ExpandableListAdapter.mChildCheckStates.get(e.getKey())){
                        System.out.println("  " + entry);

                        filter.parametrses.get((Integer) e.getKey()).getFiltersList().get(i).setValue(entry);

                        i=i+1;
                    }
                }

                System.out.println("_______________________________________"+filter.toString());


//                startActivity(new Intent(getActivity(), SearchActivity.class));
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


    private void prepareListData(){

        iconGroup = new ArrayList<>();

        iconGroup.add(R.drawable.ic_kitchen);
        iconGroup.add(R.drawable.ic_dishes);
        iconGroup.add(R.drawable.ic_type);
        iconGroup.add(R.drawable.ic_klass);
        iconGroup.add(R.drawable.ic_offers);
        iconGroup.add(R.drawable.ic_rating);
    }
}
