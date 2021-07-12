package com.example.banchelorapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.banchelorapp.AnimaleleMeleActivity;
import com.example.banchelorapp.R;
import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;
import com.squareup.picasso.Picasso;

public class DialogFragmentAnimal extends DialogFragment {

    EditText etDespre;
    TextView tvNume, tvSpecie, tvRasa,tvDataN, tvVarsta;
    Button btnInchide;
    Button btnSalveaza;
    DialogFragmentAnimal dlg;
    ImageView img;
    ImageView imgSex;
    Animal animal;
    String descriereAnimal;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.dialog_fragment_animal,container,false);
        etDespre =view.findViewById(R.id.etNotite);
        tvNume=view.findViewById(R.id.dialogFragmentNume);
        tvSpecie=view.findViewById(R.id.dialogFragmentSpecie);
        tvVarsta=view.findViewById(R.id.dialogFragmentVarsta);
        tvRasa=view.findViewById(R.id.dialogFragmentRasa);
        tvDataN=view.findViewById(R.id.dialogFragmentDataN);

        btnInchide=view.findViewById(R.id.dialogFragmentInchide);
        btnSalveaza=view.findViewById(R.id.dialogFragmentSalveaza);
        img=view.findViewById(R.id.dialogFragmentImg);
        imgSex=view.findViewById(R.id.dialogFragmentSexImg);

        animal =getArguments().getParcelable(
                AnimaleleMeleActivity.tranferAnimal);
        tvNume.setText(animal.getNumeAnimal());
        tvSpecie.setText(animal.getSpecieAnimal());
        descriereAnimal=animal.getDescriereAnimal();
        tvVarsta.setText(animal.returneazaVarsta());
        tvRasa.setText(animal.getRasaAnimal());
        if(animal.getDescriereAnimal().equals("null"))
            etDespre.setText("");
        else
            etDespre.setText(animal.getDescriereAnimal());

        String dataFormatata=formatareData(animal.getDataNasteriiAnimal().toString());

        tvDataN.setText(dataFormatata);
if(animal.getSexAnimal().equalsIgnoreCase("feminin"))
{
    imgSex.setImageResource(R.drawable.female);
}
else
    imgSex.setImageResource(R.drawable.symbol_male);
        Picasso.get().load(animal.getImagine().trim()).into(img);
        dlg=this;

        btnInchide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
            }
        });
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type="addDesc";
                descriereAnimal= etDespre.getText().toString();
                animal.setDescriereAnimal(descriereAnimal);
                BackgroundTask backgroundTask=new BackgroundTask(AnimaleleMeleActivity.ctx);
                backgroundTask.execute(type,descriereAnimal,animal.getCIP());
                dlg.dismiss();
            }
        });

        return view;
    }

    public static String formatareData(String data){
        String dataFormatata="";
        String zi=data.substring(8,10);
        String luna=data.substring(4,7);
        String an=data.substring(data.length()-4);
        dataFormatata=zi+"-"+luna+"-"+an;
        return  dataFormatata;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
