package com.fastcoding.agenda.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.*;
import android.provider.ContactsContract;
import android.widget.*;
import android.database.sqlite.*;

import com.fastcoding.agenda.R;
import com.fastcoding.agenda.dominio.entidades.Contato;

import java.util.Date;

/**
 * Created by Italo on 16/08/2015.
 */
public class RepositorioContato {

    private SQLiteDatabase con;

    public  RepositorioContato (SQLiteDatabase con )
    {
        this.con = con;
    }

    public void inserir (Contato contato)
    {
        ContentValues values = new ContentValues(); //responsavel pela inserção de dados

        values.put("NOME", contato.getNome());
        values.put("TELEFONE", contato.getTelefone());
        values.put("TIPOTELEFONE", contato.getTipoTelefone());
        values.put("EMAIL", contato.getEmail());
        values.put("TIPOEMAIL", contato.getTipoEmail());
        values.put("ENDERECO", contato.getEndereco());
        values.put("TIPOENDERECO", contato.getTipoEndereco());
        values.put("DATASESPECIAIS", contato.getDatasEspeciais().getTime());
        values.put("TIPODATASESPECIAIS", contato.getTipoDatasEspeciais());
        values.put("GRUPOS", contato.getGrupos());

        con.insertOrThrow("CONTATO", null, values); /*responsavel por inserir os dados e exibir uma mensagem de erro se houver(exemplo, inserir um dado errado em algum campo
                                                    .insert só insere sem dar nenhum aviso*/


    }

    public ArrayAdapter<Contato> buscaContatos(Context context)
    {

        ArrayAdapter<Contato> adpContatos = new ArrayAdapter<Contato>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = con.query("CONTATO", null,null,null,null,null,null); /*responsavel por armazenar todos os registros que são consultados(select)
                                                                              .query você passa só a tabela e ele consulta tudo, .rawQuery você coloca o código*/

        if(cursor.getCount() > 0)// verifica se há registro no banco de dados, se houver[...]
        {
            cursor.moveToFirst();// [...]move para o primeiro registro do banco de dados
            do
            {
                Contato contato = new Contato();

                contato.setNome(cursor.getString(1));
                contato.setTelefone(cursor.getString(2));
                contato.setTipoTelefone(cursor.getString(3));
                contato.setEmail(cursor.getString(4));
                contato.setTipoEmail(cursor.getString(5));
                contato.setTipoEndereco(cursor.getString(6));
                contato.setTipoEndereco(cursor.getString(7));
                contato.setDatasEspeciais(new Date(cursor.getLong(8)));//classe anônima
                contato.setTipoDatasEspeciais(cursor.getString(9));
                contato.setGrupos(cursor.getString(10));
                adpContatos.add(contato);
            }
            while (cursor.moveToNext()); //preencher os registros enquanto houver registro
        }
        return  adpContatos;

    }









}
