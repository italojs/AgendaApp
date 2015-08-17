package com.fastcoding.agenda.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.*;
import android.provider.ContactsContract;
import android.widget.*;
import android.database.sqlite.*;

import com.fastcoding.agenda.R;

/**
 * Created by Italo on 16/08/2015.
 */
public class RepositorioContato {

    private SQLiteDatabase con;

    public  RepositorioContato (SQLiteDatabase con )
    {
        this.con = con;
    }

    public void testeInserirContatos() {
        for (int i = 0; i < 10; i++) {
            ContentValues values = new ContentValues(); //responsavel pela inserção de dados
            values.put("TELEFONE", "55555555");

            con.insertOrThrow("CONTATO", null, values); /*responsavel por inserir os dados e exibir uma mensagem de erro se houver(exemplo, inserir um dado errado em algum campo
                             .insert só insere sem dar nenhum aviso*/
        }
    }

    public ArrayAdapter<String> buscaContatos(Context context)
    {

        ArrayAdapter<String> adpContatos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = con.query("CONTATO", null,null,null,null,null,null); /*responsavel por armazenar todos os registros que são consultados(select)
                                                                              .query você passa só a tabela e ele consulta tudo, .rawQuery você coloca o código*/

        if(cursor.getCount() > 0)// verifica se há registro no banco de dados, se houver[...]
        {
            cursor.moveToFirst();// [...]move para o primeiro registro do banco de dados
            do
            {
                String telefone = cursor.getString(1);
                adpContatos.add(telefone);
            }
            while (cursor.moveToNext()); //preencher os registros enquanto houver registro
        }
        return  adpContatos;

    }









}
