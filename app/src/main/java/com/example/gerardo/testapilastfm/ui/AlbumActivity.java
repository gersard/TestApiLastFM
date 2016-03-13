package com.example.gerardo.testapilastfm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.ui.adapter.PagerAdapter;
import com.example.gerardo.testapilastfm.ui.fragment.HypedArtistFragment;
import com.example.gerardo.testapilastfm.ui.fragment.InfoArtistFragment;
import com.example.gerardo.testapilastfm.ui.fragment.TopAlbumFragment;
import com.example.gerardo.testapilastfm.ui.fragment.TopArtistFragment;
import com.example.gerardo.testapilastfm.ui.fragment.TopTrackFragment;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    int posicion;
    String nombre;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager2);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout2);
        setupViewPager();


        /*
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        TopAlbumFragment fragment = new TopAlbumFragment();
        TopTrackFragment topTrackFragment = new TopTrackFragment();
        FT.add(R.id.content_album, fragment);
        FT.commit();*/


        /*FT.replace(R.id.content_album, fragment);
        FT.commit();*/
    }


    private void setupViewPager(){
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), buildFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tab_info);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_track);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_tab_album);
    }

    private ArrayList<Fragment> buildFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        TopAlbumFragment topAlbumFragment = new TopAlbumFragment();
        TopTrackFragment topTrackFragment = new TopTrackFragment();
        InfoArtistFragment infoArtistFragment = new InfoArtistFragment();

        Bundle extra = getIntent().getExtras();
        posicion = extra.getInt("Posicion");
        nombre = extra.getString("Nombre");

        bundle = new Bundle();
        bundle.putString("artista", nombre);
        topAlbumFragment.setArguments(bundle);
        topTrackFragment.setArguments(bundle);
        infoArtistFragment.setArguments(bundle);

        fragments.add(infoArtistFragment);
        fragments.add(topTrackFragment);
        fragments.add(topAlbumFragment);

        return fragments;
    }



}
