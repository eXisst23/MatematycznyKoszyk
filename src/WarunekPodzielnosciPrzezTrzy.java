public class WarunekPodzielnosciPrzezTrzy extends Warunek {

    public WarunekPodzielnosciPrzezTrzy(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba podzielna przez 3";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 3 == 0;
    }
}
