package com.example.banchelorapp.utils;

import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Operatie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Animal {
//emailProp, Nume, Rasa, sex,dataN,culoare,vaccine(lista),operatii(lista),Ddeparazitari(lista)
    private String emailProprietar;
    private String numeAnimal;
    private String rasaAnimal;
    private String sexAnimal;//feminin/masculin
    private Date dataNasteriiAnimal;
    private String culoareAnimal;
    private List<Vaccin> vaccineAnimal;
    private List<Operatie> operatiiAnimal;
    private List<Deparazitare> deparazitariAnimal;

    public Animal(String emailProprietar,
                  String numeAnimal, String rasaAnimal,
                  String sexAnimal, Date dataNasteriiAnimal, String culoareAnimal,
                  List<Vaccin> vaccineAnimal, List<Operatie> operatiiAnimal,
                  List<Deparazitare> deparazitariAnimal) {
        this.emailProprietar = emailProprietar;
        this.numeAnimal = numeAnimal;
        this.rasaAnimal = rasaAnimal;
        this.sexAnimal = sexAnimal;
        this.dataNasteriiAnimal = dataNasteriiAnimal;
        this.culoareAnimal = culoareAnimal;
        this.vaccineAnimal = vaccineAnimal;
        this.operatiiAnimal = operatiiAnimal;
        this.deparazitariAnimal = deparazitariAnimal;
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

    public List<Vaccin> getVaccineAnimal() {
        return vaccineAnimal;
    }

    public void setVaccineAnimal(List<Vaccin> vaccineAnimal) {
        this.vaccineAnimal = vaccineAnimal;
    }

    public List<Operatie> getOperatiiAnimal() {
        return operatiiAnimal;
    }

    public void setOperatiiAnimal(List<Operatie> operatiiAnimal) {
        this.operatiiAnimal = operatiiAnimal;
    }

    public List<Deparazitare> getDeparazitariAnimal() {
        return deparazitariAnimal;
    }

    public void setDeparazitariAnimal(List<Deparazitare> deparazitariAnimal) {
        this.deparazitariAnimal = deparazitariAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "emailProprietar='" + emailProprietar + '\'' +
                ", numeAnimal='" + numeAnimal + '\'' +
                ", rasaAnimal='" + rasaAnimal + '\'' +
                ", sexAnimal='" + sexAnimal + '\'' +
                ", dataNasteriiAnimal=" + dataNasteriiAnimal +
                ", culoareAnimal='" + culoareAnimal + '\'' +
                ", vaccineAnimal=" + vaccineAnimal +
                ", operatiiAnimal=" + operatiiAnimal +
                ", deparazitariAnimal=" + deparazitariAnimal +
                '}';
    }
}
