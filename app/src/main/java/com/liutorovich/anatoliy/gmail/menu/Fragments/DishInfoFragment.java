package com.liutorovich.anatoliy.gmail.menu.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrules.horizontalnumberpicker.HorizontalNumberPicker;
import com.liutorovich.anatoliy.gmail.menu.Adapters.RestaurantAdapter;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.Models.Order;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;
import com.squareup.picasso.Picasso;

import static com.liutorovich.anatoliy.gmail.menu.Fragments.MainMenuFragment.orders;

/**
 * Created by ToLik on 16.02.2017.
 */

public class DishInfoFragment extends BaseFragment {

    ImageView mImageDish;
    TextView mNameDish;
    TextView mWeight;
    TextView mDescription;
    TextView mPrice;
    HorizontalNumberPicker mNumbPicker;
    Button mBtnInBag;
    private int dishId;
    private int position;
    private Toolbarlistener mToolbarlistener;
    private static final String ARG_POSITION = "position";
    private static final String ARG_FOOD_ID = "food_id";
    private Order order;

    public static DishInfoFragment newInstance(int position,int dishId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_POSITION, position);
        args.putSerializable(ARG_FOOD_ID, dishId);

        DishInfoFragment fragment = new DishInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = (int) getArguments().getSerializable(ARG_POSITION);
        dishId = (int) getArguments().getSerializable(ARG_FOOD_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_dish_info, container, false);

        mNameDish = (TextView) view.findViewById(R.id.tv_name_dish);
        mImageDish = (ImageView) view.findViewById((R.id.iv_dish));
        mWeight = (TextView) view.findViewById(R.id.tv_weight);
        mDescription = (TextView) view.findViewById(R.id.tv_description);
        mPrice = (TextView) view.findViewById(R.id.tv_price);
        mBtnInBag = (Button) view.findViewById(R.id.bt_in_bag);
        mNumbPicker = (HorizontalNumberPicker) view.findViewById(R.id.nbPicker);
        mNumbPicker.setMaxValue(99);
        mNumbPicker.setMinValue(1);
//        mNumbPicker.setWrapSelectorWheel(false);



        mNameDish.setText("«" + RestaurantAdapter.list.get(position).getDishes().get(dishId).getName() + "»");
        Picasso.with(getContext()).load("http://###########"+ RestaurantAdapter.list.get(position).getDishes().get(dishId).getUrlImage()).into(mImageDish);
        mWeight.setText("Вес: " + RestaurantAdapter.list.get(position).getDishes().get(dishId).getWeight());
        mDescription.setText(RestaurantAdapter.list.get(position).getDishes().get(dishId).getDescription());
        mPrice.setText(RestaurantAdapter.list.get(position).getDishes().get(dishId).getPrice() + " BYN");

        mBtnInBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = new Order();

                order.setIdRestaurant(RestaurantAdapter.list.get(position).getId());
                order.setNameRestaurant(RestaurantAdapter.list.get(position).getName());
                order.setAdress(RestaurantAdapter.list.get(position).getAddress());
                order.setNameDish(RestaurantAdapter.list.get(position).getDishes().get(dishId).getName());
                order.setPrice(RestaurantAdapter.list.get(position).getDishes().get(dishId).getPrice());
                order.setNumbOfDish(mNumbPicker.getValue());

                if (order!=null){
                    orders.add(order);
                }

                System.out.println(orders.toString());
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
