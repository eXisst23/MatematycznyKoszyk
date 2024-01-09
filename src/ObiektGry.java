import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Abstrakcyjna klasa opisująca obiekty
 */

public abstract class ObiektGry {

    private Pozycja pozycja;
    private Rozmiar rozmiar;
    private Image obraz;
    private GamePanel gp;

    /**
     * Konstruktor klasy ObiektGry.
     */

    public ObiektGry(Pozycja pozycja, Rozmiar rozmiar, GamePanel gp) {
        this.pozycja = pozycja;
        this.rozmiar = rozmiar;
        this.gp = gp;
    }

    public ObiektGry(Pozycja pozycja, GamePanel gp) {
        this.pozycja = pozycja;
        this.gp = gp;
    }

    public ObiektGry(GamePanel gp) {
        this.gp = gp;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    public void setPozycja(Pozycja pozycja) {
        this.pozycja = pozycja;
    }

    public Rozmiar getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(Rozmiar rozmiar) {
        this.rozmiar = rozmiar;
    }

    public Image getObraz() {
        return obraz;
    }

    public void setObraz(Image obraz) {
        this.obraz = obraz;
    }

    public GamePanel getGp() {
        return gp;
    }

    public Boolean czyKolizja(ObiektGry innyObiekt) {
        if (this.getPozycja().getX() < innyObiekt.getPozycja().getX() + innyObiekt.getRozmiar().getSzerokosc() &&
            this.getPozycja().getX() + this.getRozmiar().getSzerokosc() > innyObiekt.getPozycja().getX() &&
            this.getPozycja().getY() < innyObiekt.getPozycja().getY() + innyObiekt.getRozmiar().getWysokosc() &&
            this.getPozycja().getY() + this.getRozmiar().getWysokosc() > innyObiekt.getPozycja().getY()
        ) {
            return true;
        }

        return false;
    }

    public abstract void draw(Graphics2D g2);

    public abstract void update();

}
