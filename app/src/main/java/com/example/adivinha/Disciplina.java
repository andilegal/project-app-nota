package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Disciplina extends AppCompatActivity {

    private EditText disciplina;
    private ListView listaDisciplinas;
    private Button btnGravar;
    private Button btnVoltar;
    private Button btnAvancar;
    private ArrayList lista;
    private TextView preenchaCampos;
    ArrayAdapter<String> arrayAdapter;

    public Disciplina() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        btnGravar = (Button) findViewById(R.id.idBtnGravar);
        btnVoltar = (Button) findViewById(R.id.idBtnVoltar);
        btnAvancar = (Button) findViewById(R.id.idBtnAvancar);
        disciplina = (EditText) findViewById(R.id.idDisciplina);
        listaDisciplinas = (ListView) findViewById(R.id.idListaDisciplinas);
        preenchaCampos = (TextView) findViewById(R.id.idPreenchaCampos);

        lista = new ArrayList<String>();
         arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, lista);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String disciplinaValor = disciplina.getText().toString();
                if(disciplinaValor != null && !disciplinaValor.equals("")){
                    lista.add(disciplinaValor);
                    listaDisciplinas.setAdapter(arrayAdapter);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVoltar();
            }
        });

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(!lista.isEmpty()) {
                onAvancar();
                }else{
                preenchaCampos.setText("*Coloque as disciplinas do seu curso");
            }
            }
        });
    }

    public void onAvancar(){
        Intent intent = new Intent(this, Aprovado.class);
        startActivity(intent);
    }

    public void onVoltar(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
