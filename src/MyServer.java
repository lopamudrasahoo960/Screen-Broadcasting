import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.imageio.ImageIO;

public class MyServer {

	private final static int port = 9999;

	public static void main(String[] args) throws Exception {

		BufferedImage img = ImageIO.read(new File("img.jpg"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		ImageIO.write(img, "jpg", baos);
		baos.flush();

		byte[] buffer = baos.toByteArray();

		DatagramSocket serverSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getLocalHost(); // Change LocalHost
															// to your specific
															// broadcast group
		// InetAddress ip = InetAddress.getByName("192.168.9.0"); //Last Byte of
		// IP will be zero for Broadcasting (Generally)

		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, IPAddress, port);
		serverSocket.send(packet);

	}

}
