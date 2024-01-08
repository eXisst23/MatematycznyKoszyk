import java.awt.*;

public class Ziemia extends ObiektGry{

    public Ziemia(GamePanel gamePanel) {
        super(gamePanel);
        setPozycja(new Pozycja(0, 890));
        setRozmiar(new Rozmiar(50, gamePanel.getWidth()));
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(getPozycja().getX(), getPozycja().getY(), getRozmiar().getSzerokosc(), getRozmiar().getWysokosc());
    }

    @Override
    public void update() {

    }
}
