package com.genius.shreyashirday.pojos;

import android.content.Context;
import android.util.Log;

import at.abraxas.amarino.Amarino;

/**
 * Created by shreyashirday on 1/4/15.
 */
public class Decepticon {

    private String deviceAddress;
    private Context ctx;

   public Decepticon(String dAddress,Context context){
       this.deviceAddress = dAddress;
       this.ctx = context;
   }

    public void goForward(){
        Amarino.sendDataToArduino(this.ctx, this.deviceAddress, 'w', 255);
    }

    public void setForward(int speed){
        speed = Math.abs(speed);
        if(speed > 255){
            speed = 255;
        }

        Amarino.sendDataToArduino(this.ctx, this.deviceAddress, 'w',speed);

    }

    public void goBackward(){
        Amarino.sendDataToArduino(this.ctx,this.deviceAddress,'s',255);
    }

    public void setBackward(int speed){
        speed = Math.abs(speed);
        if(speed > 255){
            speed = 255;
        }

        Amarino.sendDataToArduino(this.ctx,this.deviceAddress,'s',speed);
    }

    public void stop(){
        Amarino.sendDataToArduino(this.ctx,this.deviceAddress,'x',0);
    }

    public void turnLeft(){
        Amarino.sendDataToArduino(this.ctx,this.deviceAddress,'a',255);

    }

    public void setLeft(int speed){
        speed = Math.abs(speed);
        if(speed > 255){
            speed = 255;
        }

        Amarino.sendDataToArduino(this.ctx,this.deviceAddress,'a',speed);
    }

    public void turnRight(){
        Amarino.sendDataToArduino(this.ctx,this.deviceAddress,'d',255);
        Log.d("ACTION","TURNING RIGHT");
    }

    public void setRight(int speed){
        speed = Math.abs(speed);
        if(speed > 255){
            speed = 255;
        }

        Amarino.sendDataToArduino(this.ctx,this.deviceAddress,'d',speed);
    }



}
