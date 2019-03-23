import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class TrafficSignDetect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton btnPlay = new JButton("Play");
	private final JButton btnPause = new JButton("Pause");

	private DaemonThread myThread = null;
	VideoCapture webSource = null;
	Mat frame = new Mat();
	MatOfByte mem = new MatOfByte();
	CascadeClassifier signDetect = new CascadeClassifier("Classifier/stopsign_classifier.xml");
	MatOfRect signDetections = new MatOfRect();

	/**
	 * Create the frame.
	 */
	public TrafficSignDetect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 930);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 749, 500);
		panel.setLayout(null);
		contentPane.add(panel);

		// Play button event
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				webSource = new VideoCapture(0); // video capture from default
													// camera
				myThread = new DaemonThread(); // create object of thread class
				Thread t = new Thread(myThread);
				t.setDaemon(true);
				myThread.runnable = true;
				t.start(); // start thread
				btnPlay.setEnabled(false); // deactivate start button
				btnPause.setEnabled(true); // activate stop button
			}
		});
		btnPlay.setBounds(180, 800, 120, 31);
		contentPane.add(btnPlay);

		// Pause button event
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myThread.runnable = false; // stop thread
				btnPause.setEnabled(false); // activate start button
				btnPlay.setEnabled(true); // deactivate stop button

				webSource.release(); // stop capturing from camera
			}
		});
		btnPause.setBounds(680, 800, 120, 31);
		contentPane.add(btnPause);
	}

	/**
	 * 
	 * Starts Camera and process frames
	 */
	class DaemonThread implements Runnable {
		protected volatile boolean runnable = false;

		public void run() {
			synchronized (this) {
				while (runnable) {
					if (webSource.grab()) {
						try {
							webSource.retrieve(frame);
							Graphics g = contentPane.getGraphics();
							signDetect.detectMultiScale(frame, signDetections, 1.1, 3, 0, new Size(20, 20), new Size());
							for (Rect rect : signDetections.toArray()) {
								Imgproc.rectangle(frame, rect.tl(), rect.br(), new Scalar(0, 255, 0));
								////////////////Add in stop signal to car//////////////////
							}
							Imgcodecs.imencode(".bmp", frame, mem);
							Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
							BufferedImage buff = (BufferedImage) im;
							if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(),
									buff.getHeight(), null)) {
								if (runnable == false) {
									System.out.println("Paused ..... ");
									this.wait();
								}
							}
						} catch (Exception ex) {
							System.out.println("Error");
						}
					}
				}
			}
		}
	}

}