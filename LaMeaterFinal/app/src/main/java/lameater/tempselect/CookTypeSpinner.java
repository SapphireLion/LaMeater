package lameater.tempselect;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.List;


public class CookTypeSpinner extends AppCompatSpinner {


    public CookTypeSpinner(Context con, int cid, int mid, String[] myMenu) {
        super(con);
        ArrayAdapter<String> CookTypeAdapter = new ArrayAdapter<>(con, android.R.layout.simple_list_item_1, myMenu);
        CookTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setAdapter(CookTypeAdapter);

        setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}


