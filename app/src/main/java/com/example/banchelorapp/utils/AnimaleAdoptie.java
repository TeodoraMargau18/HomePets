package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class AnimaleAdoptie implements Parcelable {
    private String imagine;
    private String ID;
    private String numeAnimal;
    private String rasaAnimal;
    private String descriereAnimal;
    private String specieAnimal;
    private String sexAnimal;//feminin/masculin
    private Date dataNasteriiAnimal;
    private String culoareAnimal;
    private ArrayList<Vaccin> vaccinuriAnimal;
    private ArrayList<Interventie> operatiiAnimal;
    private ArrayList<Deparazitare> deparazitariAnimal;


    public AnimaleAdoptie(String ID,String imagine, String numeAnimal,
                          String rasaAnimal, String descriereAnimal, String specieAnimal,
                          String sexAnimal, Date dataNasteriiAnimal, String culoareAnimal,
                          ArrayList<Vaccin> vaccinuriAnimal, ArrayList<Interventie> operatiiAnimal,
                          ArrayList<Deparazitare> deparazitariAnimal) {
        this.imagine = imagine;
        this.ID = ID;
        this.numeAnimal = numeAnimal;
        this.rasaAnimal = rasaAnimal;
        this.descriereAnimal = descriereAnimal;
        this.specieAnimal = specieAnimal;
        this.sexAnimal = sexAnimal;
        this.dataNasteriiAnimal = dataNasteriiAnimal;
        this.culoareAnimal = culoareAnimal;
        this.vaccinuriAnimal = vaccinuriAnimal;
        this.operatiiAnimal = operatiiAnimal;
        this.deparazitariAnimal = deparazitariAnimal;
    }

    protected AnimaleAdoptie(Parcel in) {
        imagine = in.readString();
        ID = in.readString();
        numeAnimal = in.readString();
        rasaAnimal = in.readString();
        descriereAnimal = in.readString();
        specieAnimal = in.readString();
        sexAnimal = in.readString();
        culoareAnimal = in.readString();
        vaccinuriAnimal = in.createTypedArrayList(Vaccin.CREATOR);
        operatiiAnimal = in.createTypedArrayList(Interventie.CREATOR);
        deparazitariAnimal = in.createTypedArrayList(Deparazitare.CREATOR);
        dataNasteriiAnimal = (java.util.Date)in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagine);
        dest.writeString(ID);
        dest.writeString(numeAnimal);
        dest.writeString(rasaAnimal);
        dest.writeString(descriereAnimal);
        dest.writeString(specieAnimal);
        dest.writeString(sexAnimal);
        dest.writeString(culoareAnimal);
        dest.writeTypedList(vaccinuriAnimal);
        dest.writeTypedList(operatiiAnimal);
        dest.writeTypedList(deparazitariAnimal);
        dest.writeSerializable(dataNasteriiAnimal);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AnimaleAdoptie> CREATOR = new Creator<AnimaleAdoptie>() {
        @Override
        public AnimaleAdoptie createFromParcel(Parcel in) {
            return new AnimaleAdoptie(in);
        }

        @Override
        public AnimaleAdoptie[] newArray(int size) {
            return new AnimaleAdoptie[size];
        }
    };

    public String getImagine() {
        return imagine;
    }

    public String getNumeAnimal() {
        return numeAnimal;
    }

    public String getRasaAnimal() {
        return rasaAnimal;
    }

    public String getDescriereAnimal() {
        return descriereAnimal;
    }

    public String getSpecieAnimal() {
        return specieAnimal;
    }

    public String getSexAnimal() {
        return sexAnimal;
    }

    public Date getDataNasteriiAnimal() {
        return dataNasteriiAnimal;
    }


    public String getID() {
        return ID;
    }

    public String returneazaVarsta(){
        LocalDate today = LocalDate.now();
        LocalDate dataNastere
                = dataNasteriiAnimal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();  //Data nasterii

        Period p=Period.between(dataNastere,today);
        return p.getYears()+" ani si "+p.getMonths()+" luni ";
    }

    @Override
    public String toString() {
        return "AnimaleAdoptie{" +
                "imagine='" + imagine + '\'' +
                ", ID='" + ID + '\'' +
                ", numeAnimal='" + numeAnimal + '\'' +
                ", rasaAnimal='" + rasaAnimal + '\'' +
                ", descriereAnimal='" + descriereAnimal + '\'' +
                ", specieAnimal='" + specieAnimal + '\'' +
                ", sexAnimal='" + sexAnimal + '\'' +
                ", dataNasteriiAnimal=" + dataNasteriiAnimal +
                ", culoareAnimal='" + culoareAnimal + '\'' +
                ", vaccinuriAnimal=" + vaccinuriAnimal +
                ", operatiiAnimal=" + operatiiAnimal +
                ", deparazitariAnimal=" + deparazitariAnimal +
                '}';
    }
}
