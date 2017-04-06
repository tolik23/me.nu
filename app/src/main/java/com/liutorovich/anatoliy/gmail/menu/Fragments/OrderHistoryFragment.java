package com.liutorovich.anatoliy.gmail.menu.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.Toast;

import com.liutorovich.anatoliy.gmail.menu.Adapters.MenuCursorAdapter;
import com.liutorovich.anatoliy.gmail.menu.DB.MenuDataBase;
import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.MainActivity;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;

/**
 * Created by ToLik on 23.02.2017.
 */

public class OrderHistoryFragment extends BaseFragment {

    Button mDelletHistory;
    private Toolbarlistener mToolbarlistener;

    private static final String TAG = OrderHistoryFragment.class.getSimpleName();

    public static OrderHistoryFragment createInstance(FragmentManager fragmentManager) {

        OrderHistoryFragment myFragment = (OrderHistoryFragment) fragmentManager.findFragmentByTag(OrderHistoryFragment.TAG);

        if(myFragment == null){

            myFragment = new OrderHistoryFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        MenuDataBase db = new MenuDataBase(getContext());
        Cursor c = db.getAllContacts();

        View view= inflater.inflate(R.layout.fragment_order_history, container, false);

        mDelletHistory = (Button) view.findViewById(R.id.btn_dellet_history);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        MenuCursorAdapter adapter = new MenuCursorAdapter(getContext(), c);
        recyclerView.setAdapter(adapter);

        mDelletHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MenuDataBase db = new MenuDataBase(getContext());
                db.deleteAll();

                getActivity().finish();
                startActivity(new Intent(getActivity(), MainActivity.class));

                Toast.makeText(getActivity(), "История пуста", Toast.LENGTH_SHORT).show();
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
