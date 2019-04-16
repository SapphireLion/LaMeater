package com.example.lameater.db;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "meats.sqlite3"; //DB Name
    public static final String TABLE_1 = "Meats"; // Table 1 Name
    public static final String TABLE_2 = "Categories"; //Table 2 Name
    public static final String TABLE_3 = "CookTemps"; // Table 3 Name
    public static String PATH_NAME = " ";
    public static final String ASSETS_PATH="databases";
    public static int DATABASE_VERSION = 1;

    // Fields for Table 1 (Meats)
    public static final String T1_C1  = "mid";
    public static final String T1_C2  = "cid";
    public static final String T1_C3 = "name";
    public static final String T1_C4 = "description";

    //Fields for Table 2 (Categories)
    public static final String T2_C1 = "cid";
    public static final String T2_C2 = "name";

    //FIelds for Table 3 (CookTemps)
    public static final String T3_C1 = "cid";
    public static final String T3_C2 = "mid";
    public static final String T3_C3 = "tid";
    public static final String T3_C4 = "name";
    public static final String T3_C5 = "temp";



    private void installDBFromAssets(){

    }
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        PATH_NAME = context.getApplicationInfo().dataDir + "/databases/";

        //Get Database Access
        try {
            InputStream infile = context.getAssets().open(ASSETS_PATH + "/" + DATABASE_NAME);
            File outfile = context.getDatabasePath(DATABASE_NAME);
            FileOutputStream ofstream = null;
            try {
                ofstream = new FileOutputStream(outfile);
            } catch (FileNotFoundException ex) {
                //File not found error
            }

            byte[] buffer = new byte[1024];
            while (true) {
                try {
                    int bytesRead = infile.read(buffer);
                    if (bytesRead == -1)
                        break;
                    ofstream.write(buffer, 0, bytesRead);
                } catch (IOException e) {
                }

                try {
                    infile.close();
                } catch (IOException e) {
                }
                try {
                    ofstream.flush();
                } catch (IOException e) {
                }
                try {
                    ofstream.close();
                } catch (IOException e) {
                }

            }

        } catch (IOException e) {
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_2 + "(cid INT, name TEXT, PRIMARY KEY (cid))");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_1 + "(cid INT, mid INT, name TEXT, description TEXT, PRIMARY KEY (cid, mid), FOREIGN KEY (cid) REFERENCES "+ TABLE_2+ "(cid))");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_3 +"(cid INT, mid INT, tid INT, name TEXT, temperature INT, PRIMARY KEY (cid, mid, tid), FOREIGN KEY (cid) REFERENCES "+ TABLE_2 + "(cid), FOREIGN KEY (mid) REFERENCES "+TABLE_1+"(mid))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_1);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_3);
        onCreate(db);
    }

   public Cursor getAllCategories(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+T2_C2 + " FROM "+TABLE_2,null);
        return res;
   }



}
