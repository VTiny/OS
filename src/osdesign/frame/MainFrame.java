package osdesign.frame;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainFrame {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblNewLabel = new JLabel("欢迎使用本模拟系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 414, 23);
		frame.getContentPane().add(lblNewLabel);

		SimpleDateFormat df = new SimpleDateFormat("HH:mm yyyy/MM/dd");
		Date date = new Date();
		String time = df.format(date);
		JLabel lblNewLabel_1 = new JLabel(time);
		lblNewLabel_1.setBounds(314, 236, 110, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("进程模拟");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CourseSimulate_1();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(167, 60, 93, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("文件管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(167, 100, 93, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("退出系统");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(167, 180, 93, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton button_1 = new JButton("设备管理");
		button_1.setBounds(167, 140, 93, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EquipmentManagementFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(button_1);
	}

}
