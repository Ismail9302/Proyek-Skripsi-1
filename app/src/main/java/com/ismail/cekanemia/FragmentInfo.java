package com.ismail.cekanemia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import static com.google.android.gms.internal.zznu.im;


public class FragmentInfo extends Fragment {

    private static ImageButton imageButton_1, imageButton_2, imageButton_3, imageButton_4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        imageButton_1 = (ImageButton)v.findViewById(R.id.buttonImage1);
        imageButton_2 = (ImageButton)v.findViewById(R.id.buttonImage2);
        imageButton_3 = (ImageButton)v.findViewById(R.id.buttonImage3);
        imageButton_4 = (ImageButton)v.findViewById(R.id.buttonImage4);

        imageButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("com.ismail.cekanemia.AnemiaAplastik");
                Intent intent = new Intent(getActivity(), AnemiaAplastik.class);
                startActivity(intent);
            }
        });

        imageButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent("com.ismail.cekanemia.AnemiaDB");
                Intent intent = new Intent(getActivity(), AnemiaDB.class);
                startActivity(intent);
            }
        });

        imageButton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent("com.ismail.cekanemia.AnemiaPK");
                Intent intent = new Intent(getActivity(), AnemiaPK.class);
                startActivity(intent);
            }
        });

        imageButton_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent("com.ismail.cekanemia.AnemiaHemolitik");
                Intent intent = new Intent(getActivity(), AnemiaHemolitik.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
