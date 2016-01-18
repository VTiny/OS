package osdesign.frame;

import osdesign.model.Equipment;
import osdesign.util.EquipmentManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pokerface_lx
 */
public class EquipmentManagementFrame extends BaseFrame implements ActionListener, WindowListener {

    private JTable table = null;
    private EquipmentManagement management = null;

    JMenuItem addItem = new JMenuItem("添加设备");
    JMenuItem deleteItem = new JMenuItem("删除设备");
    JMenuItem alterItem = new JMenuItem("修改设备");

    public static void main(String[] args) throws Exception {
        EquipmentManagementFrame frame = new EquipmentManagementFrame();
//        TimeUnit.SECONDS.sleep(1);
        frame.init();
    }

    private void init() throws IOException {
        this.setTitle("设备管理");
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("管理");
        menuBar.add(menu);
        menu.add(addItem);
        menu.add(alterItem);
        menu.add(deleteItem);
        addItem.addActionListener(this);
        alterItem.addActionListener(this);
        deleteItem.addActionListener(this);
        this.getContentPane().add(menuBar, BorderLayout.NORTH);

//        refresh();

        management = new EquipmentManagement();
        management.firstInit();
        management.init();
        Object[] columnTitle = {"设备名称", "设备总数", "空闲数量"};

        int num = management.equipments.size();
        Object[][] rowsData = new Object[num][3];
        for (int i = 0; i < num; i++) {
            Equipment equipment = management.equipments.get(i);
            rowsData[i] = new Object[]{
                    equipment.getName(), equipment.getTotalNumber(), equipment.getFreeNumber()
            };
        }
        table = new JTable(rowsData, columnTitle);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(300, 200));
        this.getContentPane().add(pane, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //---添加设备---
        if (e.getSource() == addItem) {
            System.out.println("add");
            AddEquipmentFrame addFrame = new AddEquipmentFrame();
            addFrame.addWindowListener(this);
        }

        //---删除设备---
        if (e.getSource() == deleteItem) {
            System.out.println("delete");
            DeleteEquipmentFrame deleteFrame = new DeleteEquipmentFrame();
            deleteFrame.addWindowListener(this);
        }

        //---修改设备---
        if (e.getSource() == alterItem) {
            System.out.println("alter");
            AlterEquipmentFrame alterFrame = new AlterEquipmentFrame();
            alterFrame.addWindowListener(this);
        }
    }

    private void refresh() throws IOException {
        this.getContentPane().remove(table);
        management = new EquipmentManagement();
        management.init();
        Object[] columnTitle = {"设备名称", "设备总数", "空闲数量"};

        int num = management.equipments.size();
        Object[][] rowsData = new Object[num][3];
        for (int i = 0; i < num; i++) {
            Equipment equipment = management.equipments.get(i);
            rowsData[i] = new Object[]{
                    equipment.getName(), equipment.getTotalNumber(), equipment.getFreeNumber()
            };
        }
        table = new JTable(rowsData, columnTitle);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(300, 200));
        this.getContentPane().add(pane, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            refresh();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
