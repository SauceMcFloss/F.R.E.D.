#ifndef ServerF_H
#define ServerF_H
//Server
int serverSetup();        //F11
int startServer();        //F12
int clientConnected();    //F13
int newClient();          //F14
//SERVER FUNCTIONS
int serverSetup()//F11
{
  server.begin();
  return 1;
}
int startServer()//F12
{
  // wait for a new client:
  client = server.available();
  clientConnected();
  return 1;
}
int clientConnected()//F13
{
  if (client) 
  {
    newClient();
    
    while (client.available() > 0) 
    {
      processFirst();
    }
  }
  return 1;
}
int newClient()//F14
{
  if (!alreadyConnected) 
  {
    // clead out the input buffer:
    client.flush();
    alreadyConnected = true;
  }
    return 1;
}
#endif
