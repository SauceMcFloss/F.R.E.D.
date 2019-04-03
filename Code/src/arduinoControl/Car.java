package arduinoControl;

import Network.networkUtility;
import logs.Logger;


//This class is responsible for wrapping up all of the
//macros needed to control to the car into discrete
//methods that can be called directly through the UI.
//It is a singleton class since we will only ever be
//controlling one car at a time.
public class Car
{
    private static Car car;

    private static final String neutralCode = "0";
    private static final String forwardCode = "1";
    private static final String backwardCode = "2";
    private static final String distanceCode = "4";

    public static volatile int distanceToSign;


    //Since the car cannot switch immediately from forward to backward
    //or vice versa before stopping, we need to create a timer thread to
    //wait for a stop so the command can be sent. These will be the flags
    //to tell when we can send a command to the server.
    private static volatile boolean canMoveBack = true;
    private static volatile boolean canMoveForward = true;

    private static volatile boolean trackDistance = false;


    private Car() {}

    public static Car getInstance()
    {

        if(car == null)
        {
            car = new Car();
        }

        return car;
    }


    //Samples distance at 500Hz and stores it inside 'distanceToSign'
    public void startDistanceTracking()
    {
        trackDistance = true;

        new Thread(() -> {

            while(trackDistance)
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String distance = networkUtility.getInstance().sendCommand(distanceCode);
                Logger.getInstance().logMessage("[Server] -> " + distance + " cm");

                distanceToSign = Integer.valueOf(distance);
            }



        }).start();
    }

    public void stopDistanceTracking()
    {
        trackDistance = false;
    }


    //Moves car forward indefinitely at the preset speed while checking
    //to make sure we don't bind gears by switching too fast
    public void moveCarForward()
    {
        lockBackward();

        while(!canMoveForward){}

        Logger.getInstance().logMessage("[Server] -> " + networkUtility.getInstance().sendCommand(forwardCode));
    }

    //Moves the car backward indefinitely at the preset speed while checking
    //to make sure we don't bind gears by switching too fast
    public void moveCarBackward()
    {
        lockForward();

        while(!canMoveBack){}

        Logger.getInstance().logMessage("[Server] -> " + networkUtility.getInstance().sendCommand(backwardCode));
    }

    //This sets the motor to neutral which will be our stopping
    //mechanism. This also means that stopping takes whatever time
    //is required for friction to stop the motion.
    public void setCarNeutral()
    {
        Logger.getInstance().logMessage("[Server] -> " + networkUtility.getInstance().sendCommand(neutralCode));
    }


    //This will attempt to turn the wheels right if direction is 1
    //and left if direction is 0. 'angle' is an integer value from 0
    //to 50 specifying how far to turn, 50 being a full turn.
    public void turnCar(String direction, String angle)
    {
        Logger.getInstance().logMessage("[Server] -> " + networkUtility.getInstance().sendCommand("3" + direction + angle));
    }

    //We need to wait for the car to stop moving forward
    //before we can move backward to prevent binding. To
    //solve that, we found the stopping time and force the
    //control methods to wait until this lock is finished
    private void lockBackward()
    {
        new Thread(() -> {

            canMoveBack = false;

            try {
                for(int i=0; i<4; i++)
                {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            canMoveBack = true;

        }).start();
    }


    //This is the same as locking backward except for forward.
    //Because reverse is slower than forward, we don't have to wait
    //as long for the car to come to a stop and as a result we can
    //lock for less time here.
    private void lockForward()
    {
        new Thread(() -> {

            canMoveForward = false;

            try {
                for(int i=0; i<3; i++)
                {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            canMoveForward = true;

        }).start();
    }


}
