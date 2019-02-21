//Code Is For Checking The Functionality Of The Car With An Arduino.
//1. Match Wiring Diagram 
//2. Upload Code To Arduino Uno R3
//3. Start Up Power For Car 
//4. Observe Car Should Move Forward Back Left And Right

#include <Servo.h>

int throttlePin = 9;
int steeringPin = 10;

int throttleValue  = 0;
int steeringValue  = 0;

Servo throttleServo;
Servo steeringServo;

int throttleReverse = 1200;
int throttleCenter = 1500;
int throttleForward = 1800;
int throttleCurrent = throttleCenter;

int steeringLeft = 30;
int steeringCenter = 90;
int steeringRight = 180;
int steeringCurrent = steeringCenter;

int delayFive = 5000;
int delayOne = 1000;

void setup() {
  // put your setup code here, to run once:
  throttleServo.attach(throttlePin);
  steeringServo.attach(steeringPin);
  throttleServo.writeMicroseconds(throttleCurrent);
  steeringServo.write(steeringCurrent);
  delayMicroseconds(delayFive);
}

void loop() {
  throttleServo.writeMicroseconds(throttleReverse);//Reverse
  delay(delayOne);
  throttleServo.writeMicroseconds(throttleCenter);//center
  delay(delayOne);
  throttleServo.writeMicroseconds(throttleForward);//Forward
  delay(delayOne);
  throttleServo.writeMicroseconds(throttleCenter);
  delay(delayOne);
  
  steeringServo.write(steeringLeft);//left
  delay(delayOne);
  steeringServo.write(steeringCenter);
  delay(delayOne);
  steeringServo.write(steeringRight);//right
  delay(delayOne);
  steeringServo.write(steeringCenter);
  delay(delayOne);
}
