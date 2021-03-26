package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.banchelorapp.adapter.ListaAnimaleAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.Date;

public class AnimaleleMeleActivity extends AppCompatActivity {
    Intent intent;
    public static final String tranferAnimal="ANIMAL";
    private  static  final String AnimaleleMele_TAG="AnimaleleMele";
    ListView animalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalele_mele);
        Log.e("Activitate deschisa","Animalele mele");
//testez
       Date dataMMMM=new Date(1999  ,06,01);
        ArrayList<Vaccin> listaVaccinuri=new ArrayList<>();
        Vaccin v= new Vaccin("antirabic",new Date(2000,06,01),new Date(2000,06,13),"popescu18");
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        listaVaccinuri.add(v);
        ArrayList<Interventie> listaOperatii=new ArrayList<>();
        Interventie interventie =new Interventie("Cezariana",new Date(2021,01,01),"Gigel");
        Interventie interventie2 =new Interventie("Tratament parvoviroza",new Date(2021,01,01),"Teodora");
        listaOperatii.add(interventie);
        listaOperatii.add(interventie2);
        listaOperatii.add(interventie);
        listaOperatii.add(interventie2);
        listaOperatii.add(interventie);
        listaOperatii.add(interventie2);
        listaOperatii.add(interventie);
        listaOperatii.add(interventie2);
        listaOperatii.add(interventie);
        listaOperatii.add(interventie2);
        listaOperatii.add(interventie);
        listaOperatii.add(interventie2);
        ArrayList<Deparazitare> listaDeparazitari=new ArrayList<Deparazitare>();
        Deparazitare deparazitare=new Deparazitare(dataMMMM,dataMMMM,"INTERNA","Cestal");
         Deparazitare deparazitare2=new Deparazitare(dataMMMM,dataMMMM,"EXTERNA","Parakill");
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
        listaDeparazitari.add(deparazitare);
        listaDeparazitari.add(deparazitare2);
       Animal a= new Animal("test","Gogo","bichon","feminin",
                dataMMMM,"crem",
                listaVaccinuri,
                listaOperatii,listaDeparazitari);
        Animal a1= new Animal("test","Sysy","bichon","feminin",
                dataMMMM,"crem",
                listaVaccinuri,
                listaOperatii,listaDeparazitari);
        Animal a2= new Animal("test","Pittie","british","feminin",
                dataMMMM,"crem",
                listaVaccinuri,
                listaOperatii,listaDeparazitari);
        ArrayList<Animal> listaAnimale=new ArrayList<Animal>();
        listaAnimale.add(a);
        listaAnimale.add(a1);
        listaAnimale.add(a2);
        listaAnimale.add(a);
        listaAnimale.add(a1);
        listaAnimale.add(a2);
        listaAnimale.add(a);
        listaAnimale.add(a1);
        listaAnimale.add(a2);
        listaAnimale.add(a);
        listaAnimale.add(a);
        listaAnimale.add(a);
        listaAnimale.add(a);
        animalListView=findViewById(R.id.animalsListView);


        ListaAnimaleAdapter adapter=new ListaAnimaleAdapter
                (this,R.layout.lista_animale_adapter,listaAnimale);

        animalListView.setAdapter(adapter);

        animalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragmentAnimal dialogFragmentAnimal=new DialogFragmentAnimal();
                dialogFragmentAnimal.show(getSupportFragmentManager(),"MyDialogFragment");


                Toast.makeText(getApplicationContext(),"Hello ai apasat ceva ",Toast.LENGTH_LONG).show();
            }
        });
        animalListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                intent=new Intent(getApplicationContext(),ProfilMedicalActivity.class);
                intent.putExtra(AnimaleleMeleActivity.tranferAnimal,a);
                Log.e("Test", "Apasare buton luuung");
                startActivity(intent);

                return true;
            }
        });
    }
}