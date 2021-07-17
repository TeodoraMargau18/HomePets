package com.example.banchelorapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.banchelorapp.adapter.GridViewAdapter;
import com.example.banchelorapp.utils.AnimaleAdoptie;

import java.util.ArrayList;
import java.util.List;

public class AdoptiileMeleActivity extends AppCompatActivity {

    public static boolean dinAdoptiileMele=false;

    private GridView gridView;
    List<String> numeAnimale = new ArrayList<>();
    List<String> pozeAnimale = new ArrayList<String>();
    GridViewAdapter adapter;
    public static int pozitieAnimalAdoptat =0;

    public static final String animalAdoptat = "AnimalAdoptat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptiile_mele);

        for (AnimaleAdoptie a : AuthentificationActivity.listaAnimaleAdoptatee) {
            numeAnimale.add(a.getNumeAnimal());
            pozeAnimale.add(a.getImagine());
        }

        adapter = new GridViewAdapter(AdoptiileMeleActivity.this, numeAnimale, pozeAnimale);
        gridView = findViewById(R.id.gridAnimaleAdoptate);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dinAdoptiileMele=true;
                PopUpAnimaleAdoptate popUp = new PopUpAnimaleAdoptate();
                Bundle bundle = new Bundle();
                bundle.putParcelable(animalAdoptat, AuthentificationActivity.listaAnimaleAdoptatee.get(position));
                popUp.setArguments(bundle);
                pozitieAnimalAdoptat =position;
                popUp.show(getSupportFragmentManager(), "PopUpAdoptii");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        numeAnimale = new ArrayList<>();
        pozeAnimale = new ArrayList<String>();
        for (AnimaleAdoptie a : AuthentificationActivity.listaAnimaleAdoptatee) {
            numeAnimale.add(a.getNumeAnimal());
            pozeAnimale.add(a.getImagine());
        }
        adapter.updateItems(numeAnimale,pozeAnimale);
        gridView.setAdapter(adapter);
    }
}