package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

public class Animal implements Parcelable {

//+pozaAnimal,categorieAnimal
    private String CIP;
    private String imagine;
    private String emailProprietar;
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

    public Animal() {
    }

    public Animal(String CIP, String imagine, String emailProprietar, String numeAnimal, String rasaAnimal, String descriereAnimal, String specieAnimal, String sexAnimal, Date dataNasteriiAnimal, String culoareAnimal, ArrayList<Vaccin> vaccinuriAnimal, ArrayList<Interventie> operatiiAnimal, ArrayList<Deparazitare> deparazitariAnimal) {
        this.CIP = CIP;
        this.imagine = imagine;
        this.emailProprietar = emailProprietar;
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

    public String getCIP() {
        return CIP;
    }

    public void setCIP(String CIP) {
        this.CIP = CIP;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getEmailProprietar() {
        return emailProprietar;
    }

    public void setEmailProprietar(String emailProprietar) {
        this.emailProprietar = emailProprietar;
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

    protected Animal(Parcel in) {
        CIP = in.readString();
        imagine = in.readString();
        emailProprietar = in.readString();
        numeAnimal = in.readString();
        rasaAnimal = in.readString();
        descriereAnimal = in.readString();
        specieAnimal = in.readString();
        sexAnimal = in.readString();
        culoareAnimal = in.readString();
        vaccinuriAnimal = in.createTypedArrayList(Vaccin.CREATOR);
        operatiiAnimal = in.createTypedArrayList(Interventie.CREATOR);
        deparazitariAnimal = in.createTypedArrayList(Deparazitare.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CIP);
        dest.writeString(imagine);
        dest.writeString(emailProprietar);
        dest.writeString(numeAnimal);
        dest.writeString(rasaAnimal);
        dest.writeString(descriereAnimal);
        dest.writeString(specieAnimal);
        dest.writeString(sexAnimal);
        dest.writeString(culoareAnimal);
        dest.writeTypedList(vaccinuriAnimal);
        dest.writeTypedList(operatiiAnimal);
        dest.writeTypedList(deparazitariAnimal);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String returneazaVarstaGen(){
        LocalDate today = LocalDate.now();
        LocalDate dataNastere
                = LocalDate.of(dataNasteriiAnimal.getYear(),
                dataNasteriiAnimal.getMonth(),
                dataNasteriiAnimal.getDay());  //Data nasterii

        Period p=Period.between(dataNastere,today);
        int ani=p.getYears()-1900;
        return getSexAnimal()+" - "+ani+" ani si "+p.getMonths()+" luni ";
    }
    public String returneazaVarsta(){
        LocalDate today = LocalDate.now();
        LocalDate dataNastere
                = LocalDate.of(dataNasteriiAnimal.getYear(),
                dataNasteriiAnimal.getMonth(),
                dataNasteriiAnimal.getDay());  //Data nasterii

        Period p=Period.between(dataNastere,today);
        return p.getYears()-1900+" ani si "+p.getMonths()+" luni ";
    }
    public void adaugaVaccin(Vaccin vaccin)
    {
        vaccinuriAnimal.add(vaccin);
    }
    public void adaugaInterventie(Interventie interventie)
    {
        operatiiAnimal.add(interventie);
    }
    public void adaugaDeparazitare(Deparazitare deparazitare)
    {
        deparazitariAnimal.add(deparazitare);
    }
}
