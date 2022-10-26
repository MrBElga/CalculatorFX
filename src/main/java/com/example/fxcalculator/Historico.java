package com.example.fxcalculator;

public class Historico {
    private String equacao;
    private String horario;

    public Historico(String equacao, String horario) {
        this.equacao = equacao;
        this.horario = horario;
    }

    public String getEquacao() {
        return equacao;
    }

    public void setEquacao(String equacao) {
        this.equacao = equacao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
