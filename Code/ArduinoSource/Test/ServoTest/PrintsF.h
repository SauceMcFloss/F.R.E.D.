#ifndef SerialF_H
#define SeerialF_H
  int Hello(){
    Serial.println("Hello");
    return 1;
  }
  int Forward(){
    Serial.println("Throttle Forward");
    return 1;
  }
  int Reverse(){
    Serial.println("Throttle Reverse");
    return 1;
  }
  int Neutral(){
    Serial.println("Throttle Neutrual");
    return 1;
  }
  int Left(){
    Serial.println("Steering Left");
    return 1;
  }
  int Right(){
    Serial.println("Steering Right");
    return 1;
  }
  int Center(){
    Serial.println("Steering Center");
    return 1;
  }
#endif
