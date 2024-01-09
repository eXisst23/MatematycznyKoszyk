import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasa zajmuująca się tworzeniem, generowaniem liczb
 */

public abstract class MenagerLiczb {

    protected List<Liczba> liczby;
    protected Pozycja pozycjaStartowa;
    private int licznik;
    private Random rand;
    private GamePanel gp;

    public MenagerLiczb(Pozycja pozycja, GamePanel gp) {
        this.pozycjaStartowa = pozycja;
        this.liczby = new ArrayList<>();
        this.rand = new Random();
        this.gp = gp;
        this.licznik = 0;
    }

    public List<Liczba> getLiczby() {
        return liczby;
    }

    private void stworzLiczbe() {
        liczby.add(new Liczba(new Pozycja(pozycjaStartowa.getX(), pozycjaStartowa.getY()), gp, rand.nextInt(1,100)));
    }

    public abstract void update();

    public void draw(Graphics2D g2) {
        for(Liczba liczba : liczby) {
            liczba.draw(g2);
        }
    }

    public void generujLiczbe() {
        this.licznik ++;
        if ((rand.nextInt(3000) <= 25) && licznik > 200) {
            this.licznik = 0;
            stworzLiczbe();
        }
    }
}
