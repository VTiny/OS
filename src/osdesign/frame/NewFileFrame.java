package osdesign.frame;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pokerface_lx
 */
public class NewFileFrame extends JFrame implements ActionListener {

    private JButton confirmBtn;
    private JButton cancelBtn;
    private JTextField nameTxt;
    public JTextField pathTxt;

    public String newFileName;
    public String path;

    public NewFileFrame() {
        this.setLayout(new BorderLayout());

        JPanel namePanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("文件名： ");
        nameTxt = new JTextField(25);
        namePanel.add(nameLabel);
        namePanel.add(nameTxt);

        JPanel pathPanel = new JPanel(new FlowLayout());
        JLabel pathLabel = new JLabel("文件路径:");
        pathTxt = new JTextField(25);
        pathPanel.add(pathLabel);
        pathPanel.add(pathTxt);

        JPanel btnsPanel = new JPanel(new FlowLayout());
        confirmBtn = new JButton("确认");
        cancelBtn = new JButton("取消");
        confirmBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        btnsPanel.add(confirmBtn);
        btnsPanel.add(cancelBtn);

        this.getContentPane().add(namePanel, BorderLayout.NORTH);
        this.getContentPane().add(pathPanel, BorderLayout.CENTER);
        this.getContentPane().add(btnsPanel, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cancelBtn) {
            this.dispose();
        }

        if (e.getSource() == confirmBtn) {
            newFileName = this.nameTxt.getText();
            path = this.pathTxt.getText();
            this.dispose();
        }

    }
}
