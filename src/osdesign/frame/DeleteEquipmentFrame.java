package osdesign.frame;

import osdesign.util.EquipmentManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by pokerface_lx
 */
public class DeleteEquipmentFrame extends BaseFrame implements ActionListener {

	private JButton confirmBtn;
	private JButton cancelBtn;
	private JTextField nameTxt;

	public DeleteEquipmentFrame() {
		this.setTitle("删除设备");
		this.setLayout(new BorderLayout());

		JPanel namePanel = new JPanel(new FlowLayout());
		JLabel nameLabel = new JLabel("输入要删除的设备名称：");
		nameTxt = new JTextField(10);
		namePanel.add(nameLabel);
		namePanel.add(nameTxt);
		this.getContentPane().add(namePanel, BorderLayout.NORTH);

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
			String name = this.nameTxt.getText();
			if (name.equals("")) {
				new ErrorFrame("请输入设备名称");
				return;
			}
			EquipmentManagement management = new EquipmentManagement();
			try {
				management.delete(name);
				this.dispose();
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == cancelBtn) {
			this.dispose();
		}
	}
}
