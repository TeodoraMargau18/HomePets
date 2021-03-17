package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.banchelorapp.adapter.ListaSaloaneAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.Salon;
import com.example.banchelorapp.utils.ServiciuSalon;

import java.util.ArrayList;
import java.util.List;

public class ListaSaloaneActivity extends AppCompatActivity {

    ListView listaSaloane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_saloane);

        Log.e("Activitate deschisa","Saloanele mele");
        listaSaloane=findViewById(R.id.listViewSaloane);

ArrayList<Salon> listaSaloaneStr=new ArrayList<>();

        ServiciuSalon s1=new ServiciuSalon("Spalat",40,"pisica");
        ServiciuSalon s2=new ServiciuSalon("Spalat și tuns",100,"pisica");
ArrayList<ServiciuSalon> servicii=new ArrayList<>();
servicii.add(s1);
servicii.add(s2);

        String p1="L-V :09-14";
        String p2="S-d: liber";
        ArrayList<String> program=new ArrayList<>();
        program.add(p1);
        program.add(p2);


Salon salon=new Salon("Mirra's Pet","Test",servicii,"0878","site","locatie",program);
        listaSaloaneStr.add(salon);
        listaSaloaneStr.add(salon);
        listaSaloaneStr.add(salon);
        listaSaloaneStr.add(salon);
        listaSaloaneStr.add(salon);
        listaSaloaneStr.add(salon);
        listaSaloaneStr.add(salon);
        listaSaloaneStr.add(salon);
        ListaSaloaneAdapter adapter=new ListaSaloaneAdapter
                (getApplicationContext(),
                        R.layout.lista_saloane_adapter,
                        listaSaloaneStr);
        listaSaloane.setAdapter(adapter);

        listaSaloane.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(),SalonSelectatActivity.class);
                startActivity(i);
            }
        });
    }
}