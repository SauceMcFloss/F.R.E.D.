//#include <SPI.h>
#include <WiFiNINA.h>
#include <Server.h> 
#include <Servo.h>

//Wifi info
#include "secret.h" 

//Function Prototypes
void servoSetup();
void initSerial();
void checkForWIFI();
void checkFirmware();
void attemptConnection();
void WIFISuccessful();
void serialEvent();
void printWifiData();
void printCurrentNet();
void printMacAddress(byte mac[]);
void startServer();
void clientConnect();
void newClient();
void clientConnected();
void processFirst();
void printCommands(int commands);
void setThrottle(int input1);
void setSteering(int input1);

/////////////////////////////////
//Wifi Information
char ssid[] = SECRET_SSID;
char pass[] = SECRET_PASS;
const int port = SECRET_PORT;
WiFiClient client;
WiFiServer server(port);
int status = WL_IDLE_STATUS;

String inputString = "";
boolean stringComplete = false;

boolean alreadyConnected = false;
int command = 0;

Servo throttleServo;
Servo steeringServo;
int throttlePin = 10;
int steeringPin = 11;
int throttleReverse = 1200;
int throttleCenter = 1500;
int throttleForward = 1800;
int steeringLeft = 30;
int steeringCenter = 90;
int steeringRight = 180;
int steeringCurrent = steeringCenter;
int delayFive = 5000;

void setup() 
{
  servoSetup();
  
  initSerial();
  
  checkForWIFI();

  checkFirmware();

  attemptConnection();

  server.begin();

  WIFISuccessful();

  Serial.println("Server Starting");

  throttleServo.writeMicroseconds(1200);//clockwise
  delay(1000);
  throttleServo.writeMicroseconds(1500);//center
  delay(1000);
  throttleServo.writeMicroseconds(1800);//counter clockwise
  delay(1000);
  throttleServo.writeMicroseconds(1500);
  delay(1000);

}

void loop() 
{
  startServer();
}







void servoSetup()
{
  throttleServo.attach(throttlePin);
  steeringServo.attach(steeringPin);
  throttleServo.writeMicroseconds(throttleCenter);
  steeringServo.write(steeringCurrent);
  delayMicroseconds(delayFive);  
}

void initSerial()
{
  //Initialize serial and wait for port to open:
  Serial.begin(9600);
  while (!Serial) {;}   
  inputString.reserve(1000);
}

void checkForWIFI()
{
  if (WiFi.status() == WL_NO_MODULE) 
  {
    Serial.println("Communication with WiFi module failed!");
    // don't continue
    while (true);
  }
}

void checkFirmware()
{
  String fv = WiFi.firmwareVersion();
  if (fv < "1.0.0") 
  {
    Serial.println("Please upgrade the firmware");
  }
}

void attemptConnection()
{
  // attempt to connect to Wifi network:
  while (status != WL_CONNECTED) 
  {
    Serial.print("Attempting to connect to WPA SSID: ");
    Serial.println(ssid);
    // Connect to WPA/WPA2 network:
    status = WiFi.begin(ssid, pass);
    // wait 10 seconds for connection:
    delay(10000);
  }
}

void WIFISuccessful()
{
  // you're connected now, so print out the data:
  Serial.print("You're connected to the network");
  printCurrentNet();
  printWifiData();
}

void serialEvent() 
{
  while (Serial.available()) {
    // get the new byte:
    char inChar = (char)Serial.read();
    // add it to the inputString:
    inputString += inChar;
    // if the incoming character is a newline, set a flag so the main loop can
    // do something about it:
    if (inChar == '\n') {
      stringComplete = true;
    }
    Serial.println(inputString);
    inputString = "";
    stringComplete = false;
  }
}

void printWifiData() 
{
  // print your board's IP address:
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);
  Serial.println(ip);

  // print your MAC address:
  byte mac[6];
  WiFi.macAddress(mac);
  Serial.print("MAC address: ");
  printMacAddress(mac);
}



void printCurrentNet() {
  // print the SSID of the network you're attached to:
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print the MAC address of the router you're attached to:
  byte bssid[6];
  WiFi.BSSID(bssid);
  Serial.print("BSSID: ");
  printMacAddress(bssid);

  // print the received signal strength:
  long rssi = WiFi.RSSI();
  Serial.print("signal strength (RSSI):");
  Serial.println(rssi);

  // print the encryption type:
  byte encryption = WiFi.encryptionType();
  Serial.print("Encryption Type:");
  Serial.println(encryption, HEX);
  Serial.println();
}

void printMacAddress(byte mac[]) {
  for (int i = 5; i >= 0; i--) {
    if (mac[i] < 16) {
      Serial.print("0");
    }
    Serial.print(mac[i], HEX);
    if (i > 0) {
      Serial.print(":");
    }
  }
  Serial.println();
}

void startServer(){
  // wait for a new client:
  client = server.available();

  clientConnected();
}

void clientConnect(){
  // when the client sends the first byte, say hello:
  if (client) 
  {
    newClient();

    while (client.connected()) 
    {
      clientConnected();
    }
  }
  return;
}

void newClient(){
  if (!alreadyConnected) 
    {
      // clead out the input buffer:
      client.flush();
      Serial.println("We have a new client");
      //client.println("Hello, client!");
      alreadyConnected = true;
    }
    return;
}

void clientConnected(){
  if (client) 
  {
    newClient();
    
    if (client.available() > 0) 
    {
      processFirst();
    }
  }
}

void processFirst(){
  // read the bytes incoming from the client:
      char in = client.read();
      if(in < 48 || in > 57)
      {
        
      }
      else
      {
        int lol = (int)in - 48;
        if(lol >=0)
        {
          command = lol;
        }
        if (command > -1 && command < 4)
        {
          printCommands(command);
          processCommand(command);
          command = -1;
        }
      }
      return;
}

void processCommand(int input1){
  if(input1 < 3)
  {
    setThrottle(input1);
  }
  else if(input1 == 3)
  {
    setSteering(input1);
  }
  return;
}

void printCommands(int commands){
  if (commands == 0)
  {
    server.println("Neutral");
    Serial.println("Neutral");
  }
  else if (commands == 1)
  {
    server.println("Forward");
    Serial.println("Forward");
  }
  else if (commands == 2)
  {
    server.println("Reverse");
    Serial.println("Reverse");
  }
  else if (commands ==3)
  {
    server.println("Turning");
    Serial.println("Turning");
  }
  return;
}

void setThrottle(int input1){
  if(input1 == 1)
  {
    throttleServo.writeMicroseconds(1800);
  }
  else
  {
    throttleServo.writeMicroseconds(1500);//center
  }
  return;
}
void setSteering(int input1){
  int leftRight = -1;
  int tens = -1;
  int ones = -1;
  int angle = 0;
  int lol;
  while (leftRight < 0 || leftRight > 1)
  {
    char in = client.read();
    if(in < 48 || in > 57)
    {
  
    }
    else
    {
      lol = (int)in - 48;
    }
    if(lol >=0)
    {
      leftRight = lol;
    }
  }
  while (tens < 0 || tens > 9)
  {
    char in = client.read();
    if(in < 48 || in > 57)
    {
  
    }
    else
    {
      lol = (int)in - 48;
    }
    if(lol >=0)
    {
      tens = lol;
    }
  }
  while (ones < 0 || ones > 9)
  {
    char in = client.read();
    if(in < 48 || in > 57)
    {
  
    }
    else
    {
      lol = (int)in - 48;
    }
    if(lol >=0)
    {
      ones = lol;
    }
  }
  angle = (10*tens)+ones;
  if (angle > 90)
  {
    angle = 90;
  }
  if(leftRight == 0)
  {
    angle = 90 - angle;
  }
  else if(leftRight == 1)
  {
    angle = 90 + angle;
  }
  steeringServo.write(angle);
  Serial.println(angle);
}
