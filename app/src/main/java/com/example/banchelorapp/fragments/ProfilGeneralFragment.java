package com.example.banchelorapp.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.banchelorapp.MainActivity;
import com.example.banchelorapp.ProfilMedicalActivity;
import com.example.banchelorapp.R;
import com.example.banchelorapp.adapter.ExpandableAdapter;
import com.example.banchelorapp.adapter.ListaVaccinuriAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Vaccin;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfilGeneralFragment extends Fragment {

    public static final String PROFILGENERAL_KEY ="transferAnimal";

    ExpandableListView expandableListView;
    ArrayList<String> listGroup;
    HashMap<String,List<String>> listItem;
    ExpandableAdapter adapter;
    ImageView ivAnimalProfil;

    public ProfilGeneralFragment() {
    }


    public static ProfilGeneralFragment newInstance(Animal animal){
        ProfilGeneralFragment fragment=new ProfilGeneralFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable(ProfilGeneralFragment.PROFILGENERAL_KEY,animal);
        fragment.setArguments(bundle);
        return  fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.fragment_profil_general, container, false);
        ivAnimalProfil=view.findViewById(R.id.imgFragmentGeneral);
      //-------------

        expandableListView=view.findViewById(R.id.expLvProfilGeneral);

        Animal animal;
        if(getArguments()!=null){
            animal=getArguments().getParcelable(ProfilGeneralFragment.PROFILGENERAL_KEY);
        }
        else
            animal=new Animal();

        listGroup=new ArrayList<>();
        listItem=new HashMap<>();

        adapter=new ExpandableAdapter(this.getContext(),listGroup,listItem);
        expandableListView.setAdapter(adapter);
        Picasso.get().load(ProfilMedicalActivity.animal.getImagine().trim()).into(ivAnimalProfil);
        initListData(animal);
        //pana aici

        if(getContext()!=null)
        {
            ArrayList<Vaccin> listaVaccinuri=animal.getVaccinuriAnimal();
            ListaVaccinuriAdapter adapter=new ListaVaccinuriAdapter
                    (getContext().getApplicationContext(),
                            R.layout.lista_vaccinuri_adapter,
                            listaVaccinuri);
//            vaccinuriListView.setAdapter(adapter);
        }

      //-------------
    return view;
    }

    private void initListData(Animal animal){
        listGroup.add("Proprietar");
        listGroup.add("Descriere animal");
        listGroup.add("Identificare animal");

        ArrayList<String> array;
        //vectorul in care bag toate elementele unei liste expandabile

        ArrayList<String> list1=new ArrayList<>();
        array=new ArrayList<>();
        array.add("Nume: "+ MainActivity.proprietarGeneral.getNume());
        array.add("Prenume: "+MainActivity.proprietarGeneral.getPrenume());
        array.add("Adresa: "+MainActivity.proprietarGeneral.getAdresa());
        array.add("Telefon: "+MainActivity.proprietarGeneral.getNumarTel());
        for (String item : array) {
            list1.add(item);
        }

        ArrayList<String> list2=new ArrayList<>();
        array=new ArrayList<>();
        array.add("Nume: "+ProfilMedicalActivity.animal.getNumeAnimal());
        array.add("Rasa: "+ProfilMedicalActivity.animal.getRasaAnimal());
        array.add("Sex: "+ProfilMedicalActivity.animal.getSexAnimal());
        array.add("Data nasterii: "+ DialogFragmentAnimal.formatareData(ProfilMedicalActivity.animal.getDataNasteriiAnimal().toString()));
        array.add("Culoare: "+ProfilMedicalActivity.animal.getCuloareAnimal());
        for (String item : array) {
            list2.add(item);
        }

        ArrayList<String> list3=new ArrayList<>();
        array=new ArrayList<>();
        array.add("CIP: "+ProfilMedicalActivity.animal.getCIP());
        array.add("Semne particulare: "+ProfilMedicalActivity.animal.getSemneParticulare());
        for (String item : array) {
            list3.add(item);
        }


        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        adapter.notifyDataSetChanged();

    }
}