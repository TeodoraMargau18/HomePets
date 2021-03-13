package com.example.banchelorapp.utils;

import java.util.ArrayList;

public class Salon {
    private String despre;
    private ArrayList<ServiciuSalon> servicii;//Fac clasa ServiciuSalon cu denumireServiciu si tarifServiciu
    private String telefon;
    private String site;
    private String locatie;
    private ArrayList<String> program;//O sa am fie l-v 08:00-17:00 , sambata 09:12 fie tot orarul intr-un String

    public Salon(String despre, ArrayList<ServiciuSalon> servicii, String telefon, String site, String locatie, ArrayList<String> program) {
        this.despre = despre;
        this.servicii = servicii;
        this.telefon = telefon;
        this.site = site;
        this.locatie = locatie;
        this.program = program;
    }

    public String getDespre() {
        return despre;
    }

    public void setDespre(String despre) {
        this.despre = despre;
    }

    public ArrayList<ServiciuSalon> getServicii() {
        return servicii;
    }

    public void setServicii(ArrayList<ServiciuSalon> servicii) {
        this.servicii = servicii;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public ArrayList<String> getProgram() {
        return program;
    }

    public void setProgram(ArrayList<String> program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "despre='" + despre + '\'' +
                ", servicii=" + servicii +
                ", telefon='" + telefon + '\'' +
                ", site='" + site + '\'' +
                ", locatie='" + locatie + '\'' +
                ", program=" + program +
                '}';
    }
}