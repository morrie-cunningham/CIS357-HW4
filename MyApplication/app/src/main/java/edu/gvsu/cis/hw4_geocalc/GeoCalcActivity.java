package edu.gvsu.cis.hw4_geocalc;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GeoCalcActivity extends AppCompatActivity {

    EditText p1la;
    EditText p1lo;
    EditText p2la;
    EditText p2lo;
    TextView outDistance;
    TextView outBearing;

    Float oDist;
    Float oBear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_calc);

        p1la = (EditText) findViewById(R.id.p1lat);
        p1lo = (EditText) findViewById(R.id.p1long);
        p2la = (EditText) findViewById(R.id.p2lat);
        p2lo = (EditText) findViewById(R.id.p2long);
        outDistance = (TextView) findViewById(R.id.outputDistanceView);
        outBearing = (TextView) findViewById(R.id.outputBearingView);

        Button calc = (Button) findViewById(R.id.calcButton);
        Button clear = (Button) findViewById(R.id.clearButton);

        clear.setOnClickListener(v -> {
            p1la.setText("");
            p1lo.setText("");
            p2la.setText("");
            p2lo.setText("");
            outDistance.setText("");
            outBearing.setText("");
        });

        calc.setOnClickListener(v -> {
            String p1lastr = p1la.getText().toString();
            String p1lostr = p1lo.getText().toString();
            String p2lastr = p2la.getText().toString();
            String p2lostr = p2lo.getText().toString();
            if (p1lastr.length() == 0 || p1lostr.length() == 0 || p2lastr.length() == 0 || p2lostr.length() == 0) {
                Snackbar.make(p1la, "Enter 2 Lat/Long Points.", Snackbar.LENGTH_LONG).show();
            } else {
                Location loc1 = new Location("");
                loc1.setLatitude(Double.parseDouble(p1la.getText().toString()));
                loc1.setLongitude(Double.parseDouble(p1lo.getText().toString()));

                Location loc2 = new Location("");
                loc2.setLatitude(Double.parseDouble(p2la.getText().toString()));
                loc2.setLongitude(Double.parseDouble(p2lo.getText().toString()));

                oDist = loc1.distanceTo(loc2)/1000;
                oBear = loc1.bearingTo(loc2);
                outDistance.setText(String.format("%.2f",oDist) + " kilometers");
                outBearing.setText(String.format("%.2f", oBear) + " degrees");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
