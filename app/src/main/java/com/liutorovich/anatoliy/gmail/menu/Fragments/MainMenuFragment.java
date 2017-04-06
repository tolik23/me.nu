package com.liutorovich.anatoliy.gmail.menu.Fragments;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.liutorovich.anatoliy.gmail.menu.Interface.Toolbarlistener;
import com.liutorovich.anatoliy.gmail.menu.Models.Order;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.FilterActivity;
import com.liutorovich.anatoliy.gmail.menu.UI.OrderActivity;
import com.liutorovich.anatoliy.gmail.menu.UI.SearchActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ToLik on 07.11.2016.
 */

public class MainMenuFragment extends BaseFragment {

    private LocationManager locationManager;
    public static HashMap<String, String> map = new HashMap<String, String>();
    public static ArrayList<Order> orders = new ArrayList<>();
    private Toolbarlistener mToolbarlistener;
    public static double mLatitude;
    public static double mLongitude;
    Button mButton;
    ImageButton mButtonSearch;
    EditText mEtEntry;

    private static final String TAG = MainMenuFragment.class.getSimpleName();

    public static MainMenuFragment createInstance(FragmentManager fragmentManager) {
        MainMenuFragment myFragment = (MainMenuFragment) fragmentManager.findFragmentByTag(MainMenuFragment.TAG);

        if (myFragment == null) {

            myFragment = new MainMenuFragment();
        }
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        mButton = (Button) view.findViewById(R.id.btn_filtr);
        mButtonSearch = (ImageButton) view.findViewById(R.id.btn_search);
        mEtEntry = (EditText) view.findViewById(R.id.et_entry);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FilterActivity.class));
            }
        });
        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(String.valueOf(mEtEntry.getText()));
//                Map<String,String> map = new HashMap<String, String>();
                if (mEtEntry.getText().length() != 0) {
                    System.out.println("not null");
                    map.put("search", String.valueOf(mEtEntry.getText()));
                    map.put("sort", "rating");

                    for (Map.Entry e : map.entrySet()) {
                        System.out.println(e.getKey() + " " + e.getValue());
                    }
                } else {
                    System.out.println("null");
                    map.put("sort", "rating");
                }

                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });
        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Toolbarlistener) {
            mToolbarlistener = (Toolbarlistener) context;
            // поддержка меню в кнопке тулбара
            setHasOptionsMenu(true);
        }
    }

    @Override
    public void onDetach() {
        mToolbarlistener = null;
        super.onDetach();
        setHasOptionsMenu(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_one, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_sync:
                Toast.makeText(getActivity(), "Action sync", Toast.LENGTH_SHORT).show();
            case R.id.action_shopping:
//                Toast.makeText(getActivity(), "Action sync", Toast.LENGTH_SHORT).show();
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

//    @Override
//    public void onResume() {
//        super.onResume();
//
//        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
//                1000 * 2, 1, locationListener);
//        locationManager.requestLocationUpdates(
//                LocationManager.NETWORK_PROVIDER, 1000 * 2, 1,
//                locationListener);
//    }
//
//        private LocationListener locationListener = new LocationListener() {
//
//        @Override
//        public void onLocationChanged(Location location) {
////            mLatitude=location.getLatitude();
////            mLongitude=location.getLongitude();
////            String txt = "Текущее местоположение: " + "\nLatitud = "
////                    + mLatitude + "\nLongitud = " + mLongitude;
////            Toast.makeText(getActivity(), txt,
////                        Toast.LENGTH_LONG).show();
//
//            showLocation(location);
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//            Toast.makeText(getActivity(), "Gps выключен",
//                    Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//            Toast.makeText(getActivity(), "Gps включен",
//                    Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//        }
//    };
//
//        private void showLocation(Location location) {
//        if (location == null)
//            return;
//        if (location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
//            Toast.makeText(getActivity(),"gps" + location.getLatitude()+ location.getLongitude(),
//                    Toast.LENGTH_LONG).show();
//        } else if (location.getProvider().equals(LocationManager.NETWORK_PROVIDER)) {
//            Toast.makeText(getActivity(),"gps" + location.getLatitude()+ location.getLongitude(),
//                    Toast.LENGTH_LONG).show();
//        }
//    }


//    private LocationListener locationListener = new LocationListener() {
//
//        @Override
//        public void onLocationChanged(Location location) {
//            showLocation(location);
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//            checkEnabled();
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//            checkEnabled();
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            showLocation(locationManager.getLastKnownLocation(provider));
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//            if (provider.equals(LocationManager.GPS_PROVIDER)) {
//                Toast.makeText(getActivity(), "Gps включен",
//                        Toast.LENGTH_LONG).show();
//            } else if (provider.equals(LocationManager.NETWORK_PROVIDER)) {
//                Toast.makeText(getActivity(), "net включен",
//                        Toast.LENGTH_LONG).show();
//            }
//        }
//    };
//
//    private void showLocation(Location location) {
//        if (location == null)
//            return;
//        if (location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
//            Toast.makeText(getActivity(), "GPS_PROVIDER lat=" +location.getLatitude()+ " long="+location.getLongitude() ,
//                    Toast.LENGTH_LONG).show();
//        } else if (location.getProvider().equals(
//                LocationManager.NETWORK_PROVIDER)) {
//            Toast.makeText(getActivity(), "NETWORK_PROVIDER lat=" +location.getLatitude()+ " long="+location.getLongitude() ,
//                    Toast.LENGTH_LONG).show();
//        }
//    }
//
////    private String formatLocation(Location location) {
////        if (location == null)
////            return "";
////        return String.format(
////                "Coordinates: lat = %1$.4f, lon = %2$.4f, time = %3$tF %3$tT",
////                location.getLatitude(), location.getLongitude(), new Date(
////                        location.getTime()));
////    }
//
//    private void checkEnabled() {
//
//    }
}
