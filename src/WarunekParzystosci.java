/**
 * Klasa WarunekParzystosci sprawdza czy liczby zlapane przez koszyk sa parzyste
 */

public class WarunekParzystosci extends Warunek {

    /**
     * Konstruktor klasy WarunekParzystości.
     */

    public WarunekParzystosci(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba parzysta";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 2 == 0;
    }
}
