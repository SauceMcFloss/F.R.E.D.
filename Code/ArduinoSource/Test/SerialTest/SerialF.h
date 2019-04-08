#ifndef SerialF_H
#define SeerialF_H
void initSerial();
void serialEvent();

String inputString = "";
boolean stringComplete = false;

void initSerial()
{
  //Initialize serial and wait for port to open:
  Serial.begin(9600);
  while (!Serial) {;}   
  inputString.reserve(1000);
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
#endif
