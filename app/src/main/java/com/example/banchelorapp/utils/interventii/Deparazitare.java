package com.example.banchelorapp.utils.interventii;

import java.util.Date;

public class Deparazitare {
    private Date dataDeparazitare;
    private String tipDeparazitare;
    private String produsDeparazitare;

    public Deparazitare(Date dataDeparazitare, String tipDeparazitare, String produsDeparazitare) {
        this.dataDeparazitare = dataDeparazitare;
        this.tipDeparazitare = tipDeparazitare;
        this.produsDeparazitare = produsDeparazitare;
    }

    @Override
    public String toString() {
        return "Deparazitare{" +
                "dataDeparazitare=" + dataDeparazitare +
                ", tipDeparazitare='" + tipDeparazitare + '\'' +
                ", produsDeparazitare='" + produsDeparazitare + '\'' +
                '}';
    }
}
