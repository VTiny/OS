package osdesign.frame;

import javafx.scene.control.Tab;
import osdesign.util.FileHelper;

import javax.activation.MimetypesFileTypeMap;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * Created by pokerface_lx
 */
public class FileManagementFrame extends JFrame implements TreeSelectionListener, ActionListener {

    private DefaultMutableTreeNode topNode;
    private FileSystemView fsv;

    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem exitItem;
    private JMenuItem copyItem;
    private JMenuItem cutItem;
    private JMenuItem deleteItem;

    private JTextField pathTxt;
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
        JMenu fileMenu = new JMenu("文件(F)  ");//文件menu
        menuBar.add(fileMenu);
        newItem = new JMenuItem("新建(N)   ");
        openItem = new JMenuItem("打开(O)   ");
        exitItem = new JMenuItem("退出(Q)   ");
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        exitItem.addActionListener(this);
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("编辑(E) ");
        menuBar.add(editMenu);
        copyItem = new JMenuItem("复制(C)   ");
        cutItem = new JMenuItem("剪切(T)   ");
        deleteItem = new JMenuItem("删除(D)   ");
        copyItem.addActionListener(this);
        cutItem.addActionListener(this);
        deleteItem.addActionListener(this);
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(deleteItem);


        this.getContentPane().add(menuBar, BorderLayout.NORTH);


        JPanel pathPanel = new JPanel(new BorderLayout());
        JLabel pathLabel = new JLabel("文件目录：");
        pathTxt = new JTextField();
        pathTxt.setEditable(false);
        pathPanel.add(pathLabel, BorderLayout.WEST);
        pathPanel.add(pathTxt, BorderLayout.CENTER);
        this.getContentPane().add(pathPanel, BorderLayout.CENTER);

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

        JTree tree = new JTree(topNode);

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
        table.setSize(210, 400);
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                System.out.println("click");
//            }
//        });
//        table.addMouseMotionListener(getMouseInputListener(table));
        JScrollPane tableScrollPane = new JScrollPane(table);

        otherPanel.add(tableScrollPane, BorderLayout.CENTER);

        this.table.repaint();
        this.table.updateUI();

        this.getContentPane().add(otherPanel, BorderLayout.SOUTH);
//        this.pack();
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //---右键菜单---
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("te");
        popupMenu.add(item1);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    System.out.println("asdf");
                }
            }
        });

    }

    /***
     * 更新table的内容
     */
    public void updateTable() {
        table.removeAll();
        table.setSize(210, 400);
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
        table.addMouseListener(getMouseInputListener(table));
        table.addMouseMotionListener(getMouseInputListener(table));
//        table.addMouseListener(this);
        JScrollPane tableScrollPane = new JScrollPane(table);
        otherPanel.add(tableScrollPane, BorderLayout.CENTER);
        this.otherPanel.validate();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    System.out.println("asdf");
                }
            }
        });
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        try {
            path = e.getNewLeadSelectionPath().toString();
        } catch (Exception e1) {
            return;
        }
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
        this.pathTxt.setText(path);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.newItem) {
            System.out.println(path);
            NewFileFrame newFileFrame = new NewFileFrame();
            newFileFrame.pathTxt.setText(path);
            newFileFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    FileHelper helper = new FileHelper();
                    helper.createFile(newFileFrame.path, newFileFrame.newFileName);
                    updateTable();
                }
            });
        }

        if (e.getSource() == this.openItem) {
            if (path == null || path.equals("")) {
                new ErrorFrame("请先选中文件");
            } else {
                File file = new File(path);
                new Editor().openFile(file);
            }
        }

        if (e.getSource() == this.exitItem) {
            this.dispose();
        }

        if (e.getSource() == this.copyItem) {
            FileHelper helper = new FileHelper();
            if (path == null || path.equals("")) {
                new ErrorFrame("请先选中文件");
            } else {
                CopyFileFrame copyFileFrame = new CopyFileFrame();
                copyFileFrame.oldPathTxt.setText(path);
                copyFileFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        String oldPath = copyFileFrame.oldPath;
                        String newPath = copyFileFrame.newPath;
                        if (helper.copyFile(new File(oldPath), newPath)) {
                            new ToastFrame("文件复制成功");
                        } else {
                            new ErrorFrame("出现错误");
                        }
                        updateTable();
                    }
                });
            }
        }

        if (e.getSource() == this.cutItem) {
            FileHelper helper = new FileHelper();
            if (path == null || path.equals("")) {
                new ErrorFrame("请先选中文件");
            } else {
                CopyFileFrame copyFileFrame = new CopyFileFrame();
                copyFileFrame.oldPathTxt.setText(path);
                copyFileFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        String oldPath = copyFileFrame.oldPath;
                        String newPath = copyFileFrame.newPath;
                        if (helper.cutFile(new File(oldPath), newPath)) {
                            new ToastFrame("文件复制成功");
                        } else {
                            new ErrorFrame("出现错误");
                        }
                        updateTable();
                    }
                });
            }
        }

        if (e.getSource() == this.deleteItem) {
            System.out.println(path);
            FileHelper helper = new FileHelper();
            if (path == null || path.equals("")) {
                new ErrorFrame("请先选中文件");
            } else {
                if (helper.deleteFile(new File(path))) {
                    new ToastFrame("文件删除成功");
                } else {
                    new ErrorFrame("出现错误");
                }
            }
        }

    }

    private MouseInputListener getMouseInputListener(JTable table) {
        return new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                processEvent(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                processEvent(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                processEvent(e);
                if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0
                        && !e.isControlDown() && !e.isShiftDown()) {
                    System.out.println("press");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }

    //    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("mouseClicked");
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        System.out.println("mousePressed");
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouseReleased");
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouseEntered");
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        System.out.println("mouseExited");
//    }
//
    public static void main(String[] args) {
        new FileManagementFrame();
    }
}
