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
public class AlterEquipmentFrame extends BaseFrame implements ActionListener {

	private JButton confirmBtn;
	private JButton cancelBtn;
	private JTextField originNameTxt;
	private JTextField newNameTxt;
	private JTextField totalNumTxt;
	private JTextField freeNumTxt;

	public AlterEquipmentFrame() {
		this.setTitle("修改设备信息");
		this.setLayout(new BorderLayout());

		// ------有时间的话改一下 改成下拉菜单
		JPanel originNamePanel = new JPanel(new FlowLayout());
		JLabel originNameLabel = new JLabel("原始名称：");
		originNameTxt = new JTextField(15);
		originNamePanel.add(originNameLabel);
		originNamePanel.add(originNameTxt);

		JPanel newNamePanel = new JPanel(new FlowLayout());
		JLabel newNameLabel = new JLabel("改后名称：");
		newNameTxt = new JTextField(15);
		newNamePanel.add(newNameLabel);
		newNamePanel.add(newNameTxt);

		JPanel namePanel = new JPanel(new BorderLayout());
		namePanel.add(originNamePanel, BorderLayout.NORTH);
		namePanel.add(newNamePanel, BorderLayout.SOUTH);

		// ------
		JPanel totalNumPanel = new JPanel(new FlowLayout());
		JLabel totalNumLabel = new JLabel("设置总数：");
		totalNumTxt = new JTextField(15);
		totalNumPanel.add(totalNumLabel);
		totalNumPanel.add(totalNumTxt);

		JPanel freeNumPanel = new JPanel(new FlowLayout());
		JLabel freeNumLabel = new JLabel("设置空闲数：");
		freeNumTxt = new JTextField(13);
		freeNumPanel.add(freeNumLabel);
		freeNumPanel.add(freeNumTxt);

		JPanel numPanel = new JPanel(new BorderLayout());
		numPanel.add(totalNumPanel, BorderLayout.NORTH);
		numPanel.add(freeNumPanel, BorderLayout.SOUTH);

		this.getContentPane().add(namePanel, BorderLayout.NORTH);
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
			String originName = this.originNameTxt.getText();
			String newName = this.newNameTxt.getText();
			if (originName.equals("") || newName.equals("")) {
				new ErrorFrame("数据格式错误");
				return;
			}
			int totalNum, freeNum;
			try {
				totalNum = Integer.parseInt(this.totalNumTxt.getText());
				freeNum = Integer.parseInt(this.freeNumTxt.getText());
			} catch (NumberFormatException e1) {
				new ErrorFrame("数据格式错误");
				return;
			}
			EquipmentManagement management = new EquipmentManagement();
			try {
				management.alter(originName, new Equipment(newName, totalNum, freeNum));
				this.dispose();
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == cancelBtn) {
			this.dispose();
			return;
		}
	}
}
