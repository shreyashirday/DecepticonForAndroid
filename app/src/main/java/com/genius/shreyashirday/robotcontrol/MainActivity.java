package com.genius.shreyashirday.robotcontrol;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.genius.shreyashirday.pojos.ArduinoReceiver;
import com.genius.shreyashirday.pojos.Decepticon;

import at.abraxas.amarino.Amarino;
import at.abraxas.amarino.AmarinoIntent;


public class MainActivity extends ActionBarActivity {


    private static final String DEVICE_ADDRESS = "ENTER BLUETOOTH MODULE ADDRESS HERE";
    Button startBtn,stopBtn,manBtn;

    ArduinoReceiver arduinoReceiver = new ArduinoReceiver();//use this to get sonar data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Amarino.connect(getApplicationContext(), DEVICE_ADDRESS);

        final Decepticon d = new Decepticon(DEVICE_ADDRESS,getApplicationContext()); //use this to control robot

        startBtn = (Button)findViewById(R.id.startB);
        stopBtn = (Button)findViewById(R.id.stopB);
        manBtn = (Button)findViewById(R.id.manB);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                automate(d);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.stop();
            }
        });

        manBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ManualOverride.class));
            }
        });
    }

    @Override
    protected  void onStart(){
        super.onStart();
        registerReceiver(arduinoReceiver, new IntentFilter(AmarinoIntent.ACTION_RECEIVED));
    }


    @Override
    protected  void onStop(){
        super.onStop();
        unregisterReceiver(arduinoReceiver);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void automate(Decepticon decepticon){
        /*
         *
         *     PLACE CODE HERE
         *
         *
         */

    }


}
