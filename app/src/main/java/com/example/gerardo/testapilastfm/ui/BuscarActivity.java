package com.example.gerardo.testapilastfm.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.ui.fragment.BuscarFragment;

public class BuscarActivity extends AppCompatActivity {

    BuscarFragment fragment;
    FragmentManager FM;
    FragmentTransaction FT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        fragment = new BuscarFragment();
        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();

        FT.add(R.id.content_buscar,fragment);
        FT.commit();

    }
}
