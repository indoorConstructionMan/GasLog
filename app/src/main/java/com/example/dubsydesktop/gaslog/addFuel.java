package com.example.dubsydesktop.gaslog;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class addFuel extends AppCompatActivity {

    // Keys for the intent.
    public final static String ODOMETER = "com.example.dubsydesktop.gaslog.ODOMETER";
    public final static String GASCOST = "com.example.dubsydesktop.gaslog.GASCOST";
    public final static String GASQUANTITY = "com.example.dubsydesktop.gaslog.GASQUANTITY";

    // Fields in view
    public EditText odometerField;
    public EditText gasCostField;
    public EditText gasQuantityField;

    // Intent to pass stuff to another view.
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel);

        this.odometerField = (EditText) findViewById(R.id.odometer);
        this.gasCostField = (EditText) findViewById(R.id.gasCost);
        this.gasQuantityField = (EditText) findViewById(R.id.gasQuantity);
    }


    /* Attached to save button, grabs value from current view and opens a new activity
    *  with a specific intent.*/
    public void saveGasLog(View view) {

        this.intent = new Intent(this, DisplayResultsActivity.class);

        String odometerText = this.odometerField.getText().toString();
        String gasCostText = this.gasCostField.getText().toString();
        String gasQuantityText = this.gasQuantityField.getText().toString();

        try {

            Float odometer = Float.parseFloat(odometerText);
            Float gasCost = Float.parseFloat(gasCostText);
            Float gasQuantity = Float.parseFloat(gasQuantityText);

            intent.putExtra(this.ODOMETER, odometerText);
            intent.putExtra(this.GASCOST, gasCostText);
            intent.putExtra(this.GASQUANTITY, gasQuantityText);

            startActivity(intent);

        } catch (NumberFormatException e) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Each Field must be filled out, and all fields require numerical values.");
            AlertDialog alert = builder.create();
            alert.show();

         }

    }
}
