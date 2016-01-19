package osdesign.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import osdesign.model.PCB;
import osdesign.util.Banker;
import osdesign.util.BestFit;
import javax.swing.JButton;

public class CourseSimulate_4 extends JFrame implements ActionListener {
	private JTextField textField;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollpane;
	private Banker banker;
	private BestFit bestFit = new BestFit();

	/**
	 * Create the application.
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public CourseSimulate_4() throws InterruptedException, IOException {
		setTitle("模拟结果");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	private void initialize() throws InterruptedException, IOException {
		bestFit.initMemory();
		banker = new Banker();
		this.setBounds(100, 100, 552, 342);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setVisible(true);

		JLabel label = new JLabel("银行家算法模拟结果：");
		label.setBounds(10, 10, 150, 15);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(149, 7, 128, 21);
		textField.setText(banker.run());
		getContentPane().add(textField);
		textField.setColumns(10);

		Object[] colunmNames = { "Name", "A", "B", "C", "A", "B", "C", "A", "B", "C", "Finish" };
		tableModel = new DefaultTableModel(colunmNames, 0);
		table = new JTable(tableModel);
		table.setRowSelectionAllowed(false);
		scrollpane = new JScrollPane(table);
		scrollpane.setSize(516, 218);
		scrollpane.setLocation(10, 45);
		this.getContentPane().add(scrollpane);

		JLabel lblMax = new JLabel("Max");
		lblMax.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setLabelFor(table);
		lblMax.setBounds(53, 30, 143, 15);
		this.getContentPane().add(lblMax);

		JLabel lblAllocation = new JLabel("Allocation");
		lblAllocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllocation.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblAllocation.setBounds(201, 30, 130, 15);
		this.getContentPane().add(lblAllocation);

		JLabel lblWork = new JLabel("Work");
		lblWork.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblWork.setBounds(341, 31, 135, 15);
		getContentPane().add(lblWork);

		JButton button = new JButton("返回");
		button.addActionListener(this);
		button.setBounds(420, 273, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("内存使用情况");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				new MemFrame();				
			}
		});
		button_1.setBounds(67, 273, 129, 23);
		getContentPane().add(button_1);

		if (banker.banker_algorithm()) {
			for (int i = 0; i < banker.safeQueue.size(); i++) {
				print(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MainFrame();
		this.dispose();
	}

	public void print(int i) {
		PCB pcb = Banker.safeQueue.get(i);
		bestFit.alloc(pcb.getMemory());
		Object[] object = new Object[table.getColumnCount()];
		object[0] = pcb.getID();
		object[1] = pcb.getMax()[0];
		object[2] = pcb.getMax()[1];
		object[3] = pcb.getMax()[2];
		object[4] = pcb.getAllocation()[0];
		object[5] = pcb.getAllocation()[1];
		object[6] = pcb.getAllocation()[2];
		object[7] = pcb.getWork()[0];
		object[8] = pcb.getWork()[1];
		object[9] = pcb.getWork()[2];
		object[10] = "Finish";
		tableModel.addRow(object);
	}
}
