package com.example.deynesonborba.guess;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JogoActivity extends AppCompatActivity {

    TextView txtNumeroSorteado, txtStatus;
    EditText edtEntrada;
    Button btnVerificar;
    String dificuldade;
    int iNumSorteado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        txtNumeroSorteado = (TextView) findViewById(R.id.txtNumeroSorteado);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        edtEntrada = (EditText) findViewById(R.id.edtEntrada);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);

        dificuldade = getIntent().getStringExtra("Dificuldade");
        sortearNumero();
    }

    private void sortearNumero(){
        Random r = new Random();
        switch (dificuldade){
            case "facil":
                iNumSorteado = (r.nextInt(11));
                break;
            case "medio":
                iNumSorteado = (r.nextInt(51));
                break;
            case "dificil":
                iNumSorteado = (r.nextInt(101));
                break;
        }
        //txtNumeroSorteado.setText(String.valueOf(iNumSorteado));
    }

    public void btnVerificarClick(View view) {
        if(!edtEntrada.getText().toString().equals(null) && !edtEntrada.getText().toString().equals("")) {

            int iNumDigitado = Integer.parseInt(edtEntrada.getText().toString());

            if (iNumDigitado < iNumSorteado) {
                txtStatus.setText("Numero digitado é menor que o sorteado!");
            } else if (iNumDigitado > iNumSorteado) {
                txtStatus.setText("Numero digitado é maior que o sorteado!");
            } else {
                txtNumeroSorteado.setText(iNumSorteado + "");
                txtNumeroSorteado.setTextColor(Color.parseColor("#99cc00"));
                txtStatus.setText("Parabéns você acertou!");
                txtStatus.setTextColor(Color.parseColor("#99cc00"));
            }
        }
    }
}
