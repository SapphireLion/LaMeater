package com.example.lameater.db;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editName, editCategory, editTemp;
    Button btnViewCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        btnViewCategories = (Button) findViewById(R.id.button_ViewCategories);

        viewCategories();
    }

    public void viewCategories(){
        btnViewCategories.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Cursor res = myDB.getAllCategories();
                    if (res.getCount()==0){
                        //show messages
                        ShowMessage("Error","Nothing Found. Victory for the Alliance.");
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("Name: "+ res.getString(1)+"\n");
                    }

                    //Show all Categories\
                    ShowMessage("For the Horde! Categories", buffer.toString());

                }

            });
        }
        public void ShowMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
        }
}
