/**
 * Klasa WarunekPodzielnosciPrzezPiec sprawdza czy liczby zlapane przez koszyk sa podzielne przez piec
 */

public class WarunekPodzielnosciPrzezPiec extends Warunek {

    /**
     * Konstruktor klasy WarunekPodzielnosciPrzezPiec.
     */

    public WarunekPodzielnosciPrzezPiec(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba podzielna przez piec";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 5 == 0;
    }
}