package com.example.calculodemedia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.calculodemedia.R;
import com.example.calculodemedia.controller.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void telaAvaliacao1(View v){
        control.telaAvaliacao1Action();
    }

    public void telaAvaliacao2(View v){
        control.telaAvaliacao2Action();
    }

    public void telaResultado(View v){
        control.telaResultadoAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
