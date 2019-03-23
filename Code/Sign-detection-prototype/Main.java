import java.awt.EventQueue;
import org.opencv.core.Core;

public class Main {


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafficSignDetect frame = new TrafficSignDetect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
