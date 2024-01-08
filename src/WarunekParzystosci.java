public class WarunekParzystosci extends Warunek {

    public WarunekParzystosci(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba parzysta";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 2 == 0;
    }
}
