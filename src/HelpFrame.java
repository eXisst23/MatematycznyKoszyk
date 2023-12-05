import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.imageio.*;
import javax.swing.JLabel;
import javax.swing.JPanel;




/**
 * Klasa HelpFrame.
 */
public class HelpFrame extends JFrame implements ActionListener {



    /** Przycisk powrotu do glownego menu. */
    JButton powrot;
    JLabel instrukcja;

    /**
     * Konstruktor klasy HelpFrame.
     */
    public HelpFrame() {
        setBounds(0, 0, 1280, 1024);
        setResizable(false);
        setTitle("Matematyczny koszyk");
        this.setLayout(null);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pliki/tlo.png")))));
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        instrukcja = new JLabel("<HTML><body style='text-align:justify;background-color:ccf5ff; color:black;'Siema");
        instrukcja.setLayout(new GridLayout(0, 1));
        instrukcja.setBounds(340, 150, 600, 500);
        instrukcja.setFont(new Font("Times New Roman", Font.BOLD, 30));
        this.add(instrukcja);


        ImageIcon buttonBack = new ImageIcon("src/pliki/buttonback.png");
        powrot = new JButton("", buttonBack);
        powrot.setBounds(525, 700, 235, 50);
        powrot.setBackground(Color.white);
        powrot.setOpaque(false);
        powrot.setBorderPainted(false);
        powrot.setContentAreaFilled(false);
        powrot.addActionListener(this);
        this.add(powrot);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        int x = this.getLocationOnScreen().x;
        int y = this.getLocationOnScreen().y;



        if(e.getSource() == powrot) {

            MainFrame main = new MainFrame();
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setAlwaysOnTop(true);
            main.setVisible(true);
            main.setBounds(x, y, 1280, 1024);
            this.dispose();


        }

    }
}