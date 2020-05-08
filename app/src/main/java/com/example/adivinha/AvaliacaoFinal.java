package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AvaliacaoFinal extends AppCompatActivity {
    Button btnCalcNotaFinal;
    EditText notaAF;
    TextView notaA2;
    TextView disciplina;
    TextView preencherCampo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_final);
        notaAF = (EditText) findViewById(R.id.idNotaAF);
        notaA2 = (TextView) findViewById(R.id.idNotaA2);
        disciplina = (TextView) findViewById(R.id.idDisciplinaAF);
        preencherCampo = (TextView) findViewById(R.id.idPreencherCampo);

        String disciplinaValor = getIntent().getStringExtra("disciplina");
        disciplina.setText(disciplinaValor);
        String resultadoNota = getIntent().getStringExtra("resultadoNota");
        notaA2.setText(resultadoNota);

    }
    public void onCalcularNotaFinal(View view){
        String notaAFValor = notaAF.getText().toString();
        String notaA2Valor = notaA2.getText().toString();

        if(notaAFValor != null && !notaAFValor.equals("") && notaA2Valor != null && !notaA2Valor.equals("")){
            Double calcNota = Double.parseDouble(notaAF.getText().toString()) + Double.parseDouble(notaA2.getText().toString());
            if(calcNota >= 6.0){
                Intent intent = new Intent(this, Aprovado2.class);
                intent.putExtra("disciplina", disciplina.getText().toString());
                intent.putExtra("notaReprovado", calcNota.toString());
                startActivity(intent);
            }else{
                Intent intent = new Intent(this, Reprovado.class);
                intent.putExtra("disciplina", disciplina.getText().toString());
                intent.putExtra("notaReprovado", calcNota.toString());
                startActivity(intent);
            }
        }else {
            preencherCampo.setText("A preencha nota da Avaliação Final");
        }
    }
}
