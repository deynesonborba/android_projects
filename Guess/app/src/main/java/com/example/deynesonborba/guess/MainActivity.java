package com.example.deynesonborba.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RadioButton rdoFacil, rdoMedio, rdoDificil;
    Button btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoFacil = (RadioButton) findViewById(R.id.rdoFacil);
        rdoMedio = (RadioButton) findViewById(R.id.rdoMedio);
        rdoDificil = (RadioButton) findViewById(R.id.rdoDificil);
        btnJogar = (Button) findViewById(R.id.btnJogar);
    }

    public void btnJogarClick(View view) {

        String dificuldade = "";

        if(rdoFacil.isChecked()){
            dificuldade = "facil";
        }else if(rdoMedio.isChecked()){
            dificuldade = "medio";
        }else{
            dificuldade = "dificil";
        }

        Intent intent = new Intent(MainActivity.this, JogoActivity.class);
        intent.putExtra("Dificuldade", dificuldade);
        startActivity(intent);
    }
}