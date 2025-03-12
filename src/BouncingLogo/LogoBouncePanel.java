
package BouncingLogo;

import java.awt.Color;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class LogoBouncePanel extends JPanel implements Runnable {
    int x =0;
    int y = 0;
    int Xdirect = 1;
    int Ydirect =1;
    JLabel label = new JLabel();
    public LogoBouncePanel(){
        
        new Thread (this).start();
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null); //to start from corner

        ImageIcon logo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/dvd.png")));
        label = new JLabel(logo); //label to contain my logo
        label.setBounds(x, y, logo.getIconWidth(), logo.getIconHeight()); //logo dimensions 
        this.add(label);
        
        
        
    }
     
    
    @Override
    public void run(){
        while (true){
            x += Xdirect;
            y += Ydirect;
            
             if (x <= 0 || x + label.getWidth() >= getWidth()) {
                Xdirect = -Xdirect;      
             }
             if (y <= 0 || y + label.getHeight() >= getHeight()) {
                Ydirect = -Ydirect;      
             }
             SwingUtilities.invokeLater(() -> label.setBounds(x, y, label.getWidth(), label.getHeight()));

             
             label.setBounds(x, y, label.getWidth(), label.getHeight());
            
            try {
                Thread.sleep(10); 
            } catch (InterruptedException ex) {
                Logger.getLogger(LogoBouncePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
        }
}
    
