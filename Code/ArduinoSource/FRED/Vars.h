#ifndef Vars_H
#define Vars_H
//Pin Numbers
int throttlePin = 6;//BLUE WIRE 3/28/19
int steeringPin = 9;//Orange Wire 3/29/19

//Servo
int throttleValue  = 0;
int steeringValue  = 90; //90 Is Center
int throttleReverse = 1350;
int throttleCenter = 1500;
int throttleForward = 1580;
int throttleCurrent = throttleCenter;

//Wifi Information
char ssid[] = SECRET_SSID;
char pass[] = SECRET_PASS;
const int port = SECRET_PORT;
WiFiClient client;
WiFiServer server(port);
int status = WL_IDLE_STATUS;

boolean alreadyConnected = false;

//Classes
Servo throttleServo;
Servo steeringServo;

int trigPin = 11;    // Trigger
int echoPin = 12;    // Echo
long duration, cm, inches;


#endif
