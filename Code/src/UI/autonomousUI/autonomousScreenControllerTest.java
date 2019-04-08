package UI.autonomousUI;

import arduinoControl.Car;
import com.jfoenix.controls.JFXToggleButton;
import org.junit.Test;

import static org.junit.Assert.*;

public class autonomousScreenControllerTest {

    @Test
    public void toggleAutonomousMode(JFXToggleButton starter)
    {
        if(starter.isSelected())
        {
            assertTrue(Car.getInstance().getAutonomousMode());
        }
        else if(!starter.isSelected())
        {
            assertFalse(Car.getInstance().getAutonomousMode());
        }
    }
}