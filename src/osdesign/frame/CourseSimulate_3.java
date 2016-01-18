package osdesign.frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import osdesign.model.PCB;
import osdesign.util.Banker;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class CourseSimulate_3 extends JFrame implements ActionListener {
	private TableModel tableModel;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton button;
	private PCB[] pcbs = new PCB[Banker.pcbNum];

	/**
	 * Create the application.
	 */
	public CourseSimulate_3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("进程分配");
		this.setBounds(100, 100, 516, 352);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);

		Object[] colunmNames = { "Name", "A", "B", "C", "A", "B", "C", "设备A", "设备B", "内存", "时间" };
		tableModel = new DefaultTableModel(colunmNames, Banker.pcbNum);
		for (int i = 0; i < Banker.pcbNum; i++) {
			Object name = "P" + i;
			tableModel.setValueAt(name, i, 0);
		}
		table = new JTable(tableModel);
		scrollpane = new JScrollPane(table);
		scrollpane.setSize(480, 218);
		scrollpane.setLocation(10, 45);
		this.getContentPane().add(scrollpane);

		JLabel lblMax = new JLabel("Max");
		lblMax.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setLabelFor(table);
		lblMax.setBounds(53, 30, 130, 15);
		this.getContentPane().add(lblMax);

		JLabel lblAllocation = new JLabel("Allocation");
		lblAllocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllocation.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblAllocation.setBounds(182, 31, 130, 15);
		this.getContentPane().add(lblAllocation);

		button = new JButton("开始模拟");
		button.addActionListener(this);
		button.setBounds(351, 267, 93, 23);
		this.getContentPane().add(button);

	}

	public void actionPerformed(ActionEvent e) {
		init();
		try {
			new CourseSimulate_4();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		this.dispose();
	}

	public void init() {
		for (int i = 0; i < pcbs.length; i++) {
			pcbs[i] = new PCB();
			setValues(pcbs[i], i);
			Banker.waitQueue.add(pcbs[i]);
		}
	}

	public void setValues(PCB pcb, int i) {
		int[] max = new int[3];
		int[] allocation = new int[3];
		int[] need = new int[3];
		int[] equipment = new int[2];
		int memory = 0;
		int runTime = 0;
		max[0] = Integer.parseInt((String) table.getValueAt(i, 1));
		max[1] = Integer.parseInt((String) table.getValueAt(i, 2));
		max[2] = Integer.parseInt((String) table.getValueAt(i, 3));
		allocation[0] = Integer.parseInt((String) table.getValueAt(i, 4));
		allocation[1] = Integer.parseInt((String) table.getValueAt(i, 5));
		allocation[2] = Integer.parseInt((String) table.getValueAt(i, 6));
		equipment[0] = Integer.parseInt((String) table.getValueAt(i, 7));
		equipment[1] = Integer.parseInt((String) table.getValueAt(i, 8));
		need[0] = max[0] - allocation[0];
		need[1] = max[1] - allocation[1];
		need[2] = max[2] - allocation[2];
		memory = Integer.parseInt((String) table.getValueAt(i, 9));
		runTime = Integer.parseInt((String) table.getValueAt(i, 10));
		pcb.setMax(max);
		pcb.setAllocation(allocation);
		pcb.setNeed(need);
		pcb.setEquipment(equipment);
		pcb.setMemory(memory);
		pcb.setRunTime(runTime);
	}
}
