/**
 * Klasa Liniowy managerLiczb tworzy przebieg liniowy po którym spadają liczby
 */

public class LiniowyMenagerLiczb extends MenagerLiczb {

    /**
     * Konstruktor klasy LinikowyManagerLiczb.
     */

    public LiniowyMenagerLiczb(Pozycja pozycja, GamePanel gp) {
        super(pozycja, gp);
    }

    @Override
    public void update() {
        for (Liczba liczba : liczby) {
            liczba.getPozycja().setY(liczba.getPozycja().getY() + (3/2));
        }
    }
}
