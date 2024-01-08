import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener {

    JLabel title;

    JButton play;

    JButton help;

    JButton exit;

    JButton result;
    private ActionEvent e;

    public MainFrame() {

        setBounds(0,0,1280,1024);
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
        play.setBounds(56, 573, 250, 180);
        play.setBackground(Color.white);
        play.setOpaque(false);                              /** Ustawia przezroczystość */
        play.setBorderPainted(false);                       /** Usuwa Obramowanie */
        play.setContentAreaFilled(false);
        play.addActionListener(this);
        this.add(play);


        ImageIcon buttonResult = new ImageIcon("src/pliki/wyniki.png");
        result = new JButton("", buttonResult);
        result.setBounds(362, 573, 250, 180);
        result.setBackground(Color.WHITE);
        result.setOpaque(false);
        result.setBorderPainted(false);
        result.setContentAreaFilled(false);
        result.addActionListener(this);
        this.add(result);


        ImageIcon buttonHelp = new ImageIcon("src/pliki/pomoc.png");
        help = new JButton("", buttonHelp);
        help.setBounds(668, 573, 250, 180);
        help.setBackground(Color.WHITE);
        help.setOpaque(false);
        help.setBorderPainted(false);
        help.setContentAreaFilled(false);
        help.addActionListener(this);
        this.add(help);


        ImageIcon buttonExit = new ImageIcon("src/pliki/wyjscie.png");
        exit = new JButton("", buttonExit);
        exit.setBounds(974, 573, 250, 180);
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
            help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            help.setAlwaysOnTop(true);
            help.setVisible(true);
            help.setBounds(x, y, 1280, 1024);
            this.dispose();
        }
        else if(e.getSource() == result) {

            ResultsFrame results = new ResultsFrame();
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setAlwaysOnTop(true);
            results.setVisible(true);
            results.setBounds(x, y, 1280, 1024);
            this.dispose();

        }else if(e.getSource() == play){

            GameFrame game = new GameFrame();
//            String imagePath = "src/pliki/tlo2.png";
//            JPanel panel = new ImageBackGroundPanel("src/pliki/tlo2.png");
//            game.getContentPane().add(panel);
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
