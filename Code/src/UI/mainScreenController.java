package UI;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import logs.Logger;


public class mainScreenController
{
    @FXML
    TextArea Console;

    public void initialize()
    {
        initializeConsole();
        initializeAutoScroll();
    }


    private void initializeConsole()
    {
        Console.textProperty().bindBidirectional(Logger.getInstance().getObservableMasterLog());
        Logger.getInstance().logMessage("Setting up logger...");
        Logger.getInstance().logMessage("Logger initialized");
    }


    private void initializeAutoScroll()
    {
        Console.textProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue)
            {
                Console.setScrollTop(Double.MIN_VALUE);
            }
        });
    }



}
