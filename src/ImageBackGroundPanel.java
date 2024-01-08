import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class ImageBackGroundPanel extends JPanel {
    private Image backgroundImage;

    public ImageBackGroundPanel(String imagePath) {
        try {
            // Wczytaj obraz z pliku
            backgroundImage = ImageIO.read(new File("src/pliki/tlo2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Rysuj tło obrazem
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
