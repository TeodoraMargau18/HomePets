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

public class Animal implements Parcelable {

//+categorieAnimal
    private String CIP;
    private String semneParticulare;
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

    public Animal(String CIP,String semneParticulare, String imagine,
                  String emailProprietar, String numeAnimal, String rasaAnimal, String descriereAnimal,
                  String specieAnimal, String sexAnimal, Date dataNasteriiAnimal, String culoareAnimal,
                  ArrayList<Vaccin> vaccinuriAnimal, ArrayList<Interventie> operatiiAnimal,
                  ArrayList<Deparazitare> deparazitariAnimal) {
        this.CIP = CIP;
        this.semneParticulare = semneParticulare;
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

    protected Animal(Parcel in) {
        CIP = in.readString();
        semneParticulare = in.readString();
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
        dataNasteriiAnimal = (java.util.Date)in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CIP);
        dest.writeString(semneParticulare);
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
        dest.writeSerializable(dataNasteriiAnimal);
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

    public String getSemneParticulare() {
        return semneParticulare;
    }

    public String getCIP() {
        return CIP;
    }

    public String getImagine() {
        return imagine;
    }


    public String getEmailProprietar() {
        return emailProprietar;
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

    public void setDescriereAnimal(String descriereAnimal) {
        this.descriereAnimal = descriereAnimal;
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


    public String getCuloareAnimal() {
        return culoareAnimal;
    }

    public ArrayList<Vaccin> getVaccinuriAnimal() {
        return vaccinuriAnimal;
    }



    public ArrayList<Interventie> getOperatiiAnimal() {
        return operatiiAnimal;
    }


    public ArrayList<Deparazitare> getDeparazitariAnimal() {
        return deparazitariAnimal;
    }



    public String returneazaVarstaGen(){
        LocalDate today = LocalDate.now();
        LocalDate dataNastere
                = dataNasteriiAnimal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();  //Data nasterii

        Period p=Period.between(dataNastere,today);
        return getSexAnimal()+" - "+p.getYears()+" ani si "+p.getMonths()+" luni ";
    }
    public String returneazaVarsta(){
        LocalDate today = LocalDate.now();
        LocalDate dataNastere
                = dataNasteriiAnimal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();  //Data nasterii

        Period p=Period.between(dataNastere,today);
        return p.getYears()+" ani si "+p.getMonths()+" luni ";
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

    @Override
    public String toString() {
       String s= "Animal{" +
                "CIP='" + CIP + '\'' +
                ", imagine='" + imagine + '\'' +
                ", emailProprietar='" + emailProprietar + '\'' +
                ", numeAnimal='" + numeAnimal + '\'' +
                ", rasaAnimal='" + rasaAnimal + '\'' +
                ", descriereAnimal='" + descriereAnimal + '\'' +
                ", specieAnimal='" + specieAnimal + '\'' +
                ", sexAnimal='" + sexAnimal + '\'' +
                ", dataNasteriiAnimal=" + dataNasteriiAnimal +
                ", culoareAnimal='" + culoareAnimal + '\'' ;
       s+="Vaccinuri ->";
       for(int i=0;i<vaccinuriAnimal.size();i++){
           s+=vaccinuriAnimal.get(i).toString();
       }s+="Operatii ->";
        for(int i=0;i<operatiiAnimal.size();i++){
            s+=operatiiAnimal.get(i).toString();
        }s+="Deparazitari ->";
        for(int i=0;i<deparazitariAnimal.size();i++){
            s+=deparazitariAnimal.get(i).toString();
        }
       return  s;
    }
}
