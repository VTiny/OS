package osdesign.frame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pokerface_lx
 */
public class LoginFrame extends JFrame {

    public LoginFrame(String title) {
//        JFrame loginFrame = new JFrame("登录");
//        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        loginFrame.setSize(500, 300);
//        loginFrame.setLocationRelativeTo(null);
//
//        loginFrame.setVisible(true);
        super(title);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(getNamePanel(), BorderLayout.NORTH);
        this.setVisible(true);
    }

    /***
     * 返回用户名的面板
     * @return
     */
    private Component getNamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("用户名");
        JTextField name = new JTextField();
        panel.add(label, BorderLayout.WEST);
        panel.add(name, BorderLayout.CENTER);
        return panel;
    }


}
