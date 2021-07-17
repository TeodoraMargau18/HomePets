package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.banchelorapp.adapter.ListaProgramariAdapter;

public class ProgramarileMeleActivity extends AppCompatActivity {

    ListView listaProgramari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programarile_mele);

        for(int i = 0; i<AuthentificationActivity.listaProgramarileMele.size(); i++)
        {
            Log.e("Cate programari am ?", String.valueOf(AuthentificationActivity.listaProgramarileMele.size()));
        }

        listaProgramari=findViewById(R.id.lv_programarile_mele);
        ListaProgramariAdapter adapter=new ListaProgramariAdapter
                (getApplicationContext(),
                        R.layout.lista_programari_adapter,
                        AuthentificationActivity.listaProgramarileMele);
        listaProgramari.setAdapter(adapter);

    }

}