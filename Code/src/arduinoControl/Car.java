package arduinoControl;

import Network.networkUtility;


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

    private static boolean canMoveBack = true;
    private static boolean canMoveForward = true;

    private Car() {}

    public static Car getInstance()
    {
        if(car == null)
        {
            car = new Car();
        }

        return car;
    }


    //Moves car forward indefinitely at the preset speed
    public void moveCarForward()
    {
        while (!canMoveForward){}

        System.out.println(networkUtility.getInstance().sendCommand(forwardCode));
    }

    //Moves the car backward indefinitely at the preset speed
    public void moveCarBackward()
    {

        System.out.println(networkUtility.getInstance().sendCommand(backwardCode));
    }

    //This sets the motor to neutral which will be our stopping
    //mechanism. This also means that stopping takes whatever time
    //is required for friction to stop the motion.
    public void setCarNeutral()
    {
        System.out.println(networkUtility.getInstance().sendCommand(neutralCode));
    }


    //This will attempt to turn the wheels right if direction is 1
    //and left if direction is 0. 'angle' is an integer value from 0
    //to 50 specifying how far to turn, 50 being a full turn.
    public void turnCar(int direction, int angle)
    {
        System.out.println(networkUtility.getInstance().sendCommand("3" + direction + angle));
    }

    private void waitForForwardStop()
    {
        new Thread(() -> {


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            canMoveForward = true;

        }).start();
    }


}
