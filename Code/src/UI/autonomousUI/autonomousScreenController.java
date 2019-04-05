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

    private void startStop()
    {

    }

    public void toggleAutonomousMode()
    {

        if(toggleButton.isSelected())
        {
            Car.getInstance().moveCarForward();

            while(toggleButton.isSelected())
            {
                if(TrafficSignDetectFX.signFound)
                {
                    Car.getInstance().setCarNeutral();
                }

            }
        }
        else
        {
            Car.getInstance().setCarNeutral();
        }

    }
}
