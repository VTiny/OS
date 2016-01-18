package osdesign.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import osdesign.util.*;

public class CourseSimulate_1 extends JFrame implements ActionListener {
	private JTextField textField;
	public static int pcbNum;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseSimulate_1 window = new CourseSimulate_1();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		JLabel label = new JLabel("请输入进程数");
		label.setBounds(61, 97, 92, 37);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(163, 105, 66, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("下一步");
		button.addActionListener(this);
		button.setBounds(319, 216, 93, 23);
		getContentPane().add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Banker.pcbNum = (Integer.parseInt(textField.getText()));
		new CourseSimulate_2();
		this.dispose();
	}
}
