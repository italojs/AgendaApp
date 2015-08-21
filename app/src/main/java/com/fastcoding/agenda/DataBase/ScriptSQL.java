package com.fastcoding.agenda.dataBase;

/**
 * Created by Italo on 16/08/2015.
 */
public class ScriptSQL
{

    public static String getCreateContato()
    {


        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS CONTATO ( ");
        sqlBuilder.append("_id                INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOME               VARCHAR (255),      ");
        sqlBuilder.append("TELEFONE           VARCHAR (14),      ");
        sqlBuilder.append("EMAIL              VARCHAR (255),    ");
        sqlBuilder.append("TIPOEMAIL          VARCHAR (1),      ");
        sqlBuilder.append("ENDERECO           VARCHAR (255),    ");
        sqlBuilder.append("TIPOENDERECO       VARCHAR (1),      ");
        sqlBuilder.append("DATASESPECIAIS     DATE,             ");
        sqlBuilder.append("IPODATASESPECIAIS  VARCHAR (1),      ");
        sqlBuilder.append("GRUPOS             VARCHAR (255)     ");
        sqlBuilder.append(");");

        return  sqlBuilder.toString();

    }
}
