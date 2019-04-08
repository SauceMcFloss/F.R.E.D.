package UI.manualUI;

import arduinoControl.Car;
import org.junit.Test;

import static org.junit.Assert.*;

public class manualScreenControllerTest {

    @Test
    public void initialize()
    {
        manualScreenController manualScreenController = new manualScreenController();

        manualScreenController.initialize();

        assertFalse(Car.getInstance().getAutonomousMode());

        assertNotNull(manualScreenController.anchorPane);

        assertNotNull(manualScreenController.upButton);

        assertNotNull(manualScreenController.backButton);

        assertNotNull(manualScreenController.turnSlider);


    }


    @Test
    public void resetSlider()
    {
        manualScreenController manualScreenController = new manualScreenController();

        manualScreenController.initialize();

        manualScreenController.resetSlider();

        assert(manualScreenController.turnSlider.getValue() == 0.0);
    }

    @Test
    public void goForward()
    {
        assertEquals(Car.getInstance().getCarState(),Car.forwardCode);
    }

    @Test
    public void goBackward()
    {
        assertEquals(Car.getInstance().getCarState(),Car.backwardCode);
    }

    @Test
    public void setNeutral()
    {
        assertEquals(Car.getInstance().getCarState(),Car.neutralCode);
    }


}