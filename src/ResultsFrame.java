import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.imageio.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;


/**
 * Klasa ResultsFrame.
 */
public class ResultsFrame extends JFrame implements ActionListener {



    /** Przycisk powrotu do głownego menu. */
    JButton powrot;

    /**
     * Konstruktor klasy ResultsFrame.
     */
    public ResultsFrame() {
        setBounds(0, 0, 1280, 1024);
        setResizable(false);
        setTitle("Matematyczny koszyk - WYNIKI");
        this.setLayout(null);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pliki/tlo7.png")))));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(0, 1));
        JScrollPane jsp = new JScrollPane(jp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setBounds(340, 150, 600, 500);
        this.getContentPane().add(jsp);

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Piotr-Game/Desktop/Studia/Semestr 5/WJP/Projekt/MatematycznyKoszyk/src/pliki/wyniki.txt"));
            String line;
            int cnt = 0;
            while((line = br.readLine()) != null) {
                JLabel entry = new JLabel();
                entry.setBounds(0, cnt*60, 500, 60);
                entry.setOpaque(true);
                entry.setBackground(new Color(0, 0,0, 0));
                entry.setForeground(new Color(0, 0, 0,0));
                entry.setFont(new Font("Times New Roman", Font.BOLD, 30));
                entry.setVerticalAlignment(SwingConstants.CENTER);
                entry.setHorizontalAlignment(SwingConstants.CENTER);
                entry.setText(line);
                jp.add(entry);
            }
        } catch (Exception e) {

        }

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

            MainFrame main = new MainFrame();main.pack();
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setAlwaysOnTop(true);
            main.setVisible(true);
            main.setBounds(x, y, 1280, 1024);
            this.dispose();
        }
    }
}