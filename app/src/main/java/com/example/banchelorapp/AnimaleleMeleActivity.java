package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class AnimaleleMeleActivity extends AppCompatActivity {


    Intent intent;
    public static final String tranferAnimal="ANIMAL";
   ListView animalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalele_mele);
        Log.e("Activitate deschisa","Animalele mele");

        animalListView=findViewById(R.id.animalsListView);

        ListaAnimaleAdapter adapter=new ListaAnimaleAdapter
                (this,R.layout.lista_animale_adapter,AuthentificationActivity.listaAnimale);

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
                intent.putExtra(AnimaleleMeleActivity.tranferAnimal,AuthentificationActivity.listaAnimale.get(position));
                Log.e("Test", "Apasare buton luuung");
                startActivity(intent);

                return true;
            }
        });
    }
}