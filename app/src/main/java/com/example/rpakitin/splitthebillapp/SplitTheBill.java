package com.example.rpakitin.splitthebillapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SplitTheBill extends AppCompatActivity {
    double billAmount;
    int numberOfPeople;
    double tipAmount = .18;
    double totalCost;
    String qualityChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_the_bill);
        final EditText bill = (EditText)findViewById(R.id.txtBill);
        final EditText people = (EditText)findViewById(R.id.txtNumberOfPeople);
        final Spinner quality = (Spinner)findViewById(R.id.txtQuality);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {
                billAmount = Double.parseDouble(bill.getText( ).toString( ));
                numberOfPeople = Integer.parseInt(people.getText( ).toString( ));
                totalCost = (billAmount + (billAmount * tipAmount)) / numberOfPeople;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                qualityChoice = quality.getSelectedItem( ).toString( );
                result.setText("Each person will have to pay " + currency.format(totalCost));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_split_the_bill, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
