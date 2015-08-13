package com.fastcoding.agenda;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class ActivityContato extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnAdicionar;
    private EditText edtPesquisa;
    private ListView lstContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);


        btnAdicionar = (ImageButton) findViewById(R.id.btnAdicionar);
        edtPesquisa = (EditText) findViewById( R.id.edtPesquisa);
        lstContatos = (ListView) findViewById( R.id.lstContatos);

        btnAdicionar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Intent it = new Intent(this, ActivityCadContatos.class);
        startActivity(it);
    }
}
