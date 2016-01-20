package osdesign.frame;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * Created by pokerface_lx
 */
public class Editor extends JFrame {
    private JTextPane textPane = new JTextPane(); //文本窗格，编辑窗口
    private JLabel statusBar = new JLabel(); //状态栏
    private JFileChooser filechooser = new JFileChooser(); //文件选择器

    public Editor() {
        super("编辑器");

        Action[] actions =
                {
                        new NewAction(),
                        new OpenAction(),
                        new SaveAction(),
                        new CutAction(),
                        new CopyAction(),
                        new PasteAction(),
                        new AboutAction(),
                        new ExitAction()};

        setJMenuBar(createJMenuBar(actions));
        Container container = getContentPane();
        container.add(createJToolBar(actions), BorderLayout.NORTH);
        container.add(textPane, BorderLayout.CENTER);
        container.add(statusBar, BorderLayout.SOUTH);

        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Editor(String title) {
        super("title");

        Action[] actions =
                {
                        new NewAction(),
                        new OpenAction(),
                        new SaveAction(),
                        new CutAction(),
                        new CopyAction(),
                        new PasteAction(),
                        new AboutAction(),
                        new ExitAction()};

        setJMenuBar(createJMenuBar(actions));
        Container container = getContentPane();
        container.add(createJToolBar(actions), BorderLayout.NORTH);
        container.add(textPane, BorderLayout.CENTER);
        container.add(statusBar, BorderLayout.SOUTH);

        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void openFile(File file) {
        try {
            InputStream is = new FileInputStream(file);
            this.textPane.read(is, "d");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JMenuBar createJMenuBar(Action[] actions) {
        JMenuBar menubar = new JMenuBar();
        JMenu menuFile = new JMenu("文件");
        JMenu menuEdit = new JMenu("编辑");
        JMenu menuAbout = new JMenu("帮助");
        menuFile.add(new JMenuItem(actions[0]));
        menuFile.add(new JMenuItem(actions[1]));
        menuFile.add(new JMenuItem(actions[2]));
        menuFile.add(new JMenuItem(actions[7]));
        menuEdit.add(new JMenuItem(actions[3]));
        menuEdit.add(new JMenuItem(actions[4]));
        menuEdit.add(new JMenuItem(actions[5]));
        menuAbout.add(new JMenuItem(actions[6]));
        menubar.add(menuFile);
        menubar.add(menuEdit);
        menubar.add(menuAbout);
        return menubar;
    }

    private JToolBar createJToolBar(Action[] actions) {
        JToolBar toolBar = new JToolBar();
        for (int i = 0; i < actions.length; i++) {
            JButton bt = new JButton(actions[i]);
            bt.setRequestFocusEnabled(false); //设置不需要焦点
            toolBar.add(bt);
        }
        return toolBar;
    }

    class NewAction extends AbstractAction { //新建文件命令
        public NewAction() {
            super("新建");
        }
        public void actionPerformed(ActionEvent e) {
            textPane.setDocument(new DefaultStyledDocument()); //清空文档
        }
    }

    class OpenAction extends AbstractAction { //打开文件命令
        public OpenAction() {
            super("打开");
        }
        public void actionPerformed(ActionEvent e) {
            int i = filechooser.showOpenDialog(Editor.this); //显示打开文件对话框
            if (i == JFileChooser.APPROVE_OPTION) { //点击对话框中打开选项
                File f = filechooser.getSelectedFile(); //得到选择的文件
                try {
                    InputStream is = new FileInputStream(f); //得到文件输入流
                    textPane.read(is, "d"); //读入文件到文本窗格
                } catch (Exception ex) {
                    ex.printStackTrace();  //输出出错信息
                }
            }
        }
    }

    class SaveAction extends AbstractAction {  //保存命令
        public SaveAction() {
            super("保存");
        }
        public void actionPerformed(ActionEvent e) {
            int i = filechooser.showSaveDialog(Editor.this); //显示保存文件对话框
            if (i == JFileChooser.APPROVE_OPTION) {  //点击对话框中保存按钮
                File f = filechooser.getSelectedFile();
                try {
                    FileOutputStream out = new FileOutputStream(f);
                    out.write(textPane.getText().getBytes());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    class ExitAction extends AbstractAction {
        public ExitAction() {
            super("退出");
        }
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    class CutAction extends AbstractAction {
        public CutAction() {
            super("剪切");
        }
        public void actionPerformed(ActionEvent e) {
            textPane.cut();
        }
    }

    class CopyAction extends AbstractAction {
        public CopyAction() {
            super("拷贝");
        }
        public void actionPerformed(ActionEvent e) {
            textPane.copy();
        }
    }

    class PasteAction extends AbstractAction {
        public PasteAction() {
            super("粘贴");
        }
        public void actionPerformed(ActionEvent e) {
            textPane.paste();
        }
    }

    class AboutAction extends AbstractAction {
        public AboutAction() {
            super("关于");
        }
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(Editor.this, "简单的文本编辑器演示");
        }
    }

}