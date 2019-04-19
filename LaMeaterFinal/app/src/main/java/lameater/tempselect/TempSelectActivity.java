package lameater.tempselect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class TempSelectActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_select);
        int cid = 0, mid = 0, tid = 0;
        String[] MyMenu = new String[5];
        float ReccomendedTemp = (float) 90.0;

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

        // Put User Temp Box in Activity
        doUserTextView(ReccomendedTemp);

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

    public void doUserTextView(final float ReccomendedTemp) {
        final float[] UserTemp = new float[1];
        final EditText UserTempText = (EditText) findViewById(R.id.UserTempBox);
        Button StartButton = (Button) findViewById(R.id.StartCheckTempButton);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserTemp[0] = Float.valueOf(UserTempText.getText().toString());
                // Print Warning if UserTemp < ReccomendedTemp
            }
        });

        if (UserTemp[0] < ReccomendedTemp) {
            AlertDialog.Builder AlertTempBuilder = new AlertDialog.Builder(TempSelectActivity.this);
            AlertTempBuilder.setMessage("The temperature you have entered is below the FDA Reccomended Temperature. Eating under-cooked meats can result in disease. Do you with to continue?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            BackToMain();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
        }
        else { //Otherwise start Checking Temp
            BackToMain();
        }
    }


    private void BackToMain() {
        startActivity((new Intent(this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
