package br.usjt.ciclodevidagpsemapas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LocalizacaoDAO {

    private Context context;

    public LocalizacaoDAO(Context context){
        this.context = context;
    }
    public List<Localizacao> lista(){
        LocalizacaoDBHelper dbHelper = new LocalizacaoDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Localizacao> localizacoes = new ArrayList<>();
        String command = String.format(
                Locale.getDefault(),
                "SELECT * FROM %s ORDER BY data desc LIMIT 50;",
                TabelaLocalizacao.LocalizacaoTable.TABLE_NAME
        );
        Cursor cursor = db.rawQuery(command, null);
        while(cursor.moveToNext()){
            int idLocalizacao = cursor.getInt(cursor.getColumnIndex(String.format(
                Locale.getDefault(),
                "%s",
                    TabelaLocalizacao.LocalizacaoTable.COLUMN_NAME_ID
            )));
            double latitude = cursor.getDouble(cursor.getColumnIndex(String.format(
                    Locale.getDefault(),
                    "%s",
                    TabelaLocalizacao.LocalizacaoTable.COLUMN_NAME_LATITUDE
            )));
            double longitude = cursor.getDouble(cursor.getColumnIndex(String.format(
                    Locale.getDefault(),
                    "%s",
                    TabelaLocalizacao.LocalizacaoTable.COLUMN_NAME_LONGITUDE
            )));
            long milisegundos = cursor.getLong(cursor.getColumnIndex(String.format(
                    Locale.getDefault(),
                    "%s",
                    TabelaLocalizacao.LocalizacaoTable.COLUMN_NAME_DATA
            )));
            localizacoes.add(new Localizacao(idLocalizacao, latitude, longitude, new Date(milisegundos)));
        }
        cursor.close();
        db.close();
        dbHelper.close();
        return localizacoes;
    }

    public void insertLocalizacao(Localizacao localizacao){
        LocalizacaoDBHelper dbHelper = new LocalizacaoDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TabelaLocalizacao.LocalizacaoTable.COLUMN_NAME_LATITUDE, localizacao.getLatitude());
        values.put(TabelaLocalizacao.LocalizacaoTable.COLUMN_NAME_LONGITUDE, localizacao.getLongitude());
        values.put(TabelaLocalizacao.LocalizacaoTable.COLUMN_NAME_DATA, localizacao.getData().getTime());
        db.insert(TabelaLocalizacao.LocalizacaoTable.TABLE_NAME, null, values);
        db.close();
        dbHelper.close();
    }
}
