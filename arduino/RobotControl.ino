#include <MeetAndroid.h>

#define LEFTSIDE_NEG   9
#define LEFTSIDE_POS   10
#define RIGHTSIDE_NEG  5
#define RIGHTSIDE_POS  6

MeetAndroid meetAndroid;

void setup(){
 
 Serial.begin(9600); 
 
 meetAndroid.registerFunction(forward, 'w');
 meetAndroid.registerFunction(backward, 's');
 meetAndroid.registerFunction(stopIt, 'x');
 
  pinMode(LEFTSIDE_NEG, OUTPUT);
  pinMode(LEFTSIDE_POS, OUTPUT);
  pinMode(RIGHTSIDE_NEG, OUTPUT);
  pinMode(RIGHTSIDE_POS, OUTPUT);
  
}


void loop(){

  meetAndroid.receive();
  
}

void forward(byte flag, byte numOfValues)
{
  analogWrite(LEFTSIDE_POS, meetAndroid.getInt());
  analogWrite(RIGHTSIDE_POS,meetAndroid.getInt());
  analogWrite(LEFTSIDE_NEG,0);
  analogWrite(LEFTSIDE_NEG,0);
}

void backward(byte flag, byte numOfValues)
{
  analogWrite(LEFTSIDE_POS,0);
  analogWrite(RIGHTSIDE_POS,0);
  analogWrite(LEFTSIDE_NEG,meetAndroid.getInt());
  analogWrite(LEFTSIDE_NEG,meetAndroid.getInt()); 
}


void stopIt(byte flag, byte numOfValues)
{
  analogWrite(LEFTSIDE_POS,meetAndroid.getInt());
  analogWrite(RIGHTSIDE_POS,meetAndroid.getInt());
  analogWrite(LEFTSIDE_NEG,meetAndroid.getInt());
  analogWrite(LEFTSIDE_NEG,meetAndroid.getInt()); 
}



