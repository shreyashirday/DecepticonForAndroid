#include <MeetAndroid.h>


#define LEFTSIDE_NEG   9
#define LEFTSIDE_POS   10
#define RIGHTSIDE_NEG  5
#define RIGHTSIDE_POS  6
#define TRIGGER_PIN    12
#define ECHO_PIN       11



MeetAndroid meetAndroid;


void setup(){
 
 Serial.begin(9600); 
 
 meetAndroid.registerFunction(forward, 'w');
 meetAndroid.registerFunction(backward, 's');
 meetAndroid.registerFunction(leftTurn, 'a');
 meetAndroid.registerFunction(rightTurn, 'd');
 meetAndroid.registerFunction(stopIt, 'x');

 
  pinMode(LEFTSIDE_NEG, OUTPUT);
  pinMode(LEFTSIDE_POS, OUTPUT);
  pinMode(RIGHTSIDE_NEG, OUTPUT);
  pinMode(RIGHTSIDE_POS, OUTPUT);
  
}


void loop(){

  meetAndroid.receive();
  
  getSonar();
  
  delay(100);
  
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
  analogWrite(RIGHTSIDE_NEG,meetAndroid.getInt()); 
}

void leftTurn(byte flag, byte numOfValues){
  analogWrite(LEFTSIDE_POS,0);
  analogWrite(LEFTSIDE_NEG,meetAndroid.getInt());
  analogWrite(RIGHTSIDE_POS,meetAndroid.getInt());
  analogWrite(RIGHTSIDE_NEG,0);
  Serial.print(meetAndroid.getInt());
}

void rightTurn(byte flag, byte numOfValues){
   analogWrite(LEFTSIDE_POS,meetAndroid.getInt());
   analogWrite(LEFTSIDE_NEG,0);
   analogWrite(RIGHTSIDE_POS,0);
   analogWrite(RIGHTSIDE_NEG,meetAndroid.getInt());  
}

void getSonar(){
  int duration,distance;
  
  duration = pulseIn(ECHO_PIN,HIGH);
  distance = (duration/2)/29.1;
  
  meetAndroid.send(distance);
  Serial.println(distance);
  
}




