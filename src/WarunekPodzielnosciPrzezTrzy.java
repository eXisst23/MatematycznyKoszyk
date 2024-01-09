/**
 * Klasa WarunekPodzielnosciPrzezTrzy
 */

public class WarunekPodzielnosciPrzezTrzy extends Warunek {

    /**
     * Konstruktor klasy WarunekPodzielnosciPrzezTrzy.
     */

    public WarunekPodzielnosciPrzezTrzy(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba podzielna przez 3";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 3 == 0;
    }
}
