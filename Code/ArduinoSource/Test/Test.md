# Basic Test Codes And Functionality
# Arduino Tests

### Test A000 - Testing BasicFREDFunctionTest.ino and ensuring all mechanical functionality is a go.
* The BasicFREDFunctionTest is a loop that once uploaded to the Arduino Board can be attached to the RC car. When attached to the RC Car with this function, the Arduino will loop through several of the basic functions of the car, including moving forward, backwards, and turning the wheels left and right.

| Step | Action | Observation |
| --- | ------------------------------------------------------------------------------| -----------------------------------------|
| 1. | Connect the Arduino Uno Wifi Rev 2 into the PC via a USB port | The Arduino Uno's green LED should light up, and the computer should register that the Arduino Uno has been connected as a USB message. |
| 2. | Open up the Arduino IDE | The Arduino IDE should pop up on the screen.| 
| 3. | Open BasicFREDFunctionTest.ino in the Arduino IDE | The BasicFREDFunctionTest.ino should display itself in the Arduino IDE.|
| 4. | Upload the BasicFredFunctionTest.ino to the board by pressing the Upload button.| The Arduino IDE should display that the test is now uploading the board.|
| 5. | After the test uploads to board, detach the Arduino Uno Wifi Rev 2 from the PC.| The Arduino should be disconnected from the computer.|
| 6. | Attach wires from 6 and 9 of the Arduino port to the grounds 6 and 9 within the RC car.| The Arduino should be attached securely to the car.|
| 7.| Turn on the RC car. | The car's power light should be turned on.
| 7. | Wait as the Arduino loops through its commands. | The car will now move its wheels back and forth and turn.|
| 8. | After the loop completes, power down the car. | The car should stop moving. | 

### Test A001 - Testing WifiTest.ino and ensuring the Wifi is connected. 

Note that this test requires Arduino IDE. The Serial Test should already have been completed.

| Step | Action | Observation |
| --- | ------------------------------------------------------------------------------| -----------------------------------------|
| 1. | Connect the Arduino Uno Wifi Rev 2 into the PC via a USB port | The Arduino Uno's green LED should light up, and the computer should register that the Arduino Uno has been connected as a USB message. |
| 2. | Open up the Arduino IDE | The Arduino IDE should pop up on the screen.| 
| 3. | Open WifiTest.ino in the Arduino IDE| The WifiTest.ino should display itself in the Arduino IDE.|
| 4. | Open the secret.h in the Arduino IDE| The secret.h file should display itself in the Arduino IDE.|
| 5. | Edit the secret.h file, replacing the asterisks for SECRET_SSID with the name of the WPA2 Security Wifi Network of choice.| After edited, the line should read "#define SECRET_SSID 'NetworkNameOfChoice'" |
| 6. | Further edit the secret.h file, replacing the asterisks for SECRET_PASS with the password of the unencrypted Security Wifi Network of choice.| After edited, the line should read "#define SECRET_PASS 'NetworkNamePassword'" |
| 7. | Go to Tools and open Serial Monitor | A blank pop-up should appear on the screen.
| 8. | Go to Tools and mouse over Board to check that the board is connected.| The board should be specifically named "Arduino Uno Wifi Rev 2"|
| 9. | Go to Tools and mouse over Port to check that the USB port is in use. | The port should be specifically named after the port that it is being connected to. As long as there is a port showing, the Arduino should be functional.
| 10. | Click on the Upload button in the Arduino IDE to upload to board | The Serial Monitor should print "Attempting to connect to WPA SSID" |
| 11. | The print out should continuously reveal that the Arduino is attempting to connect | Every ten seconds the screen will print out "Attempting to connect to WPA SSID"
| 12. | The wifi should connect to the Arduino board. | Once connected, the serial monitor should display "You're connected to the networkSSID: 'NetworkNameOfChoice'|

### Test A002 - Testing ServerTest.ino and ensuring the server sends back and forth.
Note that this test requires Arduino IDE and PuTTy. The Wifi Test A001 should have already been completed.

| Step | Action | Observation |
| --- | ------------------------------------------------------------------------------| -----------------------------------------|
| 1. | Ensure that the computer you will be using is on the same network as the one you will choose to connect the Arduino Board to. | The computer should successfully display that it is connected to a wifi that the Arduino can connect to.|
| 2. | Connect the Arduino Uno Wifi Rev 2 into the PC via a USB port | The Arduino Uno's green LED should light up, and the computer should register that the Arduino Uno has been connected as a USB message. |
| 3. | Open up the Arduino IDE | The Arduino IDE should pop up on the screen.| 
| 4. | Open ServerTest.ino in the Arduino IDE| The ServerTest.ino should display itself in the Arduino IDE.|
| 5. | Open the secret.h in the Arduino IDE| The secret.h file should display itself in the Arduino IDE.|
| 6. | Edit the secret.h file, replacing the asterisks for SECRET_SSID with the name of the WPA2 Security Wifi Network of choice.| After edited, the line should read "#define SECRET_SSID 'NetworkNameOfChoice'" |
| 7. | Further edit the secret.h file, replacing the asterisks for SECRET_PASS with the password of the unencrypted Security Wifi Network of choice.| After edited, the line should read "#define SECRET_PASS 'NetworkNamePassword'" |
| 8. | Go to Tools and open Serial Monitor | A blank pop-up should appear on the screen.
| 9. | Go to Tools and mouse over Board to check that the board is connected.| The board should be specifically named "Arduino Uno Wifi Rev 2"|
| 10. | Go to Tools and mouse over Port to check that the USB port is in use. | The port should be specifically named after the port that it is being connected to. As long as there is a port showing, the Arduino should be functional.
| 11. | Click on the Upload button in the Arduino IDE to upload to board | The serial monitor should print "Attempting to connect to WPA SSID" |
| 12. | The print out should continuously reveal that the Arduino is attempting to connect | Every ten seconds the screen will print out "Attempting to connect to WPA SSID"
| 12. | The wifi should connect to the Arduino board. | Once connected, the serial monitor should display the IP Address and MAC address of the server connected to as well as "You're connected to the networkSSID: 'NetworkNameOfChoice'|
| 13. | The server should begin almost immediately after the wifi connects. | The serial monitor should display "Server Starting".|
| 14. | Open the Putty application. | The PuTTY Configuration pop-up should appear on the screen. |
| 15. | Fill in the section labeled Host Name (or IP address) with the IP address listed in the Serial Monitor. | The IP Address should now be typed into the Host Name (or IP address) section.
| 16. | Fill in the section labeled Port with 80. | The number 80 should now be typed into the Port.|
| 17. | Select TelNet. | A selection dot should appear next to TelNet.|
| 18. | Click Open. | A PuTTY window should open that reads "Hello, Client!|
| 19. | Type in a single character and select enter. | The window should return "Hello \_\_", in which the underscore will be replaced with the letter typed in. |
| 20. | Type in multiple characters and select enter. | The window should return the characters vertically. |

### Test A003 - Testing SensorTest.ino and ensuring the ultrasonic sensor is functional.
Note that this test requires Arduino IDE.

| Step | Action | Observation |
| --- | ------------------------------------------------------------------------------| -----------------------------------------|
| 1. | Connect the Arduino Uno Wifi Rev 2 into the PC via a USB port | The Arduino Uno's green LED should light up, and the computer should register that the Arduino Uno has been connected as a USB message. |
| 2. | Open up the Arduino IDE | The Arduino IDE should pop up on the screen.| 
| 3. | Open SensorTest.ino in the Arduino IDE| The SensorTest.ino should display itself in the Arduino IDE.|
| 4. | Connect wires between the Arduino Board and the ultrasonic sensor as per the wiring diagram's instructions.| The wires should be secure between the board and the sensor.|
| 5. | Go to Tools and open Serial Monitor | A blank pop-up should appear on the screen.|
| 6. | Move the sensor in front of an object back and forth. |The Serial Monitor should automatically begin populating with distances from the sensor.|
| 7. | Power down the IDE, detach the Arduino board and sensor.| The computer screen should show the Arduino has been detached.|


### Test A004 - Serial Test

### Test A005 - Servos Test

### Test A006 - Process Command Test
This test requires the Serial Test to be completed first.

### Test A007 - Drive Over Wifi Test
This test requires all of the other tests to be completed.
