package UI;

import Network.networkUtility;
import arduinoControl.Car;
import org.junit.Test;

import static org.junit.Assert.*;

public class mainScreenControllerTest {

    @Test
    public void initialize()
    {
        assertTrue(networkUtility.getInstance().isConnectedToServer());

        assertEquals(Car.getInstance().getState(),Car.neutralCode);
    }
}