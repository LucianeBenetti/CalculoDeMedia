package com.example.calculodemedia.model;

import java.io.Serializable;

public class Boletim implements Serializable {

    private Disciplina disciplina1;
    private Disciplina disciplina2;

    public Boletim(Disciplina disciplina1, Disciplina disciplina2) {
        this.disciplina1 = disciplina1;
        this.disciplina2 = disciplina2;
    }

    public Boletim() {
        this.disciplina1 = new Disciplina();
        this.disciplina2 = new Disciplina();
    }

    public Disciplina getDisciplina1() {
        return disciplina1;
    }

    public void setDisciplina1(Disciplina disciplina1) {
        this.disciplina1 = disciplina1;
    }

    public Disciplina getDisciplina2() {
        return disciplina2;
    }

    public void setDisciplina2(Disciplina disciplina2) {
        this.disciplina2 = disciplina2;
    }

    @Override
    public String toString() {
        return "Boletim{" +
                "disciplina1=" + disciplina1 +
                ", disciplina2=" + disciplina2 +
                '}';
    }
}
