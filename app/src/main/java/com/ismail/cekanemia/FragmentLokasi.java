package com.ismail.cekanemia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;


public class FragmentLokasi extends Fragment {


    GoogleMap  peta;
    LatLng Lokasi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lokasi, container, false);
       // SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.mapView);


        peta = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapView)).getMap();
        peta.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        try {
            Lokasi = new LatLng(-5.1347402,119.4914966);
            CameraUpdate lok = CameraUpdateFactory.newLatLngZoom(Lokasi, 14);
            peta.animateCamera(lok);
            peta.addMarker(new MarkerOptions().position(Lokasi).title("RSUP Dr. Wahidin Sudirohusodo"));
            Lokasi = new LatLng(-5.1623916,119.4309481);
            peta.addMarker(new MarkerOptions().position(Lokasi).title("Rumah Sakit Umum Islam (Faisal)"));
            Lokasi = new LatLng(-5.1623648,119.424382);
            peta.addMarker(new MarkerOptions().position(Lokasi).title("Rumah Sakit Grestelina"));
            Lokasi = new LatLng(-5.1544726,119.42338);
            peta.addMarker(new MarkerOptions().position(Lokasi).title("Rumah Sakit Ibu dan Anak (RSIA) Ananda"));
            Lokasi = new LatLng(-5.1826486,119.4250112);
            peta.addMarker(new MarkerOptions().position(Lokasi).title("RSUD Labuang Baji"));
            Lokasi = new LatLng(-5.1444282,119.4002057);
            peta.addMarker(new MarkerOptions().position(Lokasi).title("Rumah Sakit Stella Maris"));
            Lokasi = new LatLng(-5.1444282,119.4002057);
            peta.addMarker(new MarkerOptions().position(Lokasi).title("Rumah Sakit Siloam Makassar"));
        }
            catch (Exception e) {
                Log.d("Lokasi Gagal", e.toString());
            }
        return v;

    }

//    @Override
//    public void onMapReady(GoogleMap map) {
//
//        mMap = map;
//        LatLng Makassar = new LatLng(-5.2033059,119.4929246);
//        mMap.addMarker(new MarkerOptions().position(Makassar).title("Makassar"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Makassar));
//        mMap.animateCamera(CameraUpdateFactory.newLatLng(Makassar));
//
//    }
}
