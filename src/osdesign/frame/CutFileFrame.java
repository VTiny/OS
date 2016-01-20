package osdesign.frame;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by pokerface_lx
 */
public class CutFileFrame extends JFrame implements ActionListener, TreeSelectionListener {
    private JButton confirmBtn;
    private JButton cancelBtn;
    public JTextField oldPathTxt;
    private JTextField newPathTxt;
    public String oldPath;
    public String newPath;

    public CutFileFrame() {

        this.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel(new BorderLayout());
        JLabel contentLabel = new JLabel("目录");
        contentPanel.add(contentLabel, BorderLayout.NORTH);

        DefaultMutableTreeNode topNode = new DefaultMutableTreeNode("我的电脑");
        FileSystemView fsv = FileSystemView.getFileSystemView();
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
        contentPanel.add(treeScrollPane, BorderLayout.CENTER);

        JPanel pathPanel = new JPanel(new BorderLayout());

        JPanel oldPathPanel = new JPanel(new FlowLayout());
        JLabel oldPathLabel = new JLabel("原目录");
        oldPathTxt = new JTextField(18);
        oldPathTxt.setEditable(false);
        oldPathPanel.add(oldPathLabel);
        oldPathPanel.add(oldPathTxt);

        JPanel newPathPanel = new JPanel(new FlowLayout());
        JLabel newPathLabel = new JLabel("新目录");
        newPathTxt = new JTextField(18);
        newPathPanel.add(newPathLabel);
        newPathPanel.add(newPathTxt);

        JPanel btnsPanel = new JPanel(new FlowLayout());
        confirmBtn = new JButton("确认");
        cancelBtn = new JButton("取消");
        confirmBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        btnsPanel.add(confirmBtn);
        btnsPanel.add(cancelBtn);

        pathPanel.add(oldPathPanel, BorderLayout.NORTH);
        pathPanel.add(newPathPanel, BorderLayout.CENTER);
        pathPanel.add(btnsPanel, BorderLayout.SOUTH);

        this.getContentPane().add(contentPanel, BorderLayout.WEST);
        this.getContentPane().add(pathPanel, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmBtn) {
            newPath = this.newPathTxt.getText();
            oldPath = this.oldPathTxt.getText();
            this.dispose();
        }

        if (e.getSource() == cancelBtn) {
            this.dispose();
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        newPath = e.getNewLeadSelectionPath().toString();
        newPath = newPath.replace("[我的电脑, ", "");
        newPath = newPath.replace("]", "");
        newPath = newPath.substring(newPath.indexOf('(') + 1);
        newPath = newPath.replace(newPath.charAt(2), ' ');
        newPath = newPath.replace(", ", "\\");
        newPath = newPath.replaceFirst(" ", "");
        this.newPathTxt.setText(newPath);
    }
}
