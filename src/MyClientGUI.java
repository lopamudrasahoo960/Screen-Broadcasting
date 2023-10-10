import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyClientGUI {
	public static boolean active = true;

	public static void main(String avg[]) throws IOException {
		MyClientGUI abc = new MyClientGUI();
	}

	public MyClientGUI() throws IOException {

		MyClient cli = new MyClient();
	}

	private void Display() throws IOException {
		BufferedImage img = ImageIO.read(new File("X:\\java\\screenRecord\\src\\FullScreenshot.jpg"));
		ImageIcon icon = new ImageIcon(img);
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(600, 600);
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
