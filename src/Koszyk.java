import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * Klasa Opisująca poruszający sie koszyk
 */
public class Koszyk extends ObiektGry {

    KeyHandler keyH;
    private int speed;
    boolean pauza;

    /**
     * Konstruktor klasy Koszyk.
     */

    public Koszyk(GamePanel gp, KeyHandler keyH) {

        super(new Pozycja(440, 815), new Rozmiar(80, 120), gp);
        this.keyH = keyH;
        this.speed = 10;
        this.pauza = false;
        getPlayerImage();
    }

    private void getPlayerImage() {

        try {
            this.setObraz(ImageIO.read(getClass().getResourceAsStream("pliki/kosz3.png")));
        } catch (IOException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update() {

        if(keyH.leftPressed){
            if (getPozycja().getX() - speed > 0 ) getPozycja().setX(getPozycja().getX() - speed);
        }
        else if(keyH.rightPressed){
            if (getPozycja().getX() + speed + getRozmiar().getSzerokosc() < getGp().getWidth() ) getPozycja().setX(getPozycja().getX() + speed);
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(getObraz(), getPozycja().getX(), getPozycja().getY(), getRozmiar().getSzerokosc(), getRozmiar().getWysokosc(), null);
    }
}
