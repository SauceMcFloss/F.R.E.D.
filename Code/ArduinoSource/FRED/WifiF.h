#ifndef WifiF_H
#define WifiF_H


//WiFi
int WiFiSetup();          //F8
int checkForWIFI();       //F9
int attemptConnection();  //F10

//WiFi FUNCTIONS
int WiFiSetup()//F8
{
  checkForWIFI();
  attemptConnection();
  return 1;
}
int checkForWIFI()//F9
{
  if (WiFi.status() == WL_NO_MODULE) 
  {
    while (true);
  }
  return 1;
}
int attemptConnection()//F10
{
  while (status != WL_CONNECTED) 
  {
    status = WiFi.begin(ssid, pass);
    delay(5000);
  }
  return 1;
}

#endif
