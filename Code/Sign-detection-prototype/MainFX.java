import java.awt.EventQueue;
import java.io.ByteArrayInputStream;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFX extends Application{
	
	@Override
	public void start(Stage primaryStage) {

			primaryStage.setHeight(500);
			primaryStage.setWidth(500);
			
			BorderPane root = new BorderPane();
			ImageView test = new ImageView();
			
			root.setCenter(test);
			
			TrafficSignDetectFX tsdfx = new TrafficSignDetectFX();
			tsdfx.setDisplay(test);
			
			
		
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		
	}

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		
		
		launch(args);
		
	}
	
	
	
}