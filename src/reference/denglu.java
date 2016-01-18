package reference;

import java.awt.event.*;

import javax.swing.*;

public class denglu extends JFrame {
	JTextField a1 = new JTextField();
	JPasswordField a2 = new JPasswordField();

	public denglu() {
		super("用户登录");
		JLabel e1 = new JLabel("用户名");
		JLabel e2 = new JLabel("密码");

		JButton q1 = new JButton("登录");
		q1.addActionListener(new q1listener());
		JButton q2 = new JButton("退出");
		q2.addActionListener(new q2listener());
		e1.setBounds(50, 50, 60, 20);
		e2.setBounds(50, 100, 60, 20);
		a1.setBounds(150, 50, 100, 20);
		a2.setBounds(150, 100, 100, 20);
		a1.setHorizontalAlignment(JTextField.CENTER);
		a2.setHorizontalAlignment(JTextField.CENTER);
		q1.setBounds(50, 200, 60, 30);
		q2.setBounds(190, 200, 60, 30);
		this.setLocation(350, 300);
		this.setLayout(null);
		this.getContentPane().add(e1);
		this.getContentPane().add(e2);
		this.getContentPane().add(a1);
		this.getContentPane().add(a2);
		this.getContentPane().add(q1);
		this.getContentPane().add(q2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setVisible(true);
	}

	class q1listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = new String(a1.getText());
			String mima = new String(a2.getText());
			if (name.equals("feilei") && mima.equals("123")) {
				osfz r = new osfz();
				dispose();
			} else {
				a1.setText(null);
				a2.setText(null);
			}

		}
	}

	class q2listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
