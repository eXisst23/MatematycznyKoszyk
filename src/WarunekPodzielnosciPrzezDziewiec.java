public class WarunekPodzielnosciPrzezDziewiec extends Warunek {

    public WarunekPodzielnosciPrzezDziewiec(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba parzysta";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 9 == 0;
    }
}
