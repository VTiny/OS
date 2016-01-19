package osdesign.frame;

import osdesign.model.Equipment;
import osdesign.util.EquipmentManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by pokerface_lx
 */
public class AddEquipmentFrame extends BaseFrame implements ActionListener {

	private JButton confirmBtn;
	private JButton cancelBtn;
	private JTextField nameTxt;
	private JTextField numTxt;

	public AddEquipmentFrame() {
		this.setTitle("添加设备");
		this.setLayout(new BorderLayout());

		JPanel namePanel = new JPanel(new FlowLayout());
		JLabel nameLabel = new JLabel("设备名称：");
		nameTxt = new JTextField(15);
		namePanel.add(nameLabel);
		namePanel.add(nameTxt);
		this.getContentPane().add(namePanel, BorderLayout.NORTH);

		JPanel numPanel = new JPanel(new FlowLayout());
		JLabel numLabel = new JLabel("设置数量：");
		numTxt = new JTextField(15);
		numPanel.add(numLabel);
		numPanel.add(numTxt);
		this.getContentPane().add(numPanel, BorderLayout.CENTER);

		JPanel btnPanel = new JPanel(new FlowLayout());
		confirmBtn = new JButton("确认");
		cancelBtn = new JButton("取消");
		confirmBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		btnPanel.add(confirmBtn);
		btnPanel.add(cancelBtn);
		this.getContentPane().add(btnPanel, BorderLayout.SOUTH);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmBtn) {
			EquipmentManagement management = new EquipmentManagement();
			String name = this.nameTxt.getText();
			String num = this.numTxt.getText();
			if (name.equals("")) {
				new ErrorFrame("请输入设备名称");
				return;
			}
			if (num.equals("")) {
				try {
					management.add(new Equipment(name));
					this.dispose();

					return;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				management.add(new Equipment(name, Integer.parseInt(num)));
				this.dispose();
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NumberFormatException e2) {
				new ErrorFrame("数据格式不合法");
			}
		}
		if (e.getSource() == cancelBtn) {
			this.dispose();
		}
	}
}
