package com.genius.shreyashirday.robotcontrol;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.genius.shreyashirday.pojos.Decepticon;


public class ManualOverride extends ActionBarActivity {

    private static final String DEVICE_ADDRESS = "ENTER BLUETOOTH MODULE ADDRESS HERE";

    Button forwardBtn, leftBtn, rightBtn, backwardBtn,stopBtn;
    EditText forwardValue, leftValue, rightValue,backwardValue;
    int forwardSpeed, leftSpeed, rightSpeed, backwardSpeed;



    Decepticon d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        forwardSpeed = leftSpeed = rightSpeed = backwardSpeed = 255;
        d = new Decepticon(DEVICE_ADDRESS,getApplicationContext());
        setContentView(R.layout.activity_manual_override);
        forwardBtn = (Button)findViewById(R.id.forwardB);
        leftBtn = (Button)findViewById(R.id.leftB);
        rightBtn = (Button)findViewById(R.id.rightB);
        backwardBtn = (Button)findViewById(R.id.backwardB);
        stopBtn = (Button)findViewById(R.id.stopB2);

        forwardValue = (EditText)findViewById(R.id.forwardT);
        leftValue = (EditText)findViewById(R.id.leftT);
        rightValue = (EditText)findViewById(R.id.rightT);
        backwardValue = (EditText)findViewById(R.id.backwardT);

        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String forwardString = forwardValue.getText().toString();
                if(forwardString!=null){
                    forwardSpeed = Integer.parseInt(forwardString);
                }
                d.setForward(forwardSpeed);
            }
        });

        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftString = leftValue.getText().toString();
                if(leftString!=null){
                    leftSpeed = Integer.parseInt(leftString);
                }
                d.setLeft(leftSpeed);
            }
        });

        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rightString = rightValue.getText().toString();
                if(rightString!=null){
                    rightSpeed = Integer.parseInt(rightString);
                }
                d.setRight(rightSpeed);
            }
        });

        backwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String backwardString = backwardValue.getText().toString();
                if(backwardString!=null){
                    backwardSpeed = Integer.parseInt(backwardString);
                }
                d.setBackward(backwardSpeed);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.stop();
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manual_override, menu);
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
