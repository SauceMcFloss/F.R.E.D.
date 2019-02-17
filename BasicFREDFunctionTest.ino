#include <Servo.h>

int throttlePin = 9;
int throttleValue  = 0;
Servo throttleServo;
int steeringPin = 10;
int steeringValue  = 0;
Servo steeringServo;

void setup() {
  // put your setup code here, to run once:
  throttleServo.attach(throttlePin);
  steeringServo.attach(steeringPin);
  throttleServo.writeMicroseconds(1500);
  steeringServo.write(90);
  delayMicroseconds(5000);
}

void loop() {
  throttleServo.writeMicroseconds(1200);//clockwise
  delay(1000);
  throttleServo.writeMicroseconds(1500);//center
  delay(1000);
  throttleServo.writeMicroseconds(1800);//counter clockwise
  delay(1000);
  throttleServo.writeMicroseconds(1500);
  delay(1000);
  
  steeringServo.write(30);//left
  delay(1000);
  steeringServo.write(90);
  delay(1000);
  steeringServo.write(160);//right
  delay(1000);
  steeringServo.write(90);
  delay(1000);
}
