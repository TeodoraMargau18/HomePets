package com.example.banchelorapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.banchelorapp.adapter.ListaInterventiiAdapter;
import com.example.banchelorapp.adapter.ListaVaccinuriAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;

public class InterventiiFragment extends Fragment {


    public static final String INTERVENTII_KEY="transferAnimal";

    Bundle bundle;
    ListView interventiiListView;

    public InterventiiFragment() {
    }
    public static InterventiiFragment newInstance(Animal animal){
        InterventiiFragment fragment=new InterventiiFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable(InterventiiFragment.INTERVENTII_KEY,animal);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_interventii,container,false);
        interventiiListView=view.findViewById(R.id.interventiiListView);
        Animal animal;
        if(getArguments()!=null){
            animal=getArguments().getParcelable(InterventiiFragment.INTERVENTII_KEY);
            Log.e("Interventii fragment",String.valueOf( animal.getOperatiiAnimal().size()));
        }
        else
            animal=new Animal();
        if(getContext()!=null)
        {
            ArrayList<Interventie> listainterventii=animal.getOperatiiAnimal();
            ListaInterventiiAdapter adapter=new ListaInterventiiAdapter
                    (getContext().getApplicationContext(),
                            R.layout.lista_interventii_adapter,
                            listainterventii);
            interventiiListView.setAdapter(adapter);
        }


        return view;
    }

}