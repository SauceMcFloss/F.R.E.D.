#ifndef StartUp_H
#define StartUp_H
int startUP();

int startUP(){
  //Initialization Functions
  LED_Setup();
  servoSetup();
  sensorSetup();
  WiFiSetup();
  serverSetup();
  //WE ARE READY!
  LED_ON();
}
#endif
