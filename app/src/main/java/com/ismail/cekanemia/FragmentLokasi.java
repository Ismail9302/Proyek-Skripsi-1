package com.ismail.cekanemia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


public class FragmentLokasi extends Fragment implements OnMapReadyCallback {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lokasi, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.mapView);
        try {
            mapFragment.getMapAsync(this);
        } catch (Exception e) {
            Log.d("Error:", e.toString());
        }

        return v;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng Makassar = new LatLng(-5.203288, 119.498646);
        googleMap.addMarker(new MarkerOptions().position(Makassar).title("Samata"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Makassar));
    }
}
