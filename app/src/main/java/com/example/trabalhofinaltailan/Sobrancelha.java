package com.example.trabalhofinaltailan;

public class Sobrancelha {
    private int id;
    private int cod_cliente;
    private String espaço_sobrancelha;
    private String espessura;
    private String altura_inicial;
    private String altura_final;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getEspaço_sobrancelha() {
        return espaço_sobrancelha;
    }

    public void setEspaço_sobrancelha(String espaço_sobrancelha) {
        this.espaço_sobrancelha = espaço_sobrancelha;
    }

    public String getEspessura() {
        return espessura;
    }

    public void setEspessura(String espessura) {
        this.espessura = espessura;
    }

    public String getAltura_inicial() {
        return altura_inicial;
    }

    public void setAltura_inicial(String altura_inicial) {
        this.altura_inicial = altura_inicial;
    }

    public String getAltura_final() {
        return altura_final;
    }

    public void setAltura_final(String altura_final) {
        this.altura_final = altura_final;
    }

    @Override
    public String toString() {
        return "Sobrancelha{" +
                "id=" + id +
                ", cod_cliente=" + cod_cliente +
                ", espaço_sobrancelha='" + espaço_sobrancelha + '\'' +
                ", espessura='" + espessura + '\'' +
                ", altura_inicial='" + altura_inicial + '\'' +
                ", altura_final='" + altura_final + '\'' +
                '}';
    }
}
