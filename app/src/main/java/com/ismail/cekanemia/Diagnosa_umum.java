package com.ismail.cekanemia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class Diagnosa_umum extends Fragment {

    private TextView pertanyaan, count;
    private Button next;
    private RadioButton ya, tidak;
    private RadioGroup option;
    private int index = 0;
    private double aplastik = 0.0;
    private double db = 0.0;
    private double pk = 0.0;
    private double hemolitik = 0.0;
    private List<Diagnosa> penyakit = new ArrayList<>();

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_diagnosa_umum, container, false);
        final View v = inflater.inflate(R.layout.fragment_diagnosa_umum, container, false);
        pertanyaan = (TextView) v.findViewById(R.id.pertanyaan);
        next = (Button) v.findViewById(R.id.next);
        ya = (RadioButton) v.findViewById(R.id.ya);
        tidak = (RadioButton) v.findViewById(R.id.tidak);
        option = (RadioGroup) v.findViewById(R.id.option);
        count = (TextView) v.findViewById(R.id.count);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        //Menyimpan nama penyakit ke String array penyakit
        penyakit = databaseAccess.TampilPenyakit();
        databaseAccess.close();

        pertanyaan.setText(penyakit.get(index).getGejalaKlinis());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < penyakit.size()-1) {
                    if (ya.isChecked()) {
                        aplastik += penyakit.get(index).getAplastik();
                        db += penyakit.get(index).getDb();
                        pk += penyakit.get(index).getPk();
                        hemolitik += penyakit.get(index).getHemolitik();
                        showNext();
                    }
                    else if (tidak.isChecked()) {
                        showNext();
                    }
                    else {
                        Toast.makeText(getActivity(), "Harap memilih jawaban", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getActivity(), "Hasil Diagnosa : " + aplastik, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private void showNext() {
        index++;
        int x = index + 1;
        count.setText("Pertanyaan " + x);
        pertanyaan.setText(penyakit.get(index).getGejalaKlinis());
        option.clearCheck();
    }
}
