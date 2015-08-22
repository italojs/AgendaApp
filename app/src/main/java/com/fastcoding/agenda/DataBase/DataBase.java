package com.fastcoding.agenda.dataBase;


import android.content.Context;
import android.database.sqlite.*;

public class DataBase extends SQLiteOpenHelper
{

    public DataBase(Context context)
    {       //construtor da classe SQLiteOpenHelper

        super(context,"DB_AGENDA", null, 1); //construtor [...](contexto,nome do banco de dados, algo sobre o cursor que eu não entendi muito bem, numero da versão do BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {    //cria as tabelas

        db.execSQL(ScriptSQL.getCreateContato());//passa o Script do BD

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    { // atualiza as tabelas

    }
}
