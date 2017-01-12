package com.example.deyneson.jogodaforca;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnVerificar;
    TextView txtLetrasErradas, txtPalavra, txtTamanhoPalavra;
    EditText edtLetra;
    ImageView imgForca;
    int erros = 0, acertos = 0;
    char[] chPalavraSorteada, chPalavraConstruida;
    String strPalavraSorteada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        txtLetrasErradas = (TextView) findViewById(R.id.txtLetrasErradas);
        txtPalavra = (TextView) findViewById(R.id.txtPalavra);
        edtLetra = (EditText) findViewById(R.id.edtLetra);
        imgForca = (ImageView) findViewById(R.id.imgForca);
        txtTamanhoPalavra = (TextView) findViewById(R.id.txtTamanhoPalavra);

        selecionarPalavra();
    }

    public void selecionarPalavra(){
        Random r = new Random();
        chPalavraSorteada = ListaDePalavras.retornarPalavra(r.nextInt(105));
        chPalavraConstruida =  new char[chPalavraSorteada.length];

        //saira
        //txtPalavra.setText(String.valueOf(chPalavraSorteada));
        strPalavraSorteada = String.valueOf(chPalavraSorteada);

        for(int i = 0; i < chPalavraSorteada.length; i++){
            chPalavraConstruida[i] = "_".charAt(0);
            txtTamanhoPalavra.setText(txtTamanhoPalavra.getText() + String.valueOf(chPalavraConstruida[i]) + " ");
//            if(txtTamanhoPalavra.getHint() == null){
//                txtTamanhoPalavra.setHint("_ ");
//            }else {
//                txtTamanhoPalavra.setHint(txtTamanhoPalavra.getHint() + "_ ");
//            }
        }
    }

    public void btnVerificarLetraClick(View view) {
        String strLetraDigitada = edtLetra.getText().toString();

        boolean acertou = false;
        for(int i = 0; i < chPalavraSorteada.length; i++){
            if(String.valueOf(chPalavraSorteada[i]).equals(strLetraDigitada)){
                acertou = true;
                chPalavraConstruida[i] = strLetraDigitada.charAt(0);
            }
        }

        if(acertou == true) {
            txtTamanhoPalavra.setText("");
            for(int i = 0; i < chPalavraConstruida.length; i++) {
                txtTamanhoPalavra.setText(txtTamanhoPalavra.getText() + String.valueOf(chPalavraConstruida[i]) + " ");
            }
            acertos++;
            //Toast.makeText(this, "Acertou " + acertos + " vezes!", Toast.LENGTH_SHORT).show();
        } else {
            txtLetrasErradas.setText(txtLetrasErradas.getText() + strLetraDigitada + " ");
            erros++;
            //Toast.makeText(this, "Você errou " + erros + " vezes!", Toast.LENGTH_SHORT).show();
            trocarImagem();
        }
        edtLetra.setText("");
        verificarFimDeJogo();
    }

    public void verificarFimDeJogo(){
        //if(String.valueOf(chPalavraConstruida).equals(txtPalavra.getText().toString())){
        if(String.valueOf(chPalavraConstruida).equals(strPalavraSorteada)){
            //acertou palavra
            txtTamanhoPalavra.setTextColor(Color.parseColor("#99cc00"));
            Toast.makeText(this, "Venceu!", Toast.LENGTH_SHORT).show();
        }else if (erros == 8){
            //fim de jogo
            txtTamanhoPalavra.setText(strPalavraSorteada);
            txtTamanhoPalavra.setTextColor(Color.parseColor("#cc0000"));
            Toast.makeText(this, "Perdeu!", Toast.LENGTH_SHORT).show();
        }
    }

    private void trocarImagem(){
        switch (erros){
            case 1:
                imgForca.setImageResource(R.drawable.image1);
                break;
            case 2:
                imgForca.setImageResource(R.drawable.image2);
                break;
            case 3:
                imgForca.setImageResource(R.drawable.image3);
                break;
            case 4:
                imgForca.setImageResource(R.drawable.image4);
                break;
            case 5:
                imgForca.setImageResource(R.drawable.image5);
                break;
            case 6:
                imgForca.setImageResource(R.drawable.image6);
                break;
            case 7:
                imgForca.setImageResource(R.drawable.image7);
                break;
            case 8:
                imgForca.setImageResource(R.drawable.image8);
                break;
        }
    }
}
