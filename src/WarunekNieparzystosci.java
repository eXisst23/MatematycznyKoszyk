/**
 * Klasa WarunekNieparzystosci sprawdza czy liczba zapana przez koszyk jest nieparzysta
 */

public class WarunekNieparzystosci extends Warunek {

    /**
     * Konstruktor klasy WarunekNieparzystości.
     */

    public WarunekNieparzystosci(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba nieparzysta";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 2 == 1;
    }
}