package com.fastcoding.agenda;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.database.sqlite.*;
import android.database.*;

public class ActivityContato extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnAdicionar;
    private EditText edtPesquisa;
    private ListView lstContatos;

    private DataBase dataBase;
    private SQLiteDatabase con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);


        btnAdicionar = (ImageButton) findViewById(R.id.btnAdicionar);
        edtPesquisa = (EditText) findViewById( R.id.edtPesquisa);
        lstContatos = (ListView) findViewById( R.id.lstContatos);

        btnAdicionar.setOnClickListener(this);

        try {
            dataBase = new DataBase(this);//a instância dessa classe é para utilizar os métodos de banco dados
            con = dataBase.getReadableDatabase();//chama o método que cria o BD e abre

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão efetuada com sucesso!");
            dlg.setNeutralButton("OK", null);
            dlg.show();

            Toast.makeText(ActivityContato.this, "Banco conectado.", Toast.LENGTH_SHORT).show();


        }
        catch (SQLException ex){
            Toast.makeText(ActivityContato.this, "Erro ao criar o Banco de dados\nERRO: " + ex, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View v) {

        Intent it = new Intent(this, ActivityCadContatos.class);
        startActivity(it);
    }
}
