package osdesign.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import osdesign.util.BestFit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemFrame {

	private JFrame frame;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemFrame window = new MemFrame();
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
	public MemFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(600, 280, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Object[] colunmNames = { "内存块", "Start", "End", "Length" };
		tableModel = new DefaultTableModel(colunmNames, 0);
		frame.getContentPane().setLayout(null);
		table = new JTable(tableModel);
		table.setRowSelectionAllowed(false);
		scrollpane = new JScrollPane(table);
		scrollpane.setSize(434, 214);
		scrollpane.setLocation(0, 0);
		frame.getContentPane().add(scrollpane);
		print();
		button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(307, 224, 93, 23);
		frame.getContentPane().add(button);
	}

	public void print() {
		Object[] object = new Object[4];
		for (int i = 0; i < BestFit.kongxianList.size(); i++) {
			object[0] = i + 1;
			object[1] = BestFit.kongxianList.get(i).getStar();
			object[2] = BestFit.kongxianList.get(i).getEnd();
			object[3] = BestFit.kongxianList.get(i).getLength();
			tableModel.addRow(object);
		}
	}
}
