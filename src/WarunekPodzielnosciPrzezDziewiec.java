public class WarunekPodzielnosciPrzezDziewiec extends Warunek {

    public WarunekPodzielnosciPrzezDziewiec(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba podzielna przez 9";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 9 == 0;
    }
}
