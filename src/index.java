import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class index extends JFrame implements ActionListener {

	private JButton btnstartrecoed;
	private JButton btncapture;
	private JButton btnstop;
	private JButton btnExit;
	public boolean IsRecording;
	private ImageIcon icon;

	public index() {
		GridLayout layout = new GridLayout(2, 2);
		super.setLayout(layout);

		Font font = new Font("chiller", 1, 50);

		icon = new ImageIcon("start.png");
		btnstartrecoed = new JButton("Start Recording", icon);
		btnstartrecoed.setFont(font);
		btnstartrecoed.setIcon(icon);
		btnstartrecoed.setBackground(Color.BLACK);
		btnstartrecoed.setForeground(Color.WHITE);
		btnstartrecoed.setToolTipText("Start Recording");
		btnstartrecoed.addActionListener(this);
		super.add(btnstartrecoed);

		icon = new ImageIcon("capture.png");
		btncapture = new JButton("Capture screen", icon);
		btncapture.setFont(font);
		btncapture.setToolTipText("Capture screen");
		btncapture.setBorderPainted(true);
		btncapture.setBackground(Color.BLACK);
		btncapture.setForeground(Color.WHITE);
		btncapture.addActionListener(this);
		super.add(btncapture);

		icon = new ImageIcon("stop.png");
		btnstop = new JButton(icon);
		btnstop.setFont(font);
		btnstop.setBackground(Color.BLACK);
		btnstop.setForeground(Color.WHITE);
		btnstop.setToolTipText("stop Recording");
		btnstop.addActionListener(this);
		super.add(btnstop);

		icon = new ImageIcon("exit.png");
		btnExit = new JButton(icon);
		btnExit.setFont(font);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		btnExit.setToolTipText("exit");
		btnExit.addActionListener(this);
		super.add(btnExit);

		IsRecording = false;

		super.setVisible(true);
		super.setTitle("Screen Operation Software---Designed and Developed By ACM MAIT");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btncapture) {
			handleCapture();
		} else if (e.getSource() == btnExit) {
			handleExit();
		} else if (e.getSource() == btnstartrecoed) {
			handleRecord();
		} else if (e.getSource() == btnstop) {
			handleStop();
		}

	}

	private void handleStop() {
		Recorder.record = false;

	}

	private void handleRecord() {

		JOptionPane.showMessageDialog(null, "move to the screen you want to record");
		for (int i = 3; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		File f = new File(Recorder.store);
		if (!f.exists()) {
			f.mkdir();
		}
		Recorder.startRecord();

	}

	private void handleExit() {
		JOptionPane.showMessageDialog(null, "Exiting Screen!!!");
		handleStop();
		this.dispose();

	}

	private void handleCapture() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		ScreenCapture capture = new ScreenCapture();
		JOptionPane.showMessageDialog(null, "screenShort saved !!!");
	}

}