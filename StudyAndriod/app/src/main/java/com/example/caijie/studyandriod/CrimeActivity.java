package com.example.caijie.studyandriod;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.caijie.criminalintent.CrimeFragment;


public class CrimeActivity extends FragmentActivity {
    private CrimeFragment crimeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_me);

        crimeFragment = new CrimeFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.ll_frg_container,crimeFragment).commit();

        
    }
}

