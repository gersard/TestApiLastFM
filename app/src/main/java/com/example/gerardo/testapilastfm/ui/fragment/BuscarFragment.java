package com.example.gerardo.testapilastfm.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gerardo.testapilastfm.ui.AlbumActivity;
import com.example.gerardo.testapilastfm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment implements View.OnClickListener {

    Button btnBuscar;
    EditText txtBanda;
    public BuscarFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_buscar,container,false);

        btnBuscar = (Button) root.findViewById(R.id.btn_buscar);
        txtBanda = (EditText) root.findViewById(R.id.buscar_artista);
        btnBuscar.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), AlbumActivity.class);
        intent.putExtra("Nombre",txtBanda.getText().toString());
        startActivity(intent);
    }
}
