
package BouncingLogo;

import javax.swing.JFrame;

public class BouncingFrame {
    public static void main (String[] argv){
        
        JFrame f = new JFrame();
        LogoBouncePanel logo = new LogoBouncePanel();
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setTitle("Bouncing Logo");
        f.setContentPane(logo);
        f.setSize(400, 300);
        f.setVisible(true);
        
    }
}
