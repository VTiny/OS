package osdesign.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import osdesign.util.Banker;
import osdesign.util.EquipmentManagement;

import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

public class CourseSimulate_2 extends JFrame implements ActionListener {
	private JScrollPane scrollPane;
	private JTable table;
	private JButton button;
	private JTable table_1;
	private DefaultTableModel tableModel;
	private EquipmentManagement equipmentManagement;
	private int columnNum;


	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public CourseSimulate_2() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		String[] columnNames = { "A资源数量", "B资源数量", "C资源数量"};
		Object[][] cellData = { { "", "", ""} };
		getContentPane().setLayout(null);
		table = new JTable(cellData, columnNames);
		table.setRowSelectionAllowed(false);
		table.setBounds(135, 81, 1, 1);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 10, 434, 47);
		getContentPane().add(scrollPane);

		button = new JButton("下一步");
		button.setBounds(315, 213, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("设备管理");
		button_1.setBounds(73, 213, 93, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EquipmentManagementFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(button_1);
		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(0, 93, 424, 81);
//		getContentPane().add(scrollPane_1);
//		
//		equipmentManagement=new EquipmentManagement();
//		equipmentManagement.init();
//		columnNum=equipmentManagement.equipments.size();
//		tableModel=new DefaultTableModel(0,columnNum);
//		Object[] object=new Object[columnNum];
//		tableModel.addRow(object);
//		table_1 = new JTable(tableModel);
//		table_1.setRowSelectionAllowed(false);
//		scrollPane_1.setViewportView(table_1);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object value0 = table.getValueAt(0, 0);
		Banker.resource[0] = Integer.parseInt((String) value0);
		Object value1 = table.getValueAt(0, 1);
		Banker.resource[1] = Integer.parseInt((String) value1);
		Object value2 = table.getValueAt(0, 2);
		Banker.resource[2] = Integer.parseInt((String) value2);
		Object[] values=new Object[columnNum];
//		for(int i=0;i<columnNum;i++){
//			values[i]=table_1.getValueAt(0, i);
//		}
		new CourseSimulate_3();
		this.dispose();
	}
}
