package com.example.trabalhofinaltailan;

public class Cilios {
    private int id;
    private String tipo_cilios;
    private String tecnica;
    private String espessura;
    private String curvatura;
    private String cola;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getTipo_cilios() {
        return tipo_cilios;
    }

    public void setTipo_cilios(String tipo_cilios) {
        this.tipo_cilios = tipo_cilios;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getEspessura() {
        return espessura;
    }

    public void setEspessura(String espessura) {
        this.espessura = espessura;
    }

    public String getCurvatura() {
        return curvatura;
    }

    public void setCurvatura(String curvatura) {
        this.curvatura = curvatura;
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    @Override
    public String toString() {
        return "Cilios{" +
                "id=" + id +
                ", tipo_cilios='" + tipo_cilios + '\'' +
                ", tecnica='" + tecnica + '\'' +
                ", espessura='" + espessura + '\'' +
                ", curvatura='" + curvatura + '\'' +
                ", cola='" + cola + '\'' +
                '}';
    }
}
