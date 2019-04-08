#ifndef ServoF_H
#define SevoF_H

//SERVO
int servoSetup();         //F3
int steeringSetup();      //F4
int throttleSetup();      //F5
int throttleChange();     //F6
int steeringChange();     //F7

////SERVO FUNCTIONS
int servoSetup()//F3
{
  steeringSetup();
  throttleSetup();
  return 1;
}
int steeringSetup()//F4
{
  steeringServo.attach(steeringPin);
  steeringServo.write(steeringValue);
  return 1;
}
int throttleSetup()//F5
{
  throttleServo.attach(throttlePin);
  throttleServo.writeMicroseconds(throttleCurrent);
  return 1;
}
int throttleChange()//F6
{
  throttleServo.writeMicroseconds(throttleCurrent);
  return 1;
}
int steeringChange()//F7
{
  steeringServo.write(steeringValue);
  //server.println(steeringValue);
  return 1;
}

#endif
