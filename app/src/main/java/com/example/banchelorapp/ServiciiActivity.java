package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.banchelorapp.adapter.ExpandableAdapterServicii;
import com.example.banchelorapp.utils.Salon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.Toast;

public class ServiciiActivity extends AppCompatActivity {
    public static String  SERVICII_KEY="servicii";

    Intent intent;
    Salon salon;
    ExpandableListView expandableListView;
    ArrayList<String> listaCategorieAnimal;
    HashMap<String, List<String>> listItem;
    ExpandableAdapterServicii adapter;

    public void comandaFunction(){
        intent=new Intent(this.getApplicationContext(),ProgramareSalon.class);
        Log.e("Buton Apasat","Am apasat");
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicii);
        intent=getIntent();
        salon=intent.getParcelableExtra(SalonSelectatActivity.SERVICII_KEY);
        expandableListView=findViewById(R.id.expLvCategorieAnimalServicii);

        listaCategorieAnimal =new ArrayList<>();
        listItem=new HashMap<>();

        adapter=new ExpandableAdapterServicii(this.getApplicationContext(), listaCategorieAnimal,listItem);
        expandableListView.setAdapter(adapter);
        initListData(salon);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Log.e("lista",listaCategorieAnimal.get(groupPosition));
                Log.e("Elemente lista",listItem.get(listaCategorieAnimal.get(groupPosition)).get(childPosition));
                comandaFunction();
                return false;
            }
        });

    }

    private void initListData(Salon salon){
        for(int i=0;i<salon.getServicii().size();i++){
            String element=salon.getServicii().get(i).getCategorieAnimal();
            String firstUpper=element.substring(0,1).toUpperCase() + element.substring(1).toLowerCase();
            if(listaCategorieAnimal.contains(firstUpper)){
                continue;
            }
            else{
                listaCategorieAnimal.add(firstUpper);
            }
        }

        for (int i = 0; i < listaCategorieAnimal.size(); i++) {
            ArrayList<String> listElExpandat = new ArrayList<>();
            for (int j = 0; j < salon.getServicii().size(); j++) {
                String item=salon.getServicii().get(j).getCategorieAnimal();
                String firstUpper=item.substring(0,1).toUpperCase() + item.substring(1).toLowerCase();
                    if (firstUpper.equals(listaCategorieAnimal.get(i)))
                    {
                        listElExpandat.add(salon.getServicii().get(j).getDenumireServiciu()
                                + " - Pret: "
                                + salon.getServicii().get(j).getTarifServiciu()
                                + " lei ");
                        listItem.put(listaCategorieAnimal.get(i), listElExpandat);
                    }
            }
        }
    }

}