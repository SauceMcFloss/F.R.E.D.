#ifndef RunningF_H
#define RunningF_H

#include "ServoF.h"
#include "SensorF.h"

//RUNNING
int processFirst();
int processCommand(int input1); 
int printCommands(int commands);
int setThrottle(int input1);    
int setSteering(int input1);
int allStop();

//RUNNING
int processFirst()
{
  // read the bytes incoming from the client:
      char in = client.read();
      int command = -5;


 // A more straightforward way of writing this section might be:
 // #define ZERO 48
 // #define NINE 57
 //
 // if (in >= ZERO && in <= NINE)
 // (
 // do whatever you need to do
 // )
 // return 1;
 // 
 // Also, maybe change lol to convertInt or some variable that helps define it  
      if(in < 48 || in > 57)
      {
        
      }
      else
      {
        int convertInt = (int)in - 48;
        if(convertInt >=0)
        {
          command = convertInt;
        }
        if ((command > -1 && command <= 4 )|| (command == 9))
        {
          processCommand(command);
          printCommands(command);
          command = -1;
        }
      }
      return 1;
}
int processCommand(int input1)//F16
{
  if(input1 < 3)
  {
    setThrottle(input1);
  }
  else if(input1 == 3)
  {
    setSteering(input1);
  }  
  else if(input1 == 4)
  {
    server.println(sensorRead());
  }
  else if(input1 == 9)
  {
    allStop();
  }
  return 1;
}
int printCommands(int commands)//F17
{
  if (commands == 0)
  {
    server.println("Neutral");
  }
  else if (commands == 1)
  {
    server.println("Forward");
  }
  else if (commands == 2)
  {
    server.println("Reverse");
  }
  else if (commands ==3)
  {
    server.println(steeringValue);
  }
  else if(commands == 9)
  {
    server.println("9");
  }
  return 1;
}
int setThrottle(int input1)//F18
{
  if(input1 == 1)
  {
    throttleCurrent = throttleForward;
  }
  else if(input1 == 2)
  {
    throttleCurrent = throttleReverse;
  }
  else
  {
    throttleCurrent = throttleCenter;
  }
  throttleChange();
  return;
}
int setSteering(int input1){  //F19
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
  steeringValue = angle;
  steeringChange();
  return 1;
}
int allStop(){
  setThrottle(0);
  steeringValue = 90;
  steeringChange();
  return 1;
}

#endif
