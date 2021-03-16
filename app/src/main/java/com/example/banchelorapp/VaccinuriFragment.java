package com.example.banchelorapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.banchelorapp.adapter.ListaAnimaleAdapter;
import com.example.banchelorapp.adapter.ListaVaccinuriAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.List;

public class VaccinuriFragment extends Fragment {

    public static final String VACCINURI_KEY="transferAnimal";
    Bundle bundle;
    ListView vaccinuriListView;

    public VaccinuriFragment() {

    }
    public static VaccinuriFragment newInstance(Animal animal){
        VaccinuriFragment fragment=new VaccinuriFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable(VaccinuriFragment.VACCINURI_KEY,animal);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_vaccinuri,container,false);
        vaccinuriListView=view.findViewById(R.id.vaccineListView);
        Animal animal;
        if(getArguments()!=null){
            animal=getArguments().getParcelable(VaccinuriFragment.VACCINURI_KEY);
            Log.e("Vaccinuri fragment",String.valueOf( animal.getVaccinuriAnimal().size()));
        }
        else
            animal=new Animal();
        if(getContext()!=null)
        {
            ArrayList<Vaccin> listaVaccinuri=animal.getVaccinuriAnimal();
            ListaVaccinuriAdapter adapter=new ListaVaccinuriAdapter
                    (getContext().getApplicationContext(),
                            R.layout.lista_vaccinuri_adapter,
                            listaVaccinuri);
            vaccinuriListView.setAdapter(adapter);
        }


        return view;
    }

}