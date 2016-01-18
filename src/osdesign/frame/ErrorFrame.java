package osdesign.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pokerface_lx
 */
public class ErrorFrame extends BaseFrame implements ActionListener {

    private JButton confirmBtn;
    private JButton cancelBtn;

    public ErrorFrame(String error) {
        this.setTitle("错误");
        this.setLayout(new BorderLayout());

        JLabel errorLabel = new JLabel(error, 200);
        this.getContentPane().add(errorLabel, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new FlowLayout());
        confirmBtn = new JButton("确认");
        cancelBtn = new JButton("取消");
        confirmBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        btnPanel.add(cancelBtn);
        btnPanel.add(confirmBtn);
        cancelBtn.setVisible(false);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
