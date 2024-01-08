import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameFrame extends JFrame {
    GamePanel gamePanel;
    public GameFrame() {

        setTitle("Matematyczny koszyk - Gra");

//        try {
//            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pliki/tlo2.png")))));
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
        this.gamePanel = new GamePanel(this);
        this.setSize(new Dimension(1280,1024));
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.startGameThread();

    }
}
