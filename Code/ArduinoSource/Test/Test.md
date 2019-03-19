# Basic Test Codes And Functionality
# Arduino Tests

## BasicFREDFunctionTest.ino
* This Function Is A Loop Which You Upload To An Arduino To Ensure Wiring Is Correct And That Car Is Functioning.

## WifiTest.ino //Requires Arduino IDE
* With Arduino Uno Wifi Rev 2 plugged In to pc
* Open WifiTest.ino
* Attatch The secret.h File
* Upload To Board
* Open Serial Monitor
* Print Out Should Attempt To Connect Then Print The WiFi Information

## ServerTest.ino //Requires Arduino IDE and Putty
**Do Not Run Before WifiTest.ino
* With Arduino Uno Wifi Rev 2 plugged In to pc
* Open WifiTest.ino
* Attatch The secret.h File
* Upload To Board
* Open Serial Monitor
* Print Out Should Attempt To Connect Then Print The WiFi Information
* Open Putty
** Use Telnet Connection With the IP ad Host Name and Port Number From secret.h
* send one character and the system responds with Hello _ <- the character you typed
* send Multiple Characters And Server Responds with Hello _ Hello_ Hello_

