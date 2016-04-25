package com.durodola.mobile.kinetic_contact_app;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mobile on 2016-04-24.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private SupportMapFragment fragment;
    public static String TAG;
    public static String DATA_RECEIVE_ADDRESS = "address";
    Context context;
    Bundle bundle;
    String address;
    double longitude, latitude;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mapfragment, container, false);
        context = getContext();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        bundle = this.getArguments();
        if (address != null) {
            address = bundle.getString(DATA_RECEIVE_ADDRESS);
            Log.e("address ", address);
        } else {
            address = " 1 Yonge St, Toronto, ON M5E 1E5 ";
        }

        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, fragment).commit();
        }
        fragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        // checking for position on the map using geocoder
        mMap = googleMap;
        if (mMap != null) {

            Geocoder coder = new Geocoder(context);
            try {
                ArrayList<Address> adresses = (ArrayList<Address>) coder.getFromLocationName(address, 50);
                for (Address add : adresses) {
                    if (address != null) {
                        longitude = add.getLongitude();
                        latitude = add.getLatitude();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            LatLng addrestlocation = new LatLng(latitude, longitude);

            mMap.addMarker(new MarkerOptions().position(addrestlocation).title(address));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(addrestlocation));
        } else {
            LatLng addrestlocatio = new LatLng(43.642436, -79.374488);
            mMap.addMarker(new MarkerOptions().position(addrestlocatio).title("Kinetic Cafe"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(addrestlocatio));
        }

    }

}
