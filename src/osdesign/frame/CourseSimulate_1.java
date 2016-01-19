package osdesign.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import osdesign.util.*;

public class CourseSimulate_1 extends JFrame implements ActionListener {
	private JTextField textField;
	public static int pcbNum;

	/**
	 * Create the application.
	 */
	public CourseSimulate_1() {

		setTitle("进程模拟");
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);

		JLabel label = new JLabel("请输入进程数：");
		label.setBounds(91, 104, 92, 37);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(218, 112, 66, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("下一步");
		button.addActionListener(this);
		button.setBounds(316, 213, 93, 23);
		getContentPane().add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Banker.pcbNum = (Integer.parseInt(textField.getText()));
		try {
			new CourseSimulate_2();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.dispose();
	}
}
