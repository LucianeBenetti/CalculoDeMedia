package com.example.calculodemedia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calculodemedia.R;
import com.example.calculodemedia.controller.DisciplinaControl;

public class DisciplinaActivity extends AppCompatActivity {
    private DisciplinaControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);
        control = new DisciplinaControl(this);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v){
        control.cancelarAction();
    }
}