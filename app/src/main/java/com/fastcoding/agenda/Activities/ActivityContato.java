package com.fastcoding.agenda.activities;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.database.sqlite.*;
import android.database.*;
import com.fastcoding.agenda.dominio.*;
import com.fastcoding.agenda.dataBase.DataBase;
import com.fastcoding.agenda.R;
import com.fastcoding.agenda.dominio.entidades.Contato;

public class ActivityContato extends AppCompatActivity implements View.OnClickListener
{

    private ImageButton btnAdicionar;
    private EditText edtPesquisa;
    private ListView lstContatos;
    private ArrayAdapter<Contato> adpContatos;
    private RepositorioContato repositorioContato;
    private DataBase dataBase;
    private SQLiteDatabase con;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);


        btnAdicionar = (ImageButton) findViewById(R.id.btnAdicionar);
        edtPesquisa = (EditText) findViewById( R.id.edtPesquisa);
        lstContatos = (ListView) findViewById( R.id.lstContatos);

        btnAdicionar.setOnClickListener(this);

        try
        {
            dataBase = new DataBase(this);       //a instância dessa classe é para utilizar os métodos de banco dados
            con = dataBase.getWritableDatabase();//chama o método que cria o BD e abre

            //Toast.makeText(ActivityContato.this, "Banco conectado.", Toast.LENGTH_SHORT).show();

            repositorioContato = new RepositorioContato(con);

            adpContatos = repositorioContato.buscaContatos(this);

            lstContatos.setAdapter(adpContatos); //preenche o ListView com os dados do ArrayAdapter
        }
        catch (SQLException ex)
        {
            Toast.makeText(ActivityContato.this, "Erro ao criar o Banco de dados\nERRO: " + ex, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View v)
    {

        Intent it = new Intent(this, ActivityCadContatos.class);
        startActivityForResult(it, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        adpContatos = repositorioContato.buscaContatos(this);
        lstContatos.setAdapter(adpContatos);
    }
}
