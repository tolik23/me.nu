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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.liutorovich.anatoliy.gmail.menu.Adapters.RestaurantAdapter;
import com.liutorovich.anatoliy.gmail.menu.Adapters.ReviewsAdapter;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by ToLik on 25.11.2016.
 */

public class RestaurantInfoFragment extends BaseFragment {

    private int position;
    private Toolbarlistener mToolbarlistener;
    Button mMenu;
    Button mReviews;
    TextView mTextViewNameRest;
    ImageView mLogoRest;
    RatingBar mRatingBarRest;
    TextView mNumbReview;
    TextView mAdressRest;
    TextView mKitchenRest;
    TextView mWorkTime;
    TextView mPhoneRest;
    TextView mClassOfRest;
    TextView mInfoRest;

    private static final String TAG = RestaurantInfoFragment.class.getSimpleName();

    public static RestaurantInfoFragment createInstance(FragmentManager fragmentManager) {
        RestaurantInfoFragment myFragment = (RestaurantInfoFragment) fragmentManager.findFragmentByTag(RestaurantInfoFragment.TAG);
        if(myFragment == null){

            myFragment = new RestaurantInfoFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        position = this.getArguments().getInt("position");

        View view= inflater.inflate(R.layout.fragment_restaurant_info, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_reviews);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mMenu = (Button) view.findViewById(R.id.btn_menu);
        mReviews = (Button) view.findViewById(R.id.btn_reviews);
        mTextViewNameRest = (TextView) view.findViewById(R.id.tv_name_rest);
        mLogoRest = (ImageView) view.findViewById((R.id.iv_logo_rest));
        mRatingBarRest = (RatingBar) view.findViewById(R.id.rb_rest);
        mNumbReview = (TextView) view.findViewById(R.id.tv_numb_review);
        mAdressRest = (TextView) view.findViewById(R.id.tv_adress);
        mKitchenRest = (TextView) view.findViewById(R.id.tv_kitchen);
        mWorkTime = (TextView) view.findViewById(R.id.tv_time);
        mPhoneRest = (TextView) view.findViewById(R.id.tv_phone);
        mClassOfRest = (TextView) view.findViewById(R.id.tv_class);
        mInfoRest = (TextView) view.findViewById(R.id.tv_info_rest);

        mTextViewNameRest.setText(RestaurantAdapter.list.get(position).getType() +" «"+ RestaurantAdapter.list.get(position).getName()+"»");
        Picasso.with(getContext()).load("http://############"+ RestaurantAdapter.list.get(position).getImages().get(0).getUrl()).into(mLogoRest);
        mRatingBarRest.setRating(RestaurantAdapter.list.get(position).getRating());
        mNumbReview.setText("Отзывы:" + RestaurantAdapter.list.get(position).getNumberOfReviews());
        mAdressRest.setText(RestaurantAdapter.list.get(position).getAddress());
        mKitchenRest.setText(RestaurantAdapter.list.get(position).getKitchen().toString());
        mWorkTime.setText(RestaurantAdapter.list.get(position).getWorkTime().toString());
        mPhoneRest.setText(RestaurantAdapter.list.get(position).getPhone());
        mClassOfRest.setText(RestaurantAdapter.list.get(position).getClassOfRestaurant());
        mInfoRest.setText(RestaurantAdapter.list.get(position).getInfo());

        ReviewsAdapter adapter = new ReviewsAdapter(getContext(),RestaurantAdapter.list,position);
        recyclerView.setAdapter(adapter);

        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(getActivity(), MenuActivity.class);
//                intent.putExtra("position",position);
//                startActivity(intent);

//                Intent intent = MenuActivity.newIntent(getActivity(),position);
//                startActivity(intent);
//                startActivity(new Intent(getActivity(), MenuActivity.class));

                FragmentManager fm = getActivity().getSupportFragmentManager();

                fm.beginTransaction()
                        .replace(R.id.conteiner, MenuFragment.createInstance(getActivity().getSupportFragmentManager(),position))
                        .addToBackStack(null)
                        .commit();
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
        return null;
    }
}
