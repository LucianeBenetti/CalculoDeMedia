package com.example.calculodemedia.controller;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.calculodemedia.R;
import com.example.calculodemedia.Util.Constantes;
import com.example.calculodemedia.model.Boletim;
import com.example.calculodemedia.model.BoletimBO;
import com.example.calculodemedia.model.Disciplina;
import com.example.calculodemedia.model.DisciplinaBO;

public class ResultadoControl {
    private Activity activity;
    private TextView tvDisciplina1;
    private TextView tvMedia1;
    private TextView tvDisciplina2;
    private TextView tvMedia2;
    private TextView tvNota1D1;
    private TextView tvNota2D1;
    private TextView tvNota1D2;
    private TextView tvNota2D2;

    public ResultadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        showResultado();
    }

    private void initComponents() {

        tvDisciplina1 = activity.findViewById(R.id.tvDisciplina1);
        tvMedia1 = activity.findViewById(R.id.tvMediaD1);
        tvDisciplina2 = activity.findViewById(R.id.tvDisciplina2);
        tvMedia2 = activity.findViewById(R.id.tvMediaD2);
        tvNota1D1 = activity.findViewById(R.id.tvNota1D1);
        tvNota1D2 = activity.findViewById(R.id.tvNota1D2);
        tvNota2D1 = activity.findViewById(R.id.tvNota2D1);
        tvNota2D2 = activity.findViewById(R.id.tvNota2D2);
    }

    private void showResultado(){

        Boletim boletim = (Boletim) activity.getIntent().getSerializableExtra(Constantes.Parametros.BOLETIM);
        tvDisciplina1.setText("Disciplina1: " + boletim.getDisciplina1().getNomeDisciplina());
        tvNota1D1.setText("Nota1: " + boletim.getDisciplina1().getNota1().toString());
        tvNota2D1.setText("Nota2: " + boletim.getDisciplina1().getNota2().toString());
        DisciplinaBO disciplina1BO = new DisciplinaBO(boletim.getDisciplina1());
        tvMedia1.setText("Media: " + disciplina1BO.getMedia());

        tvDisciplina2.setText("Disciplina2: " + boletim.getDisciplina2().getNomeDisciplina());
        tvNota1D2.setText("Nota1: " + boletim.getDisciplina2().getNota1().toString());
        tvNota2D2.setText("Nota2: " + boletim.getDisciplina2().getNota2().toString());
        DisciplinaBO disciplina2BO = new DisciplinaBO(boletim.getDisciplina2());
        tvMedia2.setText("Media: " + disciplina2BO.getMedia());
    }


    public void voltarAction(){
        activity.finish();
    }
}


