package lameater.tempselect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class TempSelectActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_select);
        int cid = 0, mid = 0, tid = 0;
        String[] MyMenu = new String[5];

        // Change These For Spinner Options
        MyMenu[0] = "Dark Magician";
        MyMenu[1] = "Blue-Eyes White Dragon";
        MyMenu[2] = "Red-Eyes Black Dragon";
        MyMenu[3] = "Elemental HERO Neos";
        MyMenu[4] = "Stardust Dragon";

        // Put Spinner in Activity
        doSpinner(this, cid, mid, tid, MyMenu);

        // Put ImageView in Activity
        doImageView(1,1);

    }

    // Implement Spinner Function (Also Implements David's Aneurysm)
    public void doSpinner(Context context, int cid, int mid, int tid, String[] MyMenu) {
        Spinner CTSpinner = (Spinner) findViewById(R.id.CookTypeSpinner);

        ArrayAdapter<String> CookTypeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, MyMenu);
        CookTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CTSpinner.setAdapter(CookTypeAdapter);
    }

    public void doImageView(int cid, int mid) {
        ImageView meatView = (ImageView) findViewById(R.id.MeatPicView);

        String drawableName = "dick_"+cid + "_" + mid;
        int MeatPicResourceId = this.getResources().getIdentifier(drawableName, "drawable", this.getPackageName());
        meatView.setImageResource(MeatPicResourceId);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
