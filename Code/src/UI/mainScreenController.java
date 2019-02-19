package UI;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class mainScreenController
{
    @FXML
    TextArea debugConsole;

    public void initialize()
    {


    }

    //Define function to be able to set a debug message
    //to the console from anywhere in the program
    public void addConsoleMessage(String message)
    {
        if(debugConsole.getText().isEmpty())
        {
            debugConsole.setText("-> " + message);
        }
        else
        {
            debugConsole.setText(debugConsole.getText().concat("\n\n-> ").concat(message));
        }
    }




}
