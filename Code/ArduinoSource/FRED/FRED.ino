//Includes
#include <WiFiNINA.h>
#include <Server.h> 
#include <Servo.h>
#include "secrets.h" 
#include "Vars.h"
#include "LED.h"
#include "WifiF.h"
#include "RunningF.h"
#include "ServerF.h"

void setup() 
{
  //Initialization Functions
  LED_Setup();
  servoSetup();
  sensorSetup();
  WiFiSetup();
  serverSetup();
  //WE ARE READY!
  LED_ON();
}

// the loop function runs over and over again forever
void loop() 
{
  startServer();
}

//Function Definitions
