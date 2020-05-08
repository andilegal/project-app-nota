package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reprovado extends AppCompatActivity {
    private Button btnReprovado;
    private TextView notaFinal;
    private TextView disciplina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reprovado);

        btnReprovado = (Button) findViewById(R.id.idBtnReprovado);
        notaFinal = (TextView) findViewById(R.id.idNotaFinal);
        disciplina = (TextView) findViewById(R.id.idDisciplinaReprovado);

        String disciplinaValor = getIntent().getStringExtra("disciplina");
        disciplina.setText(disciplinaValor);

        String notaReprovado = getIntent().getStringExtra("notaReprovado");
        notaFinal.setText(notaReprovado);

        btnReprovado.setOnClickListener(new View.OnClickListener() {
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
