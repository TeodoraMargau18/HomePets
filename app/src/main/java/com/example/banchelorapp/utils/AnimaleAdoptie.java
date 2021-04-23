package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

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
        dest.writeString(ID);
        dest.writeString(imagine);
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

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getNumeAnimal() {
        return numeAnimal;
    }

    public void setNumeAnimal(String numeAnimal) {
        this.numeAnimal = numeAnimal;
    }

    public String getRasaAnimal() {
        return rasaAnimal;
    }

    public void setRasaAnimal(String rasaAnimal) {
        this.rasaAnimal = rasaAnimal;
    }

    public String getDescriereAnimal() {
        return descriereAnimal;
    }

    public void setDescriereAnimal(String descriereAnimal) {
        this.descriereAnimal = descriereAnimal;
    }

    public String getSpecieAnimal() {
        return specieAnimal;
    }

    public void setSpecieAnimal(String specieAnimal) {
        this.specieAnimal = specieAnimal;
    }

    public String getSexAnimal() {
        return sexAnimal;
    }

    public void setSexAnimal(String sexAnimal) {
        this.sexAnimal = sexAnimal;
    }

    public Date getDataNasteriiAnimal() {
        return dataNasteriiAnimal;
    }

    public void setDataNasteriiAnimal(Date dataNasteriiAnimal) {
        this.dataNasteriiAnimal = dataNasteriiAnimal;
    }

    public String getCuloareAnimal() {
        return culoareAnimal;
    }

    public void setCuloareAnimal(String culoareAnimal) {
        this.culoareAnimal = culoareAnimal;
    }

    public ArrayList<Vaccin> getVaccinuriAnimal() {
        return vaccinuriAnimal;
    }

    public void setVaccinuriAnimal(ArrayList<Vaccin> vaccinuriAnimal) {
        this.vaccinuriAnimal = vaccinuriAnimal;
    }

    public ArrayList<Interventie> getOperatiiAnimal() {
        return operatiiAnimal;
    }

    public void setOperatiiAnimal(ArrayList<Interventie> operatiiAnimal) {
        this.operatiiAnimal = operatiiAnimal;
    }

    public ArrayList<Deparazitare> getDeparazitariAnimal() {
        return deparazitariAnimal;
    }

    public void setDeparazitariAnimal(ArrayList<Deparazitare> deparazitariAnimal) {
        this.deparazitariAnimal = deparazitariAnimal;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
