package com.example.ersan.agenda.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ersan.agenda.R;
import com.example.ersan.agenda.dal.CompromissosDal;
import com.example.ersan.agenda.util.ArrayAdapterCompromissos;

public class ListaCompromissosActivity extends AppCompatActivity {

    ListView lstCompromissos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compromissos);

        lstCompromissos = (ListView) findViewById(R.id.lstCompromissos);

        ArrayAdapterCompromissos arrayAdapterCompromissos = new ArrayAdapterCompromissos(this, CompromissosDal.listarCompromissos(this));

        lstCompromissos.setAdapter(arrayAdapterCompromissos);
    }
}
