public class WarunekPodzielnosciPrzezPiec extends Warunek {

    public WarunekPodzielnosciPrzezPiec(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba podzielna przez piec";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 5 == 0;
    }
}