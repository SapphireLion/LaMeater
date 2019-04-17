package lameater.spinner;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DavidSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    //Category Spinner
    Spinner DavidSpinner = (Spinner) findViewById(R.id.DavidSpinner);


    public void doAdapter(){
        DavidAdapter(this);
    }
    public void DavidAdapter(Context context) {

        //Category Adapter Declaration
        DavidSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> DavidAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.david));
        DavidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DavidSpinner.setAdapter(DavidAdapter);

    }

    public void onItemSelected(AdapterView<?> catAdapter, View v,int pos, long id) {
        // An item was selectd.
    }

    public void onNothingSelected(AdapterView<?> catAdapter)
    {
        // Nothing was selected.
    }


}
