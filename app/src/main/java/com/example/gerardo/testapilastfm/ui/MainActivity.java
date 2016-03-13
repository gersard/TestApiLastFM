package com.example.gerardo.testapilastfm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.ui.BuscarActivity;
import com.example.gerardo.testapilastfm.ui.fragment.BuscarFragment;
import com.example.gerardo.testapilastfm.ui.fragment.TopAlbumFragment;
import com.example.gerardo.testapilastfm.ui.fragment.TopArtistFragment;
import com.example.gerardo.testapilastfm.ui.adapter.PagerAdapter;
import com.example.gerardo.testapilastfm.ui.fragment.HypedArtistFragment;
import com.example.gerardo.testapilastfm.ui.fragment.TopTrackFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    ViewPager viewPager;
    TabLayout tabLayout;
    private DrawerLayout drawerLayout;
    private String drawerTitle;
    FragmentManager FM;
    FragmentTransaction FT;
    Boolean mostrarFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        setupViewPager(mostrarFragment);

        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setupViewPager(boolean mostrar){
        if (mostrar == true) {
            viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), buildFragments()));
            tabLayout.setupWithViewPager(viewPager);

            tabLayout.getTabAt(0).setIcon(R.drawable.flama_hyped);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_band);
        }

    }

    private ArrayList<Fragment> buildFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        HypedArtistFragment hypedArtistFragment = new HypedArtistFragment();
        TopArtistFragment topArtistFragment = new TopArtistFragment();

        fragments.add(hypedArtistFragment);
        fragments.add(topArtistFragment);

        return fragments;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.nav_home:
                Toast.makeText(this,"Clickeaste Home",Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                return true;
            case R.id.nav_buscar:
                Intent intent = new Intent(this, BuscarActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
