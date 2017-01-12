package com.example.deyneson.jogodavelha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txtJogadorX, txtJogadorO, txtQtdVitoriasX, txtQtdVitoriasO;
    boolean vezJogadorX = true, jgXvencedor = true, velha = false;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    int vitoriasJgX = 0, vitoriasJgO = 0, botoesUsados = 0;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup vg = (ViewGroup) findViewById(R.id.linearLayoutPaiId);

        txtJogadorX = (TextView) findViewById(R.id.txtJogadorX);
        txtJogadorO = (TextView) findViewById(R.id.txtJogadorO);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        txtQtdVitoriasX = (TextView) findViewById(R.id.txtQtdVitoriasX);
        txtQtdVitoriasO = (TextView) findViewById(R.id.txtQtdVitoriasO);
    }

    public void btnClick(View view) {

        //Button btn = (Button) view;
        if(!gameOver) {
            if (vezJogadorX) {
                Button b = (Button) view.findViewById(view.getId());
                if (b.getText().length() == 0) {
                    b.setText("X");
                    txtJogadorO.setTextColor(Color.parseColor("#0099cc"));
                    txtJogadorX.setTextColor(Color.parseColor("#ffffff"));
                    vezJogadorX = false;
                }
            } else {
                Button b = (Button) view.findViewById(view.getId());
                if (b.getText().length() == 0) {
                    b.setText("O");
                    txtJogadorO.setTextColor(Color.parseColor("#ffffff"));
                    txtJogadorX.setTextColor(Color.parseColor("#0099cc"));
                    vezJogadorX = true;
                }
            }
            verificarResultadosX();
            verificarResultadosO();
            botoesUsados++;
            if(botoesUsados >= 9){
                //velha
                Toast.makeText(MainActivity.this, "Velha!",Toast.LENGTH_SHORT).show();
                gameOver = true;
            }
        }else{
            Toast.makeText(MainActivity.this, "Começe um novo jogo!",Toast.LENGTH_SHORT).show();
        }
    }

    private void verificarResultadosX(){
        //Horizontal
        if(btn1.getText().equals("X") && btn2.getText().equals("X") && btn3.getText().equals("X")){
            imprimeVencedor("X",btn1,btn3,btn3);
        }
        if(btn4.getText().equals("X") && btn5.getText().equals("X") && btn6.getText().equals("X")){
            imprimeVencedor("X",btn4,btn5,btn6);
        }
        if(btn7.getText().equals("X") && btn8.getText().equals("X") && btn9.getText().equals("X")){
            imprimeVencedor("X",btn7,btn8,btn9);
        }
        //Vertical
        if(btn1.getText().equals("X") && btn4.getText().equals("X") && btn7.getText().equals("X")){
            imprimeVencedor("X",btn1,btn4,btn7);
        }
        if(btn2.getText().equals("X") && btn5.getText().equals("X") && btn8.getText().equals("X")){
            imprimeVencedor("X",btn2,btn5,btn8);
        }
        if(btn3.getText().equals("X") && btn6.getText().equals("X") && btn9.getText().equals("X")){
            imprimeVencedor("X",btn3,btn6,btn9);
        }
        //Diagonal
        if(btn1.getText().equals("X") && btn5.getText().equals("X") && btn9.getText().equals("X")){
            imprimeVencedor("X",btn1,btn5,btn9);
        }
        if(btn7.getText().equals("X") && btn5.getText().equals("X") && btn3.getText().equals("X")){
            imprimeVencedor("X",btn7,btn5,btn3);
        }
    }

    private void verificarResultadosO(){
        //Horizontal
        if(btn1.getText().equals("O") && btn2.getText().equals("O") && btn3.getText().equals("O")){
            imprimeVencedor("O",btn1,btn2,btn3);
        }
        if(btn4.getText().equals("O") && btn5.getText().equals("O") && btn6.getText().equals("O")){
            imprimeVencedor("O",btn4,btn5,btn6);
        }
        if(btn7.getText().equals("O") && btn8.getText().equals("O") && btn9.getText().equals("O")){
            imprimeVencedor("O",btn7,btn8,btn9);
        }
        //Vertical
        if(btn1.getText().equals("O") && btn4.getText().equals("O") && btn7.getText().equals("O")){
            imprimeVencedor("O",btn1,btn4,btn7);
        }
        if(btn2.getText().equals("O") && btn5.getText().equals("O") && btn8.getText().equals("O")){
            imprimeVencedor("O",btn2,btn5,btn8);
        }
        if(btn3.getText().equals("O") && btn6.getText().equals("O") && btn9.getText().equals("O")){
            imprimeVencedor("O",btn3,btn6,btn9);
        }
        //Diagonal
        if(btn1.getText().equals("O") && btn5.getText().equals("O") && btn9.getText().equals("O")){
            imprimeVencedor("O",btn1,btn5,btn9);
        }
        if(btn7.getText().equals("O") && btn5.getText().equals("O") && btn3.getText().equals("O")){
            imprimeVencedor("O",btn7,btn5,btn3);
        }
    }

    private void imprimeVencedor(String vencedor, Button btnVencedor1, Button btnVencedor2, Button btnVencedor3){
        if(vencedor.equals("X")){
            txtJogadorX.setTextColor(Color.parseColor("#99cc00"));
            Toast.makeText(MainActivity.this, "Jogador X venceu!",Toast.LENGTH_SHORT).show();
            vitoriasJgX++;
            txtQtdVitoriasX.setText("Vitórias: " + vitoriasJgX);
            jgXvencedor = true;
        }else {
            txtJogadorO.setTextColor(Color.parseColor("#99cc00"));
            Toast.makeText(MainActivity.this, "Jogador O venceu!",Toast.LENGTH_SHORT).show();
            vitoriasJgO++;
            txtQtdVitoriasO.setText("Vitórias: " + vitoriasJgO);
            jgXvencedor = false;
        }
        btnVencedor1.setTextColor(Color.parseColor("#99cc00"));
        btnVencedor2.setTextColor(Color.parseColor("#99cc00"));
        btnVencedor3.setTextColor(Color.parseColor("#99cc00"));
        gameOver = true;
    }

    public void btnNovoJogoClick(View view) {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setTextColor(Color.parseColor("#ffffff"));
        btn2.setTextColor(Color.parseColor("#ffffff"));
        btn3.setTextColor(Color.parseColor("#ffffff"));
        btn4.setTextColor(Color.parseColor("#ffffff"));
        btn5.setTextColor(Color.parseColor("#ffffff"));
        btn6.setTextColor(Color.parseColor("#ffffff"));
        btn7.setTextColor(Color.parseColor("#ffffff"));
        btn8.setTextColor(Color.parseColor("#ffffff"));
        btn9.setTextColor(Color.parseColor("#ffffff"));
        if(jgXvencedor){
            txtJogadorX.setTextColor(Color.parseColor("#0099cc"));
            txtJogadorO.setTextColor(Color.parseColor("#ffffff"));
            vezJogadorX = true;
        }else {
            txtJogadorO.setTextColor(Color.parseColor("#0099cc"));
            txtJogadorX.setTextColor(Color.parseColor("#ffffff"));
            vezJogadorX = false;
        }
        gameOver = false;
        botoesUsados = 0;
    }

    public void btnSairClick(View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
