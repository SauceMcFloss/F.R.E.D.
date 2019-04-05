package UI;


import NeuralNetwork.TrafficSignDetectFX;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import logs.Logger;


public class mainScreenController
{
    @FXML
    TextArea Console;

    @FXML
    ImageView imageView;

    public void initialize()
    {
        initializeConsole();
        initializeAutoScroll();
        startClassifier();
    }


    private void startClassifier()
    {
        TrafficSignDetectFX classifier = new TrafficSignDetectFX();
        classifier.setDisplay(imageView);
    }


    private void initializeConsole()
    {


        Console.textProperty().bindBidirectional(Logger.getInstance().getObservableMasterLog());
        Logger.getInstance().logMessage("Setting up logger...");
        Logger.getInstance().logMessage("Logger initialized");

    }


    private void initializeAutoScroll()
    {
        Logger.getInstance().getObservableMasterLog().addListener((observable, oldValue, newValue) -> {
            try
            {
                Console.selectPositionCaret(Console.getLength());
                Console.deselect();
            }catch (IndexOutOfBoundsException e) {}

        });

    }



}
