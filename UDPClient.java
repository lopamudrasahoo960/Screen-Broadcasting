import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UDPClient {
	
	private static final int port = 9999;
	
	public static void main(String[] args) throws Exception {
		
		DatagramSocket clientSocket = new DatagramSocket(port);
		
		byte[] dataInPacket = new byte[64*1024]; // Change 64*1024 to the maximum size of the image which will be used while broadcasting
		
		DatagramPacket receivedData = new DatagramPacket(dataInPacket, dataInPacket.length);
		clientSocket.receive(receivedData);
		byte[] buffer = receivedData.getData();

		ImageIcon img = new ImageIcon(buffer);

		JFrame mainWindow = new JFrame("BroadCast Receiver");
		mainWindow.setLayout(new FlowLayout());
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		JLabel image = new JLabel();
		image.setIcon(img);
		mainPanel.add(image);
		mainWindow.add(mainPanel);
		mainWindow.setSize(680, 455);
		mainWindow.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width - mainWindow.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().height - mainWindow.getHeight()) / 2);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		
	}
}
