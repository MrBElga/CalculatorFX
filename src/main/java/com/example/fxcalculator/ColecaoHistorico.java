package com.example.fxcalculator;

import java.util.ArrayList;

public class ColecaoHistorico {
    private ArrayList<Historico> lista;

    public ColecaoHistorico() {
        lista=new ArrayList<>();
    }
    public void addHistorico(Historico historico)
    {
        lista.add(historico);
    }

    public ArrayList<Historico> getLista() {
        return lista;
    }
}
