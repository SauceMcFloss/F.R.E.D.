//Servo Test
//HardWare: Arduino Uno Wifi Rev 2,  
//Serial Connection Required Run Serial Test Prior To This Test
//Wire Servos For the car and power car before use

#include "PrintsF.h"
#include "SerialF.h"
#include "ServoF.h"

void setup() 
{
  initSerial();
  servoSetup();
  steeringSetup();
  throttleSetup();
  Hello();
}

void loop() 
{
  Forward();
  throttleCurrent = throttleForward;
  throttleChange();
  delay(1000);

  Neutral();
  throttleCurrent = throttleCenter;
  throttleChange();
  delay(1000);

  Reverse();
  throttleCurrent = throttleReverse;
  throttleChange();
  delay(1000);
  
  Neutral();
  throttleCurrent = throttleForward;
  throttleChange();
  delay(1000);

  Left();
  steeringValue = 30;
  steeringChange();
  delay(1000);

  Right();
  steeringValue = 160;
  steeringChange();
  delay(1000);

  Center();
  steeringValue = 90;
  steeringChange();
  delay(1000);
}
