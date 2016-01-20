package osdesign.frame;

import java.awt.*;
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
		this.setBounds(600, 280, 450, 300);
		this.getContentPane().setLayout(null);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("进入系统");
		button.addActionListener(this);
		button.setSelected(false);
		this.setVisible(true);
		button.setBounds(168, 174, 93, 23);
		this.getContentPane().add(button);

		JLabel label = new JLabel("操作系统模拟系统");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(54, 40, 323, 84);
		getContentPane().add(label);

		this.setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent e) {
		new LoginFrame();
		this.dispose();
	}

//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		ImageIcon icon = new ImageIcon("background.png");
//		Image image = icon.getImage();
//		g.drawImage(image, 0, 0, null);
//	}
}
