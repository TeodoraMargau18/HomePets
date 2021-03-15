package com.example.banchelorapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.banchelorapp.R;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.Date;

public class ListaAnimaleAdapter extends ArrayAdapter<Animal> {
    private static final String TAG="ListaAnimaleAdapter";
    private Context mContext;
    int mResource;
    public ListaAnimaleAdapter(@NonNull Context context, int resource,
                               @NonNull ArrayList<Animal> objects){
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String numeAnimal=getItem(position).getNumeAnimal();
        String emailProprietar=getItem(position).getEmailProprietar();
        String rasaAnimal=getItem(position).getRasaAnimal();
        String sexAnimal=getItem(position).getSexAnimal();//feminin/masculin
        Date dataNasteriiAnimal=getItem(position).getDataNasteriiAnimal();
        String culoareAnimal=getItem(position).getCuloareAnimal();
        ArrayList<Vaccin> vaccineAnimal=getItem(position).getVaccinuriAnimal();
        ArrayList<Interventie> operatiiAnimal=getItem(position).getOperatiiAnimal();
        ArrayList<Deparazitare> deparazitariAnimal=getItem(position).getDeparazitariAnimal();

         Animal animal=new Animal(emailProprietar,numeAnimal,rasaAnimal,
                 sexAnimal,dataNasteriiAnimal,culoareAnimal,vaccineAnimal,operatiiAnimal,deparazitariAnimal);

        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvNume=convertView.findViewById(R.id.tvNumeAnimalListView);
        TextView tvGenVarsta=convertView.findViewById(R.id.tvGenVarsta);

        tvNume.setText(animal.getNumeAnimal());
        tvGenVarsta.setText(animal.returneazaVarstaGen());


        return convertView;
    }
}
