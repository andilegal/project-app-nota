package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Aprovado extends AppCompatActivity {
    Spinner disciplinas;
    EditText nota1;
    EditText nota2;
    TextView prenchaCampos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado);
    }
    public void btnCalcOnclick(View view){
        nota1 = (EditText) findViewById(R.id.idNotaA2);
        nota2 = (EditText) findViewById(R.id.idNotaAF);
        prenchaCampos = (TextView) findViewById(R.id.idPreenchaOsCampos);
        String nota1Valor = nota1.getText().toString();
        String nota2Valor = nota2.getText().toString();
        disciplinas = (Spinner) findViewById(R.id.idSpinnerDisciplinas);
        if(nota1Valor != null && !nota1Valor.equals("") && nota2Valor != null && !nota2Valor.equals("")) {
            Double calcNota = (Double.parseDouble(nota1.getText().toString()) + Double.parseDouble(nota2.getText().toString()));
            if (calcNota >= 6.0) {
                Intent intent = new Intent(this, Aprovado1.class);
                intent.putExtra("disciplina", disciplinas.getSelectedItem().toString());
                intent.putExtra("resultadoNota", calcNota.toString());
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, AvaliacaoFinal.class);
                intent.putExtra("disciplina", disciplinas.getSelectedItem().toString());
                intent.putExtra("resultadoNota", calcNota.toString());
                startActivity(intent);
            }
        }else{
            prenchaCampos.setText("*Prencha os Campos Corretamente");
        }
    }
}

