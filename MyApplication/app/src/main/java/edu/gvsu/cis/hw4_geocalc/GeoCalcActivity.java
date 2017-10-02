package edu.gvsu.cis.hw4_geocalc;

import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GeoCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_calc);

        EditText p1la = (EditText) findViewById(R.id.p1lat);
        EditText p1lo = (EditText) findViewById(R.id.p1long);
        EditText p2la = (EditText) findViewById(R.id.p2lat);
        EditText p2lo = (EditText) findViewById(R.id.p2long);
        TextView outDistance = (TextView) findViewById(R.id.outputDistanceView);
        TextView outBearing = (TextView) findViewById(R.id.outputBearingView);

        Button calc = (Button) findViewById(R.id.calcButton);
        Button clear = (Button) findViewById(R.id.clearButton);

        clear.setOnClickListener(v1 -> {
            p1la.setText("");
            p1lo.setText("");
            p2la.setText("");
            p2lo.setText("");
            outDistance.setText("");
            outBearing.setText("");
        });

        calc.setOnClickListener(v2 -> {
            String p1lastr = p1la.getText().toString();
            if (p1lastr.length() == 0) {
                Snackbar.make(p1la, "Enter 2 Lat/Long Points.", Snackbar.LENGTH_LONG).show();
            } else {
                Location loc1 = new Location("");
                loc1.setLatitude(Double.parseDouble(p1la.getText().toString()));
                loc1.setLongitude(Double.parseDouble(p1lo.getText().toString()));

                Location loc2 = new Location("");
                loc2.setLatitude(Double.parseDouble(p2la.getText().toString()));
                loc2.setLongitude(Double.parseDouble(p2lo.getText().toString()));

                outDistance.setText(String.format("%.2f",loc1.distanceTo(loc2)/1000) + " kilometers");
                outBearing.setText(String.format("%.2f",loc1.bearingTo(loc2)) + " degrees");
            }
        });
    }
}
