package com.example.calculodemedia.model;

import com.example.calculodemedia.Util.Constantes;

public class DisciplinaBO{
        private Disciplina disciplina;
        private Double mediaDisciplina;

        public DisciplinaBO(Disciplina disciplina) {
            this.disciplina = disciplina;
        }

        public Double getMedia(){
            Double nota1 = disciplina.getNota1();
            Double nota2 = disciplina.getNota2();
            mediaDisciplina = (nota1 + nota2)/2;
            return mediaDisciplina;
        }

        public boolean validaNota1(){
            return this.disciplina.getNota1()!=null
                    && this.disciplina.getNota1()>=0
                    && this.disciplina.getNota1()<=10;
        }
        public boolean validaNota2(){
            return this.disciplina.getNota2()!=null
                    && this.disciplina.getNota2()>=0
                    && this.disciplina.getNota2()<=10;
        }

        public boolean validaNomeDiciplina(){
            return this.disciplina.getNomeDisciplina() != null
                    && !this.disciplina.getNomeDisciplina().isEmpty();
        }


}