package com.example.lameater.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    SQLiteDatabase db;
    EditText query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);
        db = myDB.getReadableDatabase();
        query = findViewById(R.id.query);
    }

    public void doQuery(View v) {
        String queryString = query.getText().toString();
        Cursor res = db.rawQuery(queryString, null);
        for (int i = 0; i < res.getCount(); i++) {
            res.moveToPosition(i);
            String row = "";
            for (int j = 0; j < res.getColumnCount(); j++) {
                switch (res.getType(j)) {
                    case Cursor.FIELD_TYPE_INTEGER:
                        row += res.getInt(j) + "\t";
                        break;
                    case Cursor.FIELD_TYPE_STRING:
                        row += res.getString(j) + "\t";
                        break;
                }
            }
            Log.d("QUERY", row);
        }
    }

}
