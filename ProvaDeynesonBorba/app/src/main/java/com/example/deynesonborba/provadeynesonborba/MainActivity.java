package com.example.deynesonborba.provadeynesonborba;

import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgId;
    EditText edtValorReal;
    TextView txtDolar, txtDolarConvertido, txtEuro, txtEuroConvertido, txtPesos, txtPesosConvertido;
    Button btnConverter, btnLimpar;
    double cotacaoDollar = 3.15, cotacaoEuro = 3.43, cotacaoPeso = 0.20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgId = (ImageView) findViewById(R.id.imgId);
        edtValorReal = (EditText) findViewById(R.id.edtValorReal);
        txtDolarConvertido = (TextView) findViewById(R.id.txtDolarConvertido);
        txtEuroConvertido = (TextView) findViewById(R.id.txtEuroConvertido);
        txtPesosConvertido = (TextView) findViewById(R.id.txtPesosConvertido);
        btnConverter = (Button) findViewById(R.id.btnConverter);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
    }

    public void btnConverterClick(View view) {

        if(!edtValorReal.getText().toString().equals(null) && !edtValorReal.getText().toString().equals("")){

            double dblValorReal = Double.parseDouble(edtValorReal.getText().toString());
            double resConvertDollar = dblValorReal / cotacaoDollar;
            double resConvertEuro = dblValorReal / cotacaoEuro;
            double resConvertPeso = dblValorReal / cotacaoPeso;

            txtDolarConvertido.setText(String.valueOf(resConvertDollar));
            txtEuroConvertido.setText(String.valueOf(resConvertEuro));
            txtPesosConvertido.setText(String.valueOf(resConvertPeso));

            imgId.setImageResource(R.drawable.dollarblack);
        }
    }

    public void btnLimparClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Limpar Campos");
        builder.setMessage("Deseja limpar os campos?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                txtDolarConvertido.setText("");
                txtDolarConvertido.setHint("Valor convertido");

                txtEuroConvertido.setText("");
                txtEuroConvertido.setHint("Valor convertido");

                txtPesosConvertido.setText("");
                txtPesosConvertido.setHint("Valor convertido");

                edtValorReal.setText("");

                imgId.setImageResource(R.drawable.dollargreen);
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
}
