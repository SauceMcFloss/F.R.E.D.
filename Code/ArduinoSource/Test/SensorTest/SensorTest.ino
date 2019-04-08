//Sensor Test
//HardWare: Arduino Uno Wifi Rev 2, HC-SR04,  
//Serial Connection Required Run Serial Test Prior To This Test
//Wire Board and sensor same as wiring from diagram
//
#include "SensorF.h"
#include "SerialF.h"

void setup()
{
  initSerial();
  sensorSetup(); 
}

void loop()
{
  Serial.println(sensorRead());
  delay(2000);
}
