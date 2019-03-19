package Network;

import org.junit.Test;

import static org.junit.Assert.*;

public class networkUtilityTest
{


    @Test
    public void getInstance()
    {
        assertNotNull(networkUtility.getInstance());

        //Now that we have called the class for the first time
        //we should have instantiated the class so we can make sure
        //that all the member variables are null

        assertNull(networkUtility.in);

        assertNull(networkUtility.out);

        assertNull(networkUtility.socket);
    }

    @Test
    public void testServerConnection()
    {


        assertNotNull(networkUtility.getInstance());

        //Attempt to connect to server
        networkUtility.getInstance().connectToServer();


        //Make sure after we connect to the server that
        //both of the input streams as well as the
        //socket have been initialized
        assertNotNull(networkUtility.socket);

        assertNotNull(networkUtility.out);

        assertNotNull(networkUtility.in);

    }

    @Test
    public void testSendCommand()
    {
        assertNotNull(networkUtility.getInstance());

        String result = networkUtility.getInstance().sendCommand("3121");

        assertNull(result);

    }

    @Test
    public void closeServerConnection()
    {
        assertNotNull(networkUtility.getInstance());

        networkUtility.getInstance().closeServerConnection();

        assertNull(networkUtility.socket);

        assertNull(networkUtility.in);

        assertNull(networkUtility.out);

    }
}