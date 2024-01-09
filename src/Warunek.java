import java.awt.*;

/**
 * Klasa warunek sprawdaz czy warunki są spełnione
 */

public abstract class Warunek {

    protected String nazwa;
    private Font font;
    private GamePanel gamePanel;

    /**
     * Konstruktor klasy Warunek.
     */

    public Warunek(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.font = new Font ("Courier New", 1, 32);
    }

    public abstract Boolean czySpelniony(int liczba);

    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.setFont (font);
        g2.drawString(nazwa, 15, 925);
    }

}
