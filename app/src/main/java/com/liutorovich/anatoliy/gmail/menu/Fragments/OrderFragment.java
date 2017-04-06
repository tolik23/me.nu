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
import android.widget.TextView;
import android.widget.Toast;

import com.liutorovich.anatoliy.gmail.menu.Adapters.OrderAdapter;
import com.liutorovich.anatoliy.gmail.menu.DB.MenuDataBase;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.liutorovich.anatoliy.gmail.menu.Fragments.MainMenuFragment.orders;

/**
 * Created by ToLik on 12.02.2017.
 */

public class OrderFragment extends BaseFragment {

    TextView mNameRest;
    TextView mAdressRest;
    TextView mResultSum;
    Button mCheckout;
    Button mCleanBag;
    final String LOG_TAG = "myLogs";

    private Toolbarlistener mToolbarlistener;
    private static final String TAG = OrderFragment.class.getSimpleName();


    public static OrderFragment createInstance(FragmentManager fragmentManager) {

        OrderFragment myFragment = (OrderFragment) fragmentManager.findFragmentByTag(OrderFragment.TAG);

        if(myFragment == null){

            myFragment = new OrderFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        System.out.println(orders.toString());

        View view= inflater.inflate(R.layout.fragment_order, container, false);

        mNameRest = (TextView) view.findViewById(R.id.tv_name_rest);
        mAdressRest = (TextView) view.findViewById(R.id.tv_adress);
        mResultSum = (TextView) view.findViewById(R.id.tv_result_sum);
        mCheckout = (Button) view.findViewById(R.id.btn_checkout);
        mCleanBag = (Button) view.findViewById(R.id.btn_clean_bag);


        double sum=0;
        for(int i = 0; i<orders.size();i++){
           sum= sum + (orders.get(i).getPrice());
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_order);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mNameRest.setText(MainMenuFragment.orders.get(0).getNameRestaurant());
        mAdressRest.setText(MainMenuFragment.orders.get(0).getAdress());
        mResultSum.setText(sum + " BYN");

        OrderAdapter adapter = new OrderAdapter(getContext(),MainMenuFragment.orders);
        recyclerView.setAdapter(adapter);

        final double finalSum = sum;
        mCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                String date = dateFormat.format(new Date());

                MenuDataBase db = new MenuDataBase(getContext());
                db.addContact(MainMenuFragment.orders.get(0).getNameRestaurant(), MainMenuFragment.orders.get(0).getAdress(), finalSum, date );
                Toast.makeText(getActivity(), "Заказ оформлен.", Toast.LENGTH_SHORT).show();
                MainMenuFragment.orders.clear();
                getActivity().finish();
                startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });

        mCleanBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                Toast.makeText(getActivity(), "Корзина заказов пуста", Toast.LENGTH_SHORT).show();
                MainMenuFragment.orders.clear();
                getActivity().finish();
                startActivity(new Intent(getActivity(), MainActivity.class));

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
