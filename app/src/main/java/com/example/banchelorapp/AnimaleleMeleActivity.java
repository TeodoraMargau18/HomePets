package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Operatie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimaleleMeleActivity extends AppCompatActivity {

ImageView imgAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalele_mele);
        Log.e("Activitate deschisa","Animalele mele");
        imgAnimal=findViewById(R.id.animalImageView);

//testez
       Date dataMMMM=new Date(2021,02,01);
        List<Vaccin> listaVaccine=new ArrayList<>();
        Vaccin v= new Vaccin("antirabic",new Date(2000,06,01),"popescu18");
        listaVaccine.add(v);
        List<Operatie> listaOperatii=new ArrayList<>();
        Operatie operatie=new Operatie("Cezariana",new Date(2021,01,01),"Gigel");
        listaOperatii.add(operatie);
        List<Deparazitare> listaDeparazitari=new ArrayList<Deparazitare>();
        Deparazitare deparazitare=new Deparazitare(dataMMMM,"Interna","Cestal");
        listaDeparazitari.add(deparazitare);


        Animal a= new Animal("test","Gogo","bichon","feminin",
                dataMMMM,"crem",
                listaVaccine,
                listaOperatii,listaDeparazitari);
        List<Animal> listaAnimale=new ArrayList<Animal>();
        listaAnimale.add(a);
        listaAnimale.add(a);
        ListView animalListView=findViewById(R.id.animalsListView);

        ArrayAdapter<Animal> adapter=new ArrayAdapter<>
                (getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        listaAnimale);
        animalListView.setAdapter(adapter);

        animalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imgAnimal.setImageResource(R.drawable.padlock);

            }
        });
        animalListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ProfilMedicalActivity.class);
                Log.e("Test", "Apasare buton luuung");
                startActivity(intent);
                return true;
            }
        });

//                new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),ProfilMedicalActivity.class);
//                Log.e("Test", "Apasare buton luuung");
//                startActivity(intent);
//                return true;
//            }
//        });



    }
}