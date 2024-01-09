import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/**
 * Klasa obsługująca gre
 */
public class GameFrame extends JFrame {
    GamePanel gamePanel;

    /**
     * Konstruktor klasy Game Frame.
     */
    public GameFrame() {

        setTitle("Matematyczny koszyk - Gra");
        this.gamePanel = new GamePanel(this);
        this.setSize(new Dimension(1280,1024));
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.startGameThread();

    }
}
