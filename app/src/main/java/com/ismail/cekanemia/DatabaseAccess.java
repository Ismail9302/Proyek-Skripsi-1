package com.ismail.cekanemia;

/**
 * Created by ukietux on 29/10/15.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */

    //Mengampil nama penyakit dari database
    public List<Diagnosa> TampilPenyakit() {
        Cursor c = null;
        c = database.rawQuery("SELECT * FROM pertanyaan", null);
        List<Diagnosa> data = new ArrayList<>();
//        String[] Str = new String[c.getCount()];
//        double [] aplastik = new double[c.getCount()];
//        double [] db = new double[c.getCount()];
//        double [] pk = new double[c.getCount()];
//        double [] hemolitik = new double[c.getCount()];

//        int i = 0;
        while (c.moveToNext()) {
            Diagnosa diagnosa = new Diagnosa();
            diagnosa.setGejalaKlinis(c.getString(+c.getColumnIndex("gejala_klinis")));
            diagnosa.setAplastik(Double.parseDouble(c.getString(+c.getColumnIndex("anemia_aplastik"))));
            diagnosa.setDb(Double.parseDouble(c.getString(+c.getColumnIndex("anemia_db"))));
            diagnosa.setPk(Double.parseDouble(c.getString(+c.getColumnIndex("anemia_pk"))));
            diagnosa.setHemolitik(Double.parseDouble(c.getString(+c.getColumnIndex("anemia_hemolitik"))));
            data.add(diagnosa);

//            Str[i] = c.getString(+c.getColumnIndex("gejala_klinis"));
//            aplastik[i] = Double.parseDouble(c.getString(+c.getColumnIndex("anemia_aplastik")));
//            db[i] = Double.parseDouble(c.getString(+c.getColumnIndex("anemia_db")));
//            pk[i] = Double.parseDouble(c.getString(+c.getColumnIndex("anemia_pk")));
//            hemolitik[i] = Double.parseDouble(c.getString(+c.getColumnIndex("anemia_hemolitik")));
//            i++;
        }
        c.close();
        return data;
    }
}
