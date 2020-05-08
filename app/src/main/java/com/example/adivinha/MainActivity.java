package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnAvancar;
    private Button btnDesistir;
    private EditText ra;
    private EditText nomeCompleto;
    private EditText turma;
    private TextView preenchaCampo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btnAvancar = (Button) findViewById(R.id.idBtnAvancar);
       btnDesistir = (Button) findViewById(R.id.idBtnDesistir);
       nomeCompleto = (EditText) findViewById(R.id.idNomeCompleto);
       turma = (EditText) findViewById(R.id.idTurma);
       ra = (EditText) findViewById(R.id.idRa);
       preenchaCampo = (TextView) findViewById(R.id.idPreechaCampo);

       btnAvancar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String valorRa = ra.getText().toString();
               String valorNomeCompleto = nomeCompleto.getText().toString();
               String valorTurma = turma.getText().toString();
               if(valorRa != null && !valorRa.equals("") &&  valorNomeCompleto != null && !valorNomeCompleto.equals("") && valorTurma != null && !valorTurma.equals("")){
                   onAvancar();
               }else{
                   preenchaCampo.setText("*Prencha Todos os campos");
               }
           }
       });

       btnDesistir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

    }
    public void onAvancar(){
        Intent intent = new Intent(this, Disciplina.class);
        startActivity(intent);
    }
}
