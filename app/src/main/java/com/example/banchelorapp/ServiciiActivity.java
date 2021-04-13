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
            String element=salon.getServicii().get(i).getCategorieAnimal();
            String firstUpper=element.substring(0,1).toUpperCase() + element.substring(1).toLowerCase();
            if(listGroup.contains(firstUpper)){
                continue;
            }
            else{
                listGroup.add(firstUpper);
            }
        }

        for (int i = 0; i < listGroup.size(); i++) {
            ArrayList<String> listElExpandat = new ArrayList<>();
            for (int j = 0; j < salon.getServicii().size(); j++) {
                String item=salon.getServicii().get(j).getCategorieAnimal();
                String firstUpper=item.substring(0,1).toUpperCase() + item.substring(1).toLowerCase();
                    if (firstUpper.equals(listGroup.get(i)))
                    {
                        listElExpandat.add(salon.getServicii().get(j).getDenumireServiciu()
                                + " - Pret: "
                                + salon.getServicii().get(j).getTarifServiciu()
                                + " lei ");
                        listItem.put(listGroup.get(i), listElExpandat);
                    }
            }
        }



    }

}