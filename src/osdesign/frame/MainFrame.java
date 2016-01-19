package osdesign.frame;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(10, 10, 414, 15);
		frame.getContentPane().add(lblNewLabel);
		
		SimpleDateFormat df=new SimpleDateFormat("HH:mm \n yyyy/MM/dd");
		Date date=new Date();
		String time=df.format(date);
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
		btnNewButton.setBounds(31, 60, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("文件管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(31, 115, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
