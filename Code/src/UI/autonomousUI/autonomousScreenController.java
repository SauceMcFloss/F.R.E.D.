package UI.autonomousUI;

import NeuralNetwork.TrafficSignDetectFX;
import arduinoControl.Car;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;

public class autonomousScreenController
{

    @FXML
    JFXToggleButton toggleButton;

    public void initialize()
    {

    }

    private void Stop()
    {

    }

    public void toggleAutonomousMode()
    {

        if(toggleButton.isSelected())
        {
        	Car.getInstance().setAutonomousMode(true);
            Car.getInstance().moveCarForward();
        }
        else
        {
        	Car.getInstance().setAutonomousMode(false);
            Car.getInstance().setCarNeutral();
        }

    }
}
