
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;


public class ScreenCapture {
	public ScreenCapture() {
		capture();
	}

	public void capture() {
		try {
			Robot robot = new Robot();
			String format = "jpg";
			String fileName = "FullScreenshot." + format;

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, format, new File(fileName));

			System.out.println("A full screenshot saved!");

		} catch (AWTException | IOException ex) {
			System.err.println(ex);
		}
	}
}