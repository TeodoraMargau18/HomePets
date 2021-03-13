package com.example.banchelorapp.utils.interventii;

import java.util.Date;

public class Operatie {
    private String tipOperatie;
    private Date dataOperatie;
    private String medic;

    public Operatie(String tipOperatie, Date dataOperatie, String medic) {
        this.tipOperatie = tipOperatie;
        this.dataOperatie = dataOperatie;
        this.medic = medic;
    }

    @Override
    public String toString() {
        return "Operatie{" +
                "tipOperatie='" + tipOperatie + '\'' +
                ", dataOperatie=" + dataOperatie +
                ", medic='" + medic + '\'' +
                '}';
    }
}
