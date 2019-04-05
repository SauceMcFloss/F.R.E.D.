//#include <SPI.h>
#include <WiFiNINA.h>
#include <Server.h> 

//Wifi info
#include "secret.h" 

//Function Prototypes
void initSerial();
void checkForWIFI();
void checkFirmware();
void attemptConnection();
void WIFISuccessful();
void serialEvent();
void printWifiData();
void printCurrentNet();
void printMacAddress(byte mac[]);
/////////////////////////////////
//Wifi Information
char ssid[] = SECRET_SSID;
char pass[] = SECRET_PASS;
const int port = SECRET_PORT;
WiFiServer server(port);
int status = WL_IDLE_STATUS;
boolean stringComplete = false;
boolean alreadyConnected = false;
String inputString = "";
String HELLO = "HELLO";


void setup() 
{
  initSerial();
  
  checkForWIFI();

  checkFirmware();

  attemptConnection();

  server.begin();

  WIFISuccessful();

  Serial.println("Server Starting");

}

void loop() 
{
  //Serial.println("Server StartUp");
  // wait for a new client:
  WiFiClient client = server.available();

  // when the client sends the first byte, say hello:
  if (client) 
  {
    if (!alreadyConnected) 
    {
      // clead out the input buffer:
      client.flush();
      Serial.println("We have a new client");
      client.println("Hello, client!");
      alreadyConnected = true;
    }

    while (client.connected()) 
    {
      if (client) 
      {
        if (!alreadyConnected)  
        {
          // clead out the input buffer:
          client.flush();
          Serial.println("We have a new client");
          //client.println("Hello, client!");
          alreadyConnected = true;
        }

        if (client.available() > 0) 
        {
          // read the bytes incoming from the client:
          char in = client.read();
          client.println(in);
        }
      }
    }
  }
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
