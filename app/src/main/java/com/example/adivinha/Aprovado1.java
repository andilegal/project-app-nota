package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Aprovado1 extends AppCompatActivity {

    private Button btnVoltar;
    private EditText notaFinal;
    private EditText disciplina;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado1);
        btnVoltar = (Button) findViewById(R.id.idVoltar);
        notaFinal = (EditText) findViewById(R.id.idNotaFinal);
        disciplina = (EditText) findViewById(R.id.idDisciplina);
        String disciplinaValor = getIntent().getStringExtra("disciplina");
        disciplina.setText(disciplinaValor);

        String aprovadoValor = getIntent().getStringExtra("resultadoNota");
        notaFinal.setText(aprovadoValor);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVoltar();
            }
        });
    }

    public void onVoltar(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
