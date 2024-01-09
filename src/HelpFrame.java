import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.*;
import javax.swing.*;

public class HelpFrame extends JFrame implements ActionListener {



    /** Przycisk powrotu do glownego menu. */
    JButton powrot;
    JTextArea textArea;

    /**
     * Konstruktor klasy HelpFrame.
     */
    public HelpFrame() {
        setBounds(0, 0, 1280, 1024);
        setResizable(false);
        setTitle("Matematyczny koszyk - HELP");
        this.setLayout(null);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pliki/tlo8.png")))));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        textArea = new JTextArea(" Gra polega na tym, że na środku ekranu są przedstawione 2 tory. " +
                "Na dole ekranu będzie stał koszyk." + " Na dole ekranu bedzie ukazany warunek, który bedzie " +
                "zmieniany w trakcie gry. Z góry będą spadać liczby. Zadaniem gracza będzie łapanie liczb spełniających " +
                "warunek. Jeżeli liczba spełniająca warunek nie zostanie złapana to gracz traci życie. Po " +
                "utracie 3 żyć gracz przegrywa.\n - jeżeli chcesz zatrzymać gre wciśnij P \n - jeżeli chcesz wznowić gre wciśnij O \n - jeżeli chcesz wrócić do menu wciśnij I");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBackground(new Color(0, 0, 0, 0));
        textArea.setLayout(new GridLayout(0,1));
        textArea.setBounds(340, 150, 600, 500);
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 30));
        textArea.setForeground(Color.BLACK);
        this.add(textArea);


        ImageIcon buttonBack = new ImageIcon("src/pliki/buttonback.png");
        powrot = new JButton("", buttonBack);
        powrot.setBounds(525, 700, 241, 75);
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