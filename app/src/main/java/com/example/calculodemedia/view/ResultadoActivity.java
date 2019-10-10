package com.example.calculodemedia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calculodemedia.R;
import com.example.calculodemedia.controller.ResultadoControl;

public class ResultadoActivity extends AppCompatActivity {
    private ResultadoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        control = new ResultadoControl(this);
    }

    public void voltar(View v){
        control.voltarAction();
    }
}
