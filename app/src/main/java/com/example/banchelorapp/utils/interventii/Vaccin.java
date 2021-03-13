package com.example.banchelorapp.utils.interventii;

import java.util.Date;

public class Vaccin {
    private String tip;
    private Date dataVaccin;
    private String medic;

    public Vaccin(String tip, Date dataVaccin, String medic) {
        this.tip = tip;
        this.dataVaccin = dataVaccin;
        this.medic = medic;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getDataVaccin() {
        return dataVaccin;
    }

    public void setDataVaccin(Date dataVaccin) {
        this.dataVaccin = dataVaccin;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    @Override
    public String toString() {
        return "Vaccin{" +
                "tip='" + tip + '\'' +
                ", dataVaccin=" + dataVaccin +
                ", medic='" + medic + '\'' +
                '}';
    }
}
