package osdesign.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		JLabel label = new JLabel("用户名：");
		label.setBounds(38, 160, 54, 15);
		this.getContentPane().add(label);

		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(252, 160, 54, 15);
		this.getContentPane().add(label_1);

		textField = new JTextField();
		textField.setBounds(90, 157, 90, 21);
		this.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(287, 157, 90, 21);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("登陆");
		button.addActionListener(this);
		button.setBounds(155, 211, 93, 23);
		this.getContentPane().add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (textField.getText().equals("admin") & textField_1.getText().equals("admin")) {
			new CourseSimulate_1();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "密码不正确请重新输入");
		}
	}
}
