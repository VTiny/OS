package osdesign.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

public class CourseSimulate_2 extends JFrame implements ActionListener {
	private JScrollPane scrollPane;
	private JTable table;
	private JButton button;

	/**
	 * Create the application.
	 */
	public CourseSimulate_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		String[] columnNames = { "A资源数量", "B资源数量", "C资源数量", "设备A数量", "设备B数量" };
		Object[][] cellData = { { "", "", "", "", "" } };
		getContentPane().setLayout(null);
		table = new JTable(cellData, columnNames);
		table.setRowSelectionAllowed(false);
		table.setBounds(135, 81, 1, 1);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 10, 434, 44);
		getContentPane().add(scrollPane);

		button = new JButton("下一步");
		button.addActionListener(this);
		button.setBounds(315, 213, 93, 23);
		getContentPane().add(button);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object value0 = table.getValueAt(0, 0);
		Banker.resource[0] = Integer.parseInt((String) value0);
		Object value1 = table.getValueAt(0, 1);
		Banker.resource[1] = Integer.parseInt((String) value1);
		Object value2 = table.getValueAt(0, 2);
		Banker.resource[2] = Integer.parseInt((String) value2);
		Object value3 = table.getValueAt(0, 3);
		// System.out.println(Integer.parseInt((String) value3));
		// Object value4 = table.getValueAt(0, 4);
		// System.out.println(Integer.parseInt((String) value4));
		new CourseSimulate_3();
		this.dispose();
	}
}
