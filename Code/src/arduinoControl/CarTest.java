package arduinoControl;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void getInstance()
    {
        assertNotNull(Car.getInstance());
    }

    @Test
    public void shutDownCar()
    {
        assertEquals(Car.getInstance().getCarState(),Car.endCode);
    }

    @Test
    public void getCarState()
    {
        assertFalse(Car.getInstance().getCarState().isEmpty());
    }

    @Test
    public void startDistanceTracking()
    {
        assertTrue(Car.getInstance().isTrackingDistance());
    }

    @Test
    public void stopDistanceTracking()
    {
        assertFalse(Car.getInstance().isTrackingDistance());
    }

    @Test
    public void moveCarForward()
    {
        assertEquals(Car.getInstance().getCarState(),Car.forwardCode);
    }

    @Test
    public void moveCarBackward()
    {
        assertEquals(Car.getInstance().getCarState(),Car.backwardCode);
    }

    @Test
    public void setCarNeutral()
    {
        assertEquals(Car.getInstance().getCarState(),Car.neutralCode);
    }

    @Test
    public void turnCar()
    {
        assertEquals(Car.getInstance().getCarState(),Car.neutralCode);
    }
}