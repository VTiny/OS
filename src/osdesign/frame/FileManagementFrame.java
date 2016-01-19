package osdesign.frame;

import javafx.scene.control.Tab;
import osdesign.util.FileHelper;

import javax.activation.MimetypesFileTypeMap;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * Created by pokerface_lx
 */
public class FileManagementFrame extends BaseFrame implements TreeSelectionListener {

    private DefaultMutableTreeNode topNode;
    private FileSystemView fsv;
    private JTable table;
    private String path;
    private JPanel otherPanel;
    private Vector tableData;
    private Vector<String> tableColumnData;
    private Vector<Vector<String>> tableRowsData;

    public FileManagementFrame() {
        this.setTitle("我的电脑");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);


        //---添加menu---
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("文件");
        menuBar.add(fileMenu);
        JMenuItem newItem = new JMenuItem("新建");
        JMenuItem openItem = new JMenuItem("打开");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        this.getContentPane().add(menuBar, BorderLayout.NORTH);

        otherPanel = new JPanel(new BorderLayout());


        //---添加tree---
        topNode = new DefaultMutableTreeNode("我的电脑");
        fsv = FileSystemView.getFileSystemView();
        File[] rootFiles = File.listRoots();
        DefaultMutableTreeNode rootNodes[] = new DefaultMutableTreeNode[rootFiles.length];
        for (int i = 0; i < rootFiles.length; i++) {
            String name = fsv.getSystemDisplayName(rootFiles[i]);
            if (name.equals("")) {
                break;
            }
            rootNodes[i] = new DefaultMutableTreeNode(name);
            topNode.add(rootNodes[i]);
        }

        File[] subFiles;
        DefaultMutableTreeNode[] subNodes;
        for (int i = 0; i < rootNodes.length; i++) {
            subFiles = rootFiles[i].listFiles();
            if (subFiles == null) {
                break;
            }
            subNodes = new DefaultMutableTreeNode[subFiles.length];
            for (int j = 0; j < subNodes.length; j++) {
                subNodes[j] = new DefaultMutableTreeNode(fsv.getSystemDisplayName(subFiles[j]));
                rootNodes[i].add(subNodes[j]);
            }
        }

        final JTree tree = new JTree(topNode);

        tree.setSize(200, 400);
        tree.addTreeSelectionListener(this);

        JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        treeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        otherPanel.add(treeScrollPane, BorderLayout.WEST);


        //---添加table---
        tableColumnData = new Vector<>();
        tableColumnData.add("文件名称");
        tableColumnData.add("修改时间");
        tableRowsData = new Vector<>();
        for (int i = 0; i < 0; i++) {
            Vector<String> rowData = new Vector<>();
            rowData.add("");
            rowData.add("");
            tableRowsData.add(rowData);
        }
        DefaultTableModel tableModel = new DefaultTableModel(tableRowsData, tableColumnData);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        otherPanel.add(tableScrollPane, BorderLayout.CENTER);

        this.table.repaint();
        this.table.updateUI();

        this.getContentPane().add(otherPanel, BorderLayout.CENTER);
//        this.pack();
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);

    }

    /***
     * 更新table的内容
     */
    public void updateTable() {
        table.removeAll();
        File file = new File(path);
        File[] subFiles = file.listFiles();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        tableColumnData = new Vector<>();
        tableColumnData.add("文件名称");
        tableColumnData.add("修改时间");
        tableRowsData = new Vector<>();
        if (subFiles == null) {
            return;
        }
        for (int i = 0; i < subFiles.length; i++) {
            if (subFiles[i].getName().equals("")) {
                break;
            }
//            long time = subFiles[i].lastModified();
//            Date date = new Date(time);
            FileHelper helper = new FileHelper();
            Vector<String> rowData = new Vector<>();
            rowData.add(subFiles[i].getName());
            rowData.add(helper.getCreateTime(subFiles[i]));

            tableRowsData.add(rowData);
        }
        DefaultTableModel tableModel = new DefaultTableModel(tableRowsData, tableColumnData);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        otherPanel.add(tableScrollPane, BorderLayout.CENTER);
        this.otherPanel.validate();
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        path = e.getNewLeadSelectionPath().toString();
        path = path.replace("[我的电脑, ", "");
        path = path.replace("]", "");
        path = path.substring(path.indexOf('(') + 1);
        path = path.replace(path.charAt(2), ' ');
        path = path.replace(", ", "\\");
        path = path.replaceFirst(" ", "");
        String type = new FileHelper().getType(path);
        if (type.equals("folder")) {
            updateTable();
        }
    }

    public static void main(String[] args) {
        new FileManagementFrame();

    }

}
