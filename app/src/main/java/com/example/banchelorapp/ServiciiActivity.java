package com.example.banchelorapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.banchelorapp.adapter.ExpandableAdapterServicii;
import com.example.banchelorapp.adapter.ListaVaccinuriAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.Salon;
import com.example.banchelorapp.utils.ServiciuSalon;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiciiActivity extends AppCompatActivity {
    public static String  SERVICII_KEY="servicii";

    Intent intent;
    Salon salon;
    ExpandableListView expandableListView;
    ArrayList<String> listGroup;
    HashMap<String, List<String>> listItem;
    ExpandableAdapterServicii adapter;

    public void comandaFunction(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicii);
        intent=getIntent();
        salon=intent.getParcelableExtra(SalonSelectatActivity.SERVICII_KEY);
        expandableListView=findViewById(R.id.expLvCategorieAnimalServicii);

        listGroup=new ArrayList<>();
        listItem=new HashMap<>();

        adapter=new ExpandableAdapterServicii(this.getApplicationContext(),listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData(salon);
    }

    private void initListData(Salon salon){

        for(int i=0;i<salon.getServicii().size();i++){
            if(listGroup.contains(salon.getServicii().get(i).getCategorieAnimal().toString())){
                continue;
            }
            else{
                listGroup.add(salon.getServicii().get(i).getCategorieAnimal().toString());
                ArrayList<String> listElExpandat = new ArrayList<>();
                for (int j = 0; j < salon.getServicii().size(); j++) {
                    if (salon.getServicii().get(j).getCategorieAnimal().equals(salon.getServicii().get(i).getCategorieAnimal())) {
                        listElExpandat.add(salon.getServicii().get(j).getDenumireServiciu().toString()
                                + " - Pret: "
                                + salon.getServicii().get(j).getTarifServiciu()
                                + " lei ");
                    }
                }
                listItem.put(listGroup.get(i), listElExpandat);
                adapter.notifyDataSetChanged();
                Log.e("ServiciiActivity", "S-a adaugat Categoria");
            }
        }

    }

}