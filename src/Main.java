import javax.swing.*;
import java.awt.*;



public class Main {
    public static void main(String[] args) {

        MainFrame frame =  new MainFrame();
        frame.setSize(1280, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
    }
}


