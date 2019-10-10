package com.example.calculodemedia.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculodemedia.R;
import com.example.calculodemedia.Util.Constantes;
import com.example.calculodemedia.model.Boletim;
import com.example.calculodemedia.model.BoletimBO;
import com.example.calculodemedia.model.Disciplina;
import com.example.calculodemedia.model.DisciplinaBO;
import com.example.calculodemedia.view.DisciplinaActivity;
import com.example.calculodemedia.view.MainActivity;
import com.example.calculodemedia.view.ResultadoActivity;

import java.io.Serializable;

public class MainControl {

    private Activity activity;
    private Disciplina disciplina;
    private Boletim boletim;
    private Button btnEnviar;

    public MainControl(Activity activity) {
        this.activity = activity;
        disciplina = new Disciplina();
        boletim = new Boletim();

        btnEnviar = activity.findViewById(R.id.btnEnviar);
    }

    public void telaAvaliacao1Action() {
        Intent it = new Intent(activity, DisciplinaActivity.class);
        it.putExtra(Constantes.Parametros.DISCIPLINA1, boletim.getDisciplina1());
        it.putExtra("disciplina", "AVALIAÇÃO 1");
        activity.startActivityForResult(it, Constantes.Request.DISCIPLINA1);
    }

    public void telaAvaliacao2Action() {
        Intent it = new Intent(activity, DisciplinaActivity.class);
        it.putExtra(Constantes.Parametros.DISCIPLINA1, boletim.getDisciplina2());
        it.putExtra("disciplina", "AVALIAÇÃO 2");
        activity.startActivityForResult(it, Constantes.Request.DISCIPLINA2);
    }

    public void telaResultadoAction() {
        Intent it = new Intent(activity, ResultadoActivity.class);
        it.putExtra(Constantes.Parametros.BOLETIM, boletim);
        activity.startActivity(it);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == activity.RESULT_OK) {
            if (requestCode == Constantes.Request.DISCIPLINA1) {
                disciplina = (Disciplina) data.getSerializableExtra(Constantes.Parametros.DISCIPLINA1);
                boletim.setDisciplina1(disciplina);
            } else if (requestCode == Constantes.Request.DISCIPLINA2) {
                disciplina = (Disciplina) data.getSerializableExtra(Constantes.Parametros.DISCIPLINA1);
                boletim.setDisciplina2(disciplina);
            } else if (resultCode == activity.RESULT_CANCELED) {
                Toast.makeText(activity, "Ação cancelada", Toast.LENGTH_SHORT).show();
            }

            BoletimBO boletimBO = new BoletimBO(boletim);
            if(boletimBO.validaDisciplina()){
                btnEnviar.setEnabled(true);
            } else {
                btnEnviar.setEnabled(false);
            }

        }
    }
}