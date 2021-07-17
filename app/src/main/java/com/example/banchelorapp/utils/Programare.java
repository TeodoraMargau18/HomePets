package com.example.banchelorapp.utils;

public class Programare {
    private String dataProgramare;
    private String oraProgramare;
    private String numeAnimalprogramat;
    private String serviciu;
    private String numeSalon;

    public Programare(String dataProgramare, String oraProgramare, String numeAnimalprogramat, String serviciu,String numeSalon) {
        this.dataProgramare = dataProgramare;
        this.oraProgramare = oraProgramare;
        this.numeAnimalprogramat = numeAnimalprogramat;
        this.serviciu = serviciu;
        this.numeSalon = numeSalon;
    }

    public String getDataProgramare() {
        return dataProgramare;
    }

    public void setDataProgramare(String dataProgramare) {
        this.dataProgramare = dataProgramare;
    }

    public String getOraProgramare() {
        return oraProgramare;
    }

    public void setOraProgramare(String oraProgramare) {
        this.oraProgramare = oraProgramare;
    }

    public String getNumeAnimalprogramat() {
        return numeAnimalprogramat;
    }

    public void setNumeAnimalprogramat(String numeAnimalprogramat) {
        this.numeAnimalprogramat = numeAnimalprogramat;
    }

    public String getServiciu() {
        return serviciu;
    }

    public void setServiciu(String serviciu) {
        this.serviciu = serviciu;
    }

    public String getNumeSalon() {
        return numeSalon;
    }

    public void setNumeSalon(String numeSalon) {
        this.numeSalon = numeSalon;
    }
}
