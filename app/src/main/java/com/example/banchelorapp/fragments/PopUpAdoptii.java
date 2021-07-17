package com.example.banchelorapp.fragments;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.DialogFragment;

        import com.example.banchelorapp.CentruAdoptiiActivity;
        import com.example.banchelorapp.InfoAdoptie;
        import com.example.banchelorapp.R;
        import com.example.banchelorapp.utils.AnimaleAdoptie;
        import com.squareup.picasso.Picasso;

public class PopUpAdoptii extends DialogFragment {

    public static final int REQUEST_CODE = 101;
    TextView tvNume, tvSpecie, tvRasa,etDespre, centruAdoptie, tvVarsta;
    Button btnInchide;
    Button btnAdopta;
    PopUpAdoptii dlg;
    ImageView img;
    ImageView imgSex;
    AnimaleAdoptie animal;
    String descriereAnimal;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.animal_adoptie_popup,container,false);
        etDespre =view.findViewById(R.id.etNotite);
        tvNume=view.findViewById(R.id.dialogFragmentNume);
        tvSpecie=view.findViewById(R.id.dialogFragmentSpecie);
        tvRasa=view.findViewById(R.id.dialogFragmentRasa);
        centruAdoptie =view.findViewById(R.id.dialogFragmentCentruAdoptie);
        tvVarsta=view.findViewById(R.id.dialogFragmentVarsta);

        btnInchide=view.findViewById(R.id.dialogFragmentInchide);
        btnAdopta=view.findViewById(R.id.btnDialogFragmentAdopta);
        img=view.findViewById(R.id.dialogFragmentImg);
        imgSex=view.findViewById(R.id.dialogFragmentSexImg);

        animal =getArguments().getParcelable(
                CentruAdoptiiActivity.animalAdoptie);
        tvNume.setText(animal.getNumeAnimal());
        tvSpecie.setText(animal.getSpecieAnimal());
        descriereAnimal=animal.getDescriereAnimal();
        tvRasa.setText(animal.getRasaAnimal());
        tvVarsta.setText(animal.returneazaVarsta());

        centruAdoptie.setText(animal.getCentruAdoptie());
        if(animal.getDescriereAnimal().equals("null"))
            etDespre.setText("");
        else
            etDespre.setText(animal.getDescriereAnimal());
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
        btnAdopta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(view.getContext(), InfoAdoptie.class);
                startActivityForResult(intent, REQUEST_CODE);
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
