package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.banchelorapp.adapter.ListaSaloaneAdapter;
import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.Salon;
import com.example.banchelorapp.utils.ServiciuSalon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaSaloaneActivity extends AppCompatActivity {

    public static String SALON_KEY="transfer salon";
    ListView listaSaloane;
    Button btnProgramarileMele;
    Bundle bundle;
    Intent intent;
    public ArrayList<Boolean> listaItemApasat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_saloane);
        listaItemApasat=new ArrayList<>();
        btnProgramarileMele=findViewById(R.id.btnProgramarileMele);
        for(int i=0;i<AuthentificationActivity.listaSaloane.size();i++)
        {
            Log.e("Cate saloane am ?", String.valueOf(AuthentificationActivity.listaSaloane.size()));
            listaItemApasat.add(false);
        }

        listaSaloane=findViewById(R.id.listViewSaloane);
        ListaSaloaneAdapter adapter=new ListaSaloaneAdapter
                (getApplicationContext(),
                        R.layout.lista_saloane_adapter,
                        AuthentificationActivity.listaSaloane);
        listaSaloane.setAdapter(adapter);

        listaSaloane.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle =new Bundle();
                 bundle.putParcelable(SALON_KEY, (Parcelable) listaSaloane.getItemAtPosition(position));
                 intent = new Intent(getApplicationContext(),SalonSelectatActivity.class);
                 intent.putExtras(bundle);
                 startActivity(intent);
            }
        });
        btnProgramarileMele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Test", "Programarile mele");

                intent=new Intent(getApplicationContext(),ProgramarileMeleActivity.class);
                startActivity(intent);
            }
        });
    }
}