package com.example.banchelorapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.banchelorapp.adapter.GridViewAdapter;
import com.example.banchelorapp.fragments.PopUpAdoptii;
import com.example.banchelorapp.utils.AnimaleAdoptie;

import java.util.ArrayList;
import java.util.List;

public class CentruAdoptiiActivity extends AppCompatActivity {
    private GridView gridView;
    List<String> numeAnimale = new ArrayList<>();
    List<String> pozeAnimale = new ArrayList<String>();
    GridViewAdapter adapter;
    public static int pozitieAnimal=0;

    public static final String animalAdoptie = "AnimalAdoptie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centru_adoptii);

        for (AnimaleAdoptie a : AuthentificationActivity.listaAnimaleAdoptie) {
            numeAnimale.add(a.getNumeAnimal());
            pozeAnimale.add(a.getImagine());
        }

        adapter = new GridViewAdapter(CentruAdoptiiActivity.this, numeAnimale, pozeAnimale);
        gridView = findViewById(R.id.gridAnimaleAdoptie);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopUpAdoptii popUp = new PopUpAdoptii();
                Bundle bundle = new Bundle();
                bundle.putParcelable(animalAdoptie, AuthentificationActivity.listaAnimaleAdoptie.get(position));
                popUp.setArguments(bundle);
                pozitieAnimal=position;
                popUp.show(getSupportFragmentManager(), "PopUpAdoptii");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        numeAnimale = new ArrayList<>();
        pozeAnimale = new ArrayList<String>();
            for (AnimaleAdoptie a : AuthentificationActivity.listaAnimaleAdoptie) {
                numeAnimale.add(a.getNumeAnimal());
                pozeAnimale.add(a.getImagine());
            }
            adapter.updateItems(numeAnimale,pozeAnimale);
            gridView.setAdapter(adapter);
        }
}