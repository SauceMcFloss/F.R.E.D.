package UI.manualUI;

import arduinoControl.Car;
import com.jfoenix.controls.JFXSlider;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logs.Logger;

public class manualScreenController
{

    @FXML
    AnchorPane anchorPane;

    @FXML
    Button upButton, backButton;

    @FXML
    JFXSlider turnSlider;




    public void initialize()
    {
        Platform.runLater(this::createListener);
    }


    //Whenever we drag the steering slider to a non 0 position we
    //want it to snap back to 0 after the user releases the mouse.
    //This method is bound to a onMouseReleased listener in manualScreen.fxml
    void resetSlider()
    {
        if(turnSlider.getValue() != 0.0)
        {
            turnSlider.setValue(0.0);
        }
    }

    public void turn()
    {
        int raw = (int)turnSlider.getValue();
        String direction = raw > 0 ? "1" : "0";
        String angle = String.valueOf(Math.abs(raw));

        Car.getInstance().turnCar(direction,angle);
    }

    public void goForward()
    {
        //Here we need to check the state of the car to prevent redundant commands
        if(Car.getInstance().getCarState().compareTo(Car.forwardCode) != 0)
        {
            Car.getInstance().moveCarForward();
        }
    }

    public void goBackward()
    {
        //Here we need to check the state of the car to prevent redundant commands
        if(Car.getInstance().getCarState().compareTo(Car.backwardCode) != 0)
        {
            Car.getInstance().moveCarBackward();
        }

    }

    public void setNeutral()
    {
        if(Car.getInstance().getCarState().compareTo(Car.neutralCode) != 0)
        {
            Car.getInstance().setCarNeutral();
        }

    }


    public void turnRight()
    {
        Car.getInstance().turnCar("1","90");
    }

    public void turnLeft()
    {
        Car.getInstance().turnCar("0","90");
    }

    public void resetTurn()
    {
        Car.getInstance().turnCar("0","0");
    }


    //Initialize key listeners and bind keys to proper control methods.
    private void createListener()
    {
        Scene scene = anchorPane.getScene();

        if(scene == null)
        {
            Logger.getInstance().logErrorMessage("Failed to bind keys: null scene");
            return;
        }

        //Key pressed listener
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W: goForward(); break; //Forward
                case A: turnLeft(); break;   //Left
                case S: goBackward(); break;   //Backward
                case D: turnRight(); break;   //Right
                case R: resetTurn(); break;   //Center steering
                case E:  break;   //Right-Forward
                case Q:  break;   //Left-Forward
                case Z:  break;   //Left-Backward
                case C:  break;   //Right-Backward
            }
        });


        //Key released listener
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W: setNeutral(); break; //Forward
                case A: break;   //Left
                case S: setNeutral(); break;   //Backward
                case D: break;   //Right
                case E: setNeutral(); break;   //Right-Forward
                case Q: setNeutral(); break;   //Left-Forward
                case Z: setNeutral(); break;   //Left-Backward
                case C: setNeutral(); break;   //Right-Backward
            }
        });
    }
}
