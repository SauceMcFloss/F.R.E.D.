//Serial Test
//HardWare: Arduino Uno Wifi Rev 2 
//Serial Connection Required Run Serial Test Prior To This Test
//Echos Serial Inputs return 1 letter at a time

#include "SerialF.h"

void setup()
{
  initSerial();
  Serial.println("Hello");
}

void loop()
{
  serialEvent();
}
