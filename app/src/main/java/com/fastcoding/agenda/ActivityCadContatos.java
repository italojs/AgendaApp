package com.fastcoding.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;

public class ActivityCadContatos extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome,edtEmail,edtTelefone,edtEndereco,edtDatasEspeciais,edtGrupos;

    private Spinner spnTipoEmail,spnTipoTelefone,spnTipoEndereco,spnDatasEspeciais;

    private ArrayAdapter<String> adpTipoEmail,adpTipoTelefone, adpTipoEndereco,adpDatasEspeciais ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }


    @Override
    public void onClick(View v) {


    }
}
