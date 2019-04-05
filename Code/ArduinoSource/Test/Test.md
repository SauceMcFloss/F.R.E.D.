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

|Step     |Action |Observation |
| --- | ------------------------------------------------------------------------------| -----------------------------------------|
| 1. | Connect the Arduino Uno Wifi Rev 2 into the PC via a USB port | The Arduino Uno's green LED should light up, and the computer should register that the Arduino Uno has been connected as a USB message. |
| 2. | Open up the Arduino IDE | The Arduino IDE should pop up on the screen.| 
| 3. | Open WifiTest.ino in the Arduino IDE| The WifiTest.ino should display itself in the Arduino IDE.|
| 4. | Open the secret.h in the Arduino IDE| The secret.h file should display itself in the Arduino IDE.|
| 5. | Edit the secret.h file, replacing the asterisks for SECRET_SSID with the name of the WPA2 Security Wifi Network of choice.| The line should read "#define SECRET_SSID 'NetworkNameOfChoice'" |
| 6. | Further edit the secret.h file, replacing the asterisks for SECRET_PASS with the password of the unencrypted Security Wifi Network of choice.| The line should read "#define SECRET_PASS 'NetworkNamePassword'" |
| 7. | Go to Tools and open Serial Monitor | A blank pop-up should appear on the screen.
| 8. | Go to Tools and mouse over Board| Board should be specifically named
| 9. | Go to Tools and mouse over Port | The Port should be specifically named after the port that it is 
| 10. | Click on the Upload button in the Arduino IDE to upload to board | The Serial Monitor should print "Attempting to connect to WPA SSID" |
| 11. | The print out should continuously reveal that the Arduino is attempting to connect | Every ten seconds the screen will print out "Attempting to connect to WPA SSID"
| 12. | The wifi should connect after some period of time. | Once connected, the serial monitor should display "You're connected to the networkSSID: 'NetworkNameOfChoice'|


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

