package mx.edu.unsis.www.androidcalius;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class simulador extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_simulador, container, false);
        viewPager =(ViewPager)view.findViewById(R.id.pager);
        viewPager.setAdapter(new sliderAdapter(getChildFragmentManager()));
        tabLayout=(TabLayout)view.findViewById(R.id.tabs);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        parciales guaradarPos=new parciales();
        // Guardando la la posicion de la aplicacion
        guaradarPos.setPosicion("simulador");
        return view;
    }

    private class sliderAdapter extends FragmentPagerAdapter {
        // final String tabs[]={"tab1","tab2"};

        public sliderAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new contenidoP1Simul();
                case 1:
                    return new contenidoP2Simul();
                case 2:
                    return new contenidoP3Simul();
                case 3:
                    return new contenidoOrdSimul();
                case 4:
                    return new contenidoFinalSimul();
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return 5;
        }
        @Override
        public CharSequence getPageTitle(int position){
            SpannableStringBuilder builder = new SpannableStringBuilder();

            switch (position){
                case 0:
                    return getString(R.string.page1);
                case 1:
                    return getString(R.string.page2);
                case 2:
                    return getString(R.string.page3);
                case 3:
                    return getString(R.string.page4);
                case 4:
                    return getString(R.string.page5);
                default:
                    return null;
            }
        }
    }



}
