#ifndef LED_H
#define LED_H
//LED
int LED_Setup();
int LED_ON();   

////LED FUNCTIONS
int LED_Setup()
{
  pinMode(LED_BUILTIN, OUTPUT);
  return 1;
}
int LED_ON()
{
  digitalWrite(LED_BUILTIN, HIGH);
  return 1;
}
#endif
