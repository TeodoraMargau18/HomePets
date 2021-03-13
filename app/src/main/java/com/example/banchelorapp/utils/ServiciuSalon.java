package com.example.banchelorapp.utils;

public class ServiciuSalon {
    private String denumireServiciu;
    private float tarifServiciu;

    public ServiciuSalon(String denumireServiciu, float tarifServiciu) {
        this.denumireServiciu = denumireServiciu;
        this.tarifServiciu = tarifServiciu;
    }

    public String getDenumireServiciu() {
        return denumireServiciu;
    }

    public void setDenumireServiciu(String denumireServiciu) {
        this.denumireServiciu = denumireServiciu;
    }

    public float getTarifServiciu() {
        return tarifServiciu;
    }

    public void setTarifServiciu(float tarifServiciu) {
        this.tarifServiciu = tarifServiciu;
    }
}
