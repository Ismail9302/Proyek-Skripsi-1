package com.ismail.cekanemia;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentInfo extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_info, null);
        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                setupTabText();
            }
        });

        return v;
    }

    private void setupTabText() {
        tabLayout.getTabAt(0).setText("Aplastik");
        tabLayout.getTabAt(1).setText("Defesiensi Besi");
        tabLayout.getTabAt(2).setText("Penyakit Kronis");
        tabLayout.getTabAt(3).setText("Hemolitik");
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    getActivity();
                    return new AplastikFragment();
                case 1:
                    getActivity();
                    return new DBFragment();
                case 2:
                    getActivity();
                    return new PKFragment();
                case 3:
                    getActivity();
                    return new HemolitikFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         * <p/>
         * private int[] imageResId = {
         * R.drawable.,
         * R.drawable.ic_tab_weather,
         * R.drawable.ic_tab_calendar
         * };
         */

    }

}

