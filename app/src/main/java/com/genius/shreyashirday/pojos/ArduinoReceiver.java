package com.genius.shreyashirday.pojos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import at.abraxas.amarino.AmarinoIntent;

/**
 * Created by shreyashirday on 1/4/15.
 */
public class ArduinoReceiver extends BroadcastReceiver {

    public int sonarData;

    @Override
    public void onReceive(Context context, Intent intent) {
        String dataString = null;
        int data = 0;
        final int dataType = intent.getIntExtra(AmarinoIntent.EXTRA_DATA_TYPE,-1);

        if(dataType == AmarinoIntent.STRING_EXTRA){
            try{
                data = Integer.parseInt(intent.getStringExtra(AmarinoIntent.EXTRA_DATA));
                sonarData = data;
            }
            catch (NumberFormatException e){
                Log.e("ERROR",e.getMessage());
                sonarData = -1;
            }
        }



    }

    public int getSonarData(){
        return sonarData;
    }
}
