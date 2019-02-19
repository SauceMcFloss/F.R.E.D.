package Main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class main extends Application
{


    @Override
    public void start(Stage primaryStage) throws IOException
    {
        primaryStage.setTitle("Group 12 Project");

        Parent root = FXMLLoader.load(getClass().getResource("/UI/mainScreen.fxml"));
        Scene scene = new Scene(root);


        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
