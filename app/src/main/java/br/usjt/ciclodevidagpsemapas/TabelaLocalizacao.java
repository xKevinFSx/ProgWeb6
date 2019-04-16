package br.usjt.ciclodevidagpsemapas;

import android.provider.BaseColumns;
import android.provider.FontsContract;

import java.util.Locale;

public final class TabelaLocalizacao {

    private TabelaLocalizacao(){
    }

    public static class LocalizacaoTable implements BaseColumns {
        public static final String TABLE_NAME = "localizacao";
        public static final String COLUMN_NAME_ID = "id_localizacao";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";
        public static final String COLUMN_NAME_DATA = "data";
        public static final String DROP_TABLE = String.format("DROP TABLE %s", LocalizacaoTable.TABLE_NAME);
    }

    public static String createTableLocalizacao(){
        return String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s INTEGER);",
                LocalizacaoTable.TABLE_NAME,
                LocalizacaoTable.COLUMN_NAME_ID,
                LocalizacaoTable.COLUMN_NAME_LATITUDE,
                LocalizacaoTable.COLUMN_NAME_LONGITUDE,
                LocalizacaoTable.COLUMN_NAME_DATA
        );
    }

    public static String insertLocalizacao(Localizacao localizacao){
        String template = "INSERT INTO %s (%s, %s, %s) VALUES ('%s','%s', %d);";
        return String.format(
                Locale.getDefault(),
                template,
                LocalizacaoTable.TABLE_NAME,
                LocalizacaoTable.COLUMN_NAME_LATITUDE,
                LocalizacaoTable.COLUMN_NAME_LONGITUDE,
                LocalizacaoTable.COLUMN_NAME_DATA,
                localizacao.getLatitude(),
                localizacao.getLongitude(),
                localizacao.getData()
        );
    }



}
