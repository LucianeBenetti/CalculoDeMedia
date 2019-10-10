package com.example.calculodemedia.controller;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculodemedia.R;
import com.example.calculodemedia.Util.Constantes;
import com.example.calculodemedia.model.Disciplina;
import com.example.calculodemedia.model.DisciplinaBO;
import com.example.calculodemedia.view.ResultadoActivity;

import java.io.Serializable;

public class DisciplinaControl {
    private Activity activity;
    private EditText editNome;
    private EditText editNota1;
    private EditText editNota2;
    private TextView textViewTitulo;

    public DisciplinaControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }
    public void initComponents(){
        editNome = activity.findViewById(R.id.editNomeDisciplina);
        editNota1 = activity.findViewById(R.id.editNota1);
        editNota2 = activity.findViewById(R.id.editNota2);
        textViewTitulo = activity.findViewById(R.id.avalicao);
       carregarForm();
       carregarTitulo();

}
    private void carregarTitulo() {
        String titulo = activity.getIntent().getStringExtra("disciplina");
        textViewTitulo.setText(titulo);
    }

    public void carregarForm(){
        Disciplina disciplina = (Disciplina) activity.getIntent().getSerializableExtra(Constantes.Parametros.DISCIPLINA1);
        editNome.setText(disciplina.getNomeDisciplina());
        if(disciplina.getNota1()!=null && disciplina.getNota2() !=null) {
            editNota1.setText(String.valueOf(disciplina.getNota1()));
            editNota2.setText(String.valueOf(disciplina.getNota2()));
        }
    }

    private boolean valida(DisciplinaBO disciplinaBO) {
        if (!disciplinaBO.validaNota1()) {

            Toast.makeText(activity, R.string.erro_nota_obrigatoria, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!disciplinaBO.validaNota2()) {
            Toast.makeText(activity, R.string.erro_nota_obrigatoria, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!disciplinaBO.validaNomeDiciplina()) {
            editNome.setError("Preencha corretamente o nome");
            return false;
        }
        return true;
    }

    private Disciplina getDadosFormDisciplina(){
        Disciplina disciplina = new Disciplina();
        disciplina.setNomeDisciplina(editNome.getText().toString());
        disciplina.setNota1(editNota1.getText().toString());
        disciplina.setNota2(editNota2.getText().toString());
        return disciplina;
    }


    public void enviarAction(){

        Disciplina disciplina = getDadosFormDisciplina();
        DisciplinaBO disciplinaBO = new DisciplinaBO(disciplina);

      if(valida(disciplinaBO) ){
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.DISCIPLINA1, disciplina);
            it.putExtra(Constantes.Parametros.DISCIPLINA2, disciplina);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}