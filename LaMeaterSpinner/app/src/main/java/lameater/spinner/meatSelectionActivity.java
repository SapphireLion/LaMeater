package lameater.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class meatSelectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_souls_message);

        //Category Spinner
        Spinner CatSpinner = (Spinner) findViewById(R.id.CatSpinner);
        ArrayAdapter<String> CatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.categories));
        CatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CatSpinner.setAdapter(CatAdapter);
        CatSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> catAdapter, View view, int pos, long id) {
        // An item was selectd.
        String select = (String) catAdapter.getItemAtPosition(pos);

        Spinner DavidSpinner;
        ArrayAdapter<String> DavidAdapter;
        DavidSpinner = (Spinner) findViewById(R.id.DavidSpinner);
        switch (select) {
            case "David Cooper":
                DavidAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.david));
                DavidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                DavidSpinner.setAdapter(DavidAdapter);
                break;
            case "Allie Wallace":
                DavidAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.allie));
                DavidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                DavidSpinner.setAdapter(DavidAdapter);
                break;
            case "Jay Sui":
                DavidAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.jay));
                DavidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                DavidSpinner.setAdapter(DavidAdapter);
                break;
            case "Ruben Perez":
                DavidAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ruben));
                DavidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                DavidSpinner.setAdapter(DavidAdapter);
                break;
            case "Kevin Torres":
                DavidAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kevin));
                DavidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                DavidSpinner.setAdapter(DavidAdapter);
                break;
            default:
                DavidAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.empty));
                DavidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                DavidSpinner.setAdapter(DavidAdapter);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}