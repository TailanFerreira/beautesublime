package com.example.trabalhofinaltailan;


public class Produtos {
    private String id;
    private String nome;
    private String disponivel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }



    @Override
    public String toString() {
        return "id: " + getId()
                + "\nNome: " + getNome()
                + "\nDisponivel: " + getDisponivel();
    }
}