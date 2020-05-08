package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Aprovado2 extends AppCompatActivity {
    private TextView notaFinal;
    TextView disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado2);

        notaFinal = (TextView) findViewById(R.id.idNotaFinal);
        disciplina = (TextView) findViewById(R.id.idDisciplina);
        String disciplinavalor = getIntent().getStringExtra("disciplina");
        disciplina.setText(disciplinavalor);
        String valorNotaReprovado = getIntent().getStringExtra("notaReprovado");
        notaFinal.setText(valorNotaReprovado);
    }
    public void onVoltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
