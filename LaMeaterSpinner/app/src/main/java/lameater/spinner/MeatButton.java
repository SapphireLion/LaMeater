package lameater.spinner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class MeatButton extends AppCompatButton {

    public static final String CATEGORY_ID = "CATEGORY_ID";
    public static final String PENIS = "MEAT_ID";
    private int cid;
    private int mid;

    public MeatButton(Context c, int cid, int mid, String name) {
        super(c);
        setText(name);
        this.cid = cid;
        this.mid = mid;

        setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchSelectionActivity();
            }
        });
    }

    private void launchSelectionActivity() {
        Context context = this.getContext();
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(CATEGORY_ID, cid);
        intent.putExtra(PENIS, mid);
        context.startActivity(intent);
    }

}
