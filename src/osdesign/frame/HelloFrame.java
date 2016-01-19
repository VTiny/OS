package osdesign.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HelloFrame extends JFrame implements ActionListener {
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		HelloFrame helloFrame = new HelloFrame();
	}

	/**
	 * Create the application.
	 */
	public HelloFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("欢迎使用本系统");
		this.setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(null);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("进入系统");
		button.addActionListener(this);
		this.setVisible(true);
		button.setBounds(167, 228, 93, 23);
		this.getContentPane().add(button);

	}

	public void actionPerformed(ActionEvent e) {
		new LoginFrame();
		this.dispose();
	}
}
