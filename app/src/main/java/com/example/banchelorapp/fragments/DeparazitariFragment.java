package com.example.banchelorapp.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.banchelorapp.R;
import com.example.banchelorapp.adapter.ListaDeparazitariAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Deparazitare;

import java.util.ArrayList;

public class DeparazitariFragment extends Fragment {


    public static final String DEPARAZITARI_KEY="transferAnimal";

    ListView deparazitariListView;

    public DeparazitariFragment() {
    }
    public static DeparazitariFragment newInstance(Animal animal){
        DeparazitariFragment fragment=new DeparazitariFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable(DeparazitariFragment.DEPARAZITARI_KEY,animal);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_deparazitari,container,false);
        deparazitariListView=view.findViewById(R.id.deparazitariListView);
        Animal animal;
        if(getArguments()!=null){
            animal=getArguments().getParcelable(DeparazitariFragment.DEPARAZITARI_KEY);
        }
        else
            animal=new Animal();
        if(getContext()!=null)
        {
            ArrayList<Deparazitare> listaDeparazitari=animal.getDeparazitariAnimal();
            ListaDeparazitariAdapter adapter=new ListaDeparazitariAdapter
                    (getContext().getApplicationContext(),
                            R.layout.lista_deparazitari_adapter,
                            listaDeparazitari);
            deparazitariListView.setAdapter(adapter);
        }


        return view;
    }
}