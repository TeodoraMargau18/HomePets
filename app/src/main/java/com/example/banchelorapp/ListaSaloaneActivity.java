package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

    public static String SALON_KEY="transfer salon";
    ListView listaSaloane;
    Bundle bundle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_saloane);

        Log.e("Activitate deschisa","Saloanele mele");
        listaSaloane=findViewById(R.id.listViewSaloane);

ArrayList<Salon> listaSaloaneStr=new ArrayList<>();

        ServiciuSalon s1=new ServiciuSalon("Spalat",30,"pisica",60);
        ServiciuSalon s6=new ServiciuSalon("tuns",60,"pisica",40);
        ServiciuSalon s2=new ServiciuSalon("Spalat",20,"Caine",30);
        ServiciuSalon s3=new ServiciuSalon("tuns",50,"Caine",90);
        ServiciuSalon s4=new ServiciuSalon("Taiat gherute",7,"Caine",10);
        ServiciuSalon s5=new ServiciuSalon("Retusat",20,"Caine",30);
ArrayList<ServiciuSalon> servicii=new ArrayList<>();
servicii.add(s1);
servicii.add(s2);
servicii.add(s3);
servicii.add(s3);
servicii.add(s3);
servicii.add(s3);
servicii.add(s3);
servicii.add(s3);
servicii.add(s3);
servicii.add(s3);
servicii.add(s3);
servicii.add(s4);
servicii.add(s5);
servicii.add(s6);

        String p1="L-V : 09:00-14:00";
        String p2=" S-d: liber";
        ArrayList<String> program=new ArrayList<>();
        program.add(p1);
        program.add(p1);
        program.add(p1);
        program.add(p1);
        program.add(p1);
        program.add(p1);
        program.add(p2);
        program.add(p2);
        program.add(p2);
        program.add(p2);
        program.add(p2);
        program.add(p2);
        program.add(p2);
        program.add(p2);


Salon salon=new Salon("Nume salon","Test",servicii,"0878","site","locatie",program);
        listaSaloaneStr.add(salon);
        ListaSaloaneAdapter adapter=new ListaSaloaneAdapter
                (getApplicationContext(),
                        R.layout.lista_saloane_adapter,
                        listaSaloaneStr);
        listaSaloane.setAdapter(adapter);

        listaSaloane.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle =new Bundle();
                bundle.putParcelable(SALON_KEY, (Parcelable) listaSaloane.getItemAtPosition(position));
               intent = new Intent(getApplicationContext(),SalonSelectatActivity.class);
               intent.putExtras(bundle);
               Log.e("Lista saloane Activity","Deschid Salonul");
                startActivity(intent);
            }
        });
    }
}