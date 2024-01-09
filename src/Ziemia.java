import java.awt.*;

/**
 * Klasa opisujący obiekt ziemi czyli miejsca gdzie robijaja sie liczby jezeli nie zostały złapane przez koszyk
 */

public class Ziemia extends ObiektGry{

    /**
     * Konstruktor klasy Ziemia.
     */

    public Ziemia(GamePanel gamePanel) {
        super(gamePanel);
        setPozycja(new Pozycja(0, 890));
        setRozmiar(new Rozmiar(50, gamePanel.getWidth()));
    }

    /**
     * Funkacja do rysowania prostokąta(naszej ziemi)
     */

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(getPozycja().getX(), getPozycja().getY(), getRozmiar().getSzerokosc(), getRozmiar().getWysokosc());
    }

    @Override
    public void update() {

    }
}
