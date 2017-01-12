package com.example.deyneson.calculadora;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private TextView txtTela;
    private String operador = "+";
    private double ultimoNumero = 0, total = 0;
    private boolean pontoUtilizado = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        txtTela = (TextView) findViewById(R.id.txtTela);
    }

    public void preencherTela(View view){
        //txtTela.getText().toString().contains(".");
        if(txtTela.getText().toString().equals("")){
            if(view.getTag().toString().equals(".")){
                txtTela.setText("0.");
                pontoUtilizado = true;
            }else {
                txtTela.setText(txtTela.getText() + view.getTag().toString());
            }
        }else{
            if(view.getTag().toString().equals(".")){
                if(pontoUtilizado == false && txtTela.getText().charAt(txtTela.getText().length() - 1) != '.'){
                    txtTela.setText(txtTela.getText() + view.getTag().toString());
                    pontoUtilizado = true;
                }
            }else {
                txtTela.setText(txtTela.getText() + view.getTag().toString());
            }
        }

        switch (txtTela.getText().length()){
            case 5:
                txtTela.setTextSize(60);
                break;
            case 7:
                txtTela.setTextSize(40);
                break;
            case 20:
                txtTela.setTextSize(20);
                break;
        }
    }

    public void setarOperador(View view){
        if(!txtTela.getText().toString().equals("")){
            total = Double.parseDouble(txtTela.getText().toString());
        }
        txtTela.setText("");
        operador = view.getTag().toString();
        pontoUtilizado = false;
    }

    public void calcular(View view){
        switch (operador){
            case "+":
                total += ultimoNumero;
                break;
            case "-":
                total -= ultimoNumero;
                break;
            case "x":
                total *= ultimoNumero;
                break;
            case "/":
                total /= ultimoNumero;
                break;
        }
        ultimoNumero = 0;
        txtTela.setText(Double.toString(total));
    }

    public void btnIgualClick(View view) {
        if(!txtTela.getText().toString().equals("")) {
            ultimoNumero = Double.parseDouble(txtTela.getText().toString());
            calcular(null);
            total = 0;
            pontoUtilizado = false;
        }
    }

    public void limparTela(View view) {
        txtTela.setText("");
        ultimoNumero = 0;
        total = 0;
        pontoUtilizado = false;
        txtTela.setTextSize(90);
    }

    public void mensagemClick(View view){
        //Criar e editar o dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Titulo");
        builder.setMessage("Msg");

        //Criar onClick do dialog
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Sim", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Não", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Não sei", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Não sei", Toast.LENGTH_SHORT).show();
            }
        });

        //Criar o dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        //Mostrar o dialog
        alertDialog.show();;
    }
}
