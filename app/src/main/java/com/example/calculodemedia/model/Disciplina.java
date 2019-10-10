package com.example.calculodemedia.model;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private String nomeDisciplina;
    private Double nota1;
    private Double nota2;

    public Disciplina() {
    }

    public Disciplina(String nomeDisciplina, Double nota1, Double nota2) {
        this.nomeDisciplina = nomeDisciplina;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public void setNota1(String nota1){
        try{
            this.nota1 = Double.parseDouble(nota1);
        } catch (Exception e){
            this.nota1 = null;
        }
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public void setNota2(String nota2){
        try{
            this.nota2 = Double.parseDouble(nota2);
        } catch (Exception e){
            this.nota2 = null;
        }
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "disciplina='" + nomeDisciplina + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2;
    }
}