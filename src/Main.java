import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener {

	private JButton receive;
	private JButton send;
	private JButton exit;
	index obj;

	public Main() {
		GridLayout layout = new GridLayout(3, 1);
		super.setLayout(layout);

		Font font = new Font("chiller", 2, 50);

		receive = new JButton("receive");
		receive.setFont(font);
		receive.addActionListener(this);
		super.add(receive);

		send = new JButton("Broadcast");
		send.setFont(font);
		send.addActionListener(this);
		super.add(send);

		exit = new JButton("Exit");
		exit.setFont(font);
		exit.addActionListener(this);
		super.add(exit);

		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setExtendedState(NORMAL);
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setVisible(true);

	}

	public static void main(String[] args) {

		Main ob = new Main();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == send) {
			obj = new index();
		} else if (e.getSource() == receive) {

			MyClient cli = new MyClient();

		} else {
			handleExit();

		}
	}

	private void handleExit() {
		JOptionPane.showMessageDialog(null, "Exiting Screen!!!");
		this.dispose();
	}

}
