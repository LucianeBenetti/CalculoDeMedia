package com.example.calculodemedia.model;

public class BoletimBO {

    Boletim boletim;

    public BoletimBO(Boletim boletim) {

        this.boletim = boletim;
    }
    public boolean validaDisciplina(){
        DisciplinaBO disciplinaBO1 = new DisciplinaBO(boletim.getDisciplina1());
        DisciplinaBO disciplinaBO2 = new DisciplinaBO(boletim.getDisciplina2());
        if(disciplinaBO1.validaNomeDiciplina() && disciplinaBO1.validaNota1() && disciplinaBO1.validaNota2()
                && disciplinaBO2.validaNomeDiciplina() && disciplinaBO2.validaNota1() && disciplinaBO2.validaNota2()){
            return true;
        } else {
            return false;
        }
    }
}

