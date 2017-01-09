package com.example.dubsydesktop.gaslog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DisplayResultsActivity extends AppCompatActivity {

    public ArrayList<String> result;
    static final String[] FRUITS = new String[] { "Apple : Fruit", "Avocado", "Banana",
            "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
            "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        Intent intent = getIntent();

        String odometer = intent.getStringExtra(addFuel.ODOMETER);
        String quantity = intent.getStringExtra(addFuel.GASQUANTITY);
        String cost = intent.getStringExtra(addFuel.GASCOST);

        String[] x = new String[1];
        x[0] = "Odometer: " + odometer + " KMs -> Quantity: " + quantity + " Liters -> Cost: " + cost + " Dollars";

        ListView view = (ListView) findViewById(R.id.gas_logs);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, x);

        view.setAdapter(adapter);

    }
}
