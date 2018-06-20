package com.example.mat.utsamap.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mat.utsamap.Fragment.LocationFragment;
import com.example.mat.utsamap.Fragment.PickLocationFragment;
import com.example.mat.utsamap.Fragment.MainFragment;
import com.example.mat.utsamap.Fragment.UTSAMapFragment;
import com.example.mat.utsamap.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener
        , PickLocationFragment.PickLocationFragmentInteractionListener
        , LocationFragment.LocationFragmentInteractionListener
        , UTSAMapFragment.UTSAMapFragmentInteractionListener{

    private static final String TAG = "MainActivity";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        Fragment mainFragment = (Fragment)fragmentManager.findFragmentById(R.id.fragment_container);

        if (mainFragment == null) {
            loadMainFragmentScreen();
        }
    }

    public void loadMainFragmentScreen() {
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment).commit();
    }

    public void loadUTSAMapFragmentScreen() {
        UTSAMapFragment utsaMapFragment = new UTSAMapFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, utsaMapFragment).addToBackStack(null).commit();
    }

    public void loadPickLocationFragmentScreen() {
        PickLocationFragment pickLocationFragment = new PickLocationFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickLocationFragment).addToBackStack(null).commit();
    }

    public void loadLocationFragmentScreen(String location) {
        Log.e(TAG, "Data inside LoadingScreen function ");
        Bundle bundle = new Bundle();
        bundle.putString("Data", location);
        LocationFragment locationFragment = new LocationFragment();
        locationFragment.setArguments(bundle);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, locationFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onUTSAMapFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickLocationFragmentInteraction(Uri uri) {

    }

    @Override
    public void onLocationFragmentInteraction(Uri uri) {

    }
}
