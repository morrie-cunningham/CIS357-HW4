package edu.gvsu.cis.hw4_geocalc;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class GeoCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_calc);
    }

    EditText p1la = (EditText) findViewById(R.id.p1lat);
    EditText p1lo = (EditText) findViewById(R.id.p1long);
    EditText p2la = (EditText) findViewById(R.id.p2lat);
    EditText p2lo = (EditText) findViewById(R.id.p2long);

    Button calc = (Button) findViewById(R.id.calcButton);
    Button clear = (Button) findViewById(R.id.clearButton);

    calc.setOnClickListener(v -> {
        String p1lastr = p1la.getText().toString();
        if(p1lastr.length() ==0) {
            Snackbar.make(p1la, "Enter 2 Lat/Long Points.", Snackbar.LENGTH_LONG).show();
        }
    });
}
