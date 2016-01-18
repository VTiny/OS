package osdesign.frame;

import javax.swing.*;

/**
 * Created by pokerface_lx
 */
public class BaseFrame extends JFrame {

    public BaseFrame() {
//        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
