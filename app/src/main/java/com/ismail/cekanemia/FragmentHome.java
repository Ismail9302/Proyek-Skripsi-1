package com.ismail.cekanemia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentHome extends Fragment {

    TextView deskripsi;
    ImageView logoAnemia;
    Button btn_diagnosa;
    View DiagnosaUmum;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_home, container, false);


        //inisialisasi Layout
        DiagnosaUmum = LayoutInflater.from(getActivity()).inflate(R.layout.diagnosa_umum, container, false);

        //inisialisasi Button dan TextView
        return v;
    }
}
