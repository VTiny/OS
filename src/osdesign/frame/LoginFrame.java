package osdesign.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginFrame extends JFrame implements ActionListener {

	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		setTitle("请登录");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLocationRelativeTo(null);
		this.setBounds(600, 280, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		JLabel label = new JLabel("用户名：");
		label.setBounds(117, 81, 54, 15);
		this.getContentPane().add(label);

		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(117, 131, 54, 15);
		this.getContentPane().add(label_1);

		textField = new JTextField();
		textField.setBounds(200, 78, 90, 21);
		this.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(200, 128, 90, 21);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("登陆");
		button.addActionListener(this);
		button.setBounds(155, 211, 93, 23);
		this.getContentPane().add(button);

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (textField.getText().equals("admin") & textField_1.getText().equals("admin")) {
			new MainFrame();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "密码不正确请重新输入");
		}
	}
}
