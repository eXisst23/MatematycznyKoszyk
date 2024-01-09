/**
 * Klasa WarunekPodzielnosciprzezdziewiec sprawdza czy liczby zlapane przez koszyk sa podzielne przez 9
 */

public class WarunekPodzielnosciPrzezDziewiec extends Warunek {

    /**
     * Konstruktor klasy WarunekPodzielnosciPrzezDziewiec.
     */

    public WarunekPodzielnosciPrzezDziewiec(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba podzielna przez 9";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 9 == 0;
    }
}
