package osdesign.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pokerface_lx
 */
public class ToastFrame extends JFrame implements ActionListener {

    private JButton confirmBtn;

    public ToastFrame(String toast) {

        this.setLayout(new BorderLayout());

        JPanel toastPanel = new JPanel(new FlowLayout());
        JLabel toastLabel = new JLabel(toast);
        toastPanel.add(toastLabel);

        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton blankBtn = new JButton("占位");
        confirmBtn = new JButton("确认");
        confirmBtn.addActionListener(this);
        btnPanel.add(blankBtn);
        btnPanel.add(confirmBtn);
        blankBtn.setVisible(false);

        this.getContentPane().add(toastPanel, BorderLayout.NORTH);
        this.getContentPane().add(btnPanel, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
