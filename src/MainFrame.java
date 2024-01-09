import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Klasa obsługi menu.
 */

public class MainFrame extends JFrame implements ActionListener {

    JLabel title;
    JButton play;
    JButton help;
    JButton exit;

    /**
     * Konstruktor klasy Main Frame.
     */

    public MainFrame() {

        setSize(1280, 1024);
        setResizable(false);
        setTitle("Matematyczny koszyk");
        this.setLayout(null);


        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pliki/tlo7.png")))));
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        ImageIcon labelTitle = new ImageIcon("src/pliki/MATEMATYCZNY.png");
        title = new JLabel(labelTitle);
        title.setBounds(140, 100, 1000, 280);
        this.add(title);


        ImageIcon buttonPlay = new ImageIcon("src/pliki/graj.png");
        play = new JButton("", buttonPlay);
        play.setBounds(200, 575, 250, 180);
        play.setBackground(Color.white);
        play.setOpaque(false);                              /** Ustawia przezroczystość */
        play.setBorderPainted(false);                       /** Usuwa Obramowanie */
        play.setContentAreaFilled(false);
        play.addActionListener(this);
        this.add(play);


        ImageIcon buttonHelp = new ImageIcon("src/pliki/pomoc.png");
        help = new JButton("", buttonHelp);
        help.setBounds(525, 575, 250, 180);
        help.setBackground(Color.WHITE);
        help.setOpaque(false);
        help.setBorderPainted(false);
        help.setContentAreaFilled(false);
        help.addActionListener(this);
        this.add(help);


        ImageIcon buttonExit = new ImageIcon("src/pliki/wyjscie.png");
        exit = new JButton("", buttonExit);
        exit.setBounds(850, 573, 250, 180);
        exit.setBackground(Color.WHITE);
        exit.setOpaque(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        this.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int x = this.getLocationOnScreen().x;
        int y = this.getLocationOnScreen().y;

        if(e.getSource() == help) {

            HelpFrame help = new HelpFrame();
            help.setSize(1280, 1024);
            help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            help.setAlwaysOnTop(true);
            help.setVisible(true);
            help.setBounds(x, y, 1280, 1024);
            this.dispose();

        }else if(e.getSource() == play){

            GameFrame game = new GameFrame();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(1280, 1024);
            game.setAlwaysOnTop(true);
            game.pack();
            game.setVisible(true);
            game.setBounds(x, y, 1280, 1024);
            this.dispose();

        }
        else if(e.getSource() == exit){
            System.exit(0);
        }
        else {
            this.dispose();
        }
    }
}
