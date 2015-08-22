package com.fastcoding.agenda.activities;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import com.fastcoding.agenda.R;
import com.fastcoding.agenda.dataBase.DataBase;
import com.fastcoding.agenda.dominio.RepositorioContato;
import com.fastcoding.agenda.dominio.entidades.Contato;

import java.util.Date;

public class ActivityCadContatos extends AppCompatActivity implements View.OnClickListener
{

    private EditText edtNome,edtEmail,edtTelefone,edtEndereco,edtDatasEspeciais,edtGrupos;

    private Spinner spnTipoEmail,spnTipoTelefone,spnTipoEndereco,spnDatasEspeciais;

    private ArrayAdapter<String> adpTipoEmail,adpTipoTelefone, adpTipoEndereco,adpDatasEspeciais ;

    private RepositorioContato repositorioContato;
    private DataBase dataBase;
    private SQLiteDatabase con;
    private Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_contatos);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtDatasEspeciais = (EditText) findViewById(R.id.edtDatasEspeciais);
        edtGrupos = (EditText) findViewById(R.id.edtGrupos);

        spnTipoEmail = (Spinner)findViewById(R.id.spnTipoEmail);
        spnTipoTelefone = (Spinner)findViewById(R.id.spnTipoTelefone);
        spnTipoEndereco = (Spinner)findViewById(R.id.spnTipoEndereco);
        spnDatasEspeciais = (Spinner)findViewById(R.id.spnDatasEspeciais);

        adpTipoEmail = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adpTipoEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoTelefone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adpTipoTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoEndereco = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adpTipoEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpDatasEspeciais = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adpDatasEspeciais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnTipoEmail.setAdapter(adpTipoEmail); //associando o spinner ao ArrayAdapter
        spnTipoTelefone.setAdapter(adpTipoTelefone);
        spnTipoEndereco.setAdapter(adpTipoEndereco);
        spnDatasEspeciais.setAdapter(adpDatasEspeciais);

        adpTipoEmail.add("Casa");
        adpTipoEmail.add("Trabalho");
        adpTipoEmail.add("Outros");

        adpTipoTelefone.add("Celular");
        adpTipoTelefone.add("Trabalho");
        adpTipoTelefone.add("Casa");
        adpTipoTelefone.add("Principal");
        adpTipoTelefone.add("Fax trabalho");
        adpTipoTelefone.add("Fax casa");
        adpTipoTelefone.add("Pager");
        adpTipoTelefone.add("Outros");

        adpTipoEndereco.add("Casa");
        adpTipoEndereco.add("Trabalho");
        adpTipoEndereco.add("Outros");

        adpDatasEspeciais.add("Aniversário");
        adpDatasEspeciais.add("Data comemorativa");
        adpDatasEspeciais.add("Outros");

        try
        {
            dataBase = new DataBase(this);
            con = dataBase.getWritableDatabase();

            repositorioContato = new RepositorioContato(con);

        }
        catch (SQLException ex)
        {
            Toast.makeText(ActivityCadContatos.this, "Erro ao criar o Banco de dados\nERRO: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater infalter = getMenuInflater();
        infalter.inflate(R.menu.menu_activity_cad_contatos, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.mni_Acao1:
                if(contato == null)
                {
                    inserir();
                }
                finish();

                break;

            case R.id.mni_Acao2:
                break;
        }



        return super.onOptionsItemSelected(item);
    }

    private void inserir ()
    {
        try {
            contato = new Contato();

            contato.setNome(edtNome.getText().toString());
            contato.setTelefone(edtTelefone.getText().toString());
            contato.setEmail(edtEmail.getText().toString());
            contato.setEndereco(edtEndereco.getText().toString());

            Date date = new Date();//não entendi muito bem o porque fazer isso
            contato.setDatasEspeciais(date);

            contato.setGrupos(edtGrupos.getText().toString());



            contato.setTipoTelefone("");
            contato.setTipoEmail("");
            contato.setTipoEndereco("");
            contato.setTipoDatasEspeciais("");


            repositorioContato.inserir(contato);
        }
        catch (Exception ex)
        {
            Toast.makeText(ActivityCadContatos.this, "Erro ao inserir os dados. ERRO: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v)
    {


    }
}
