public class WarunekNieparzystosci extends Warunek {

    public WarunekNieparzystosci(GamePanel gamePanel) {
        super(gamePanel);
        nazwa = "Liczba nieparzysta";
    }

    @Override
    public Boolean czySpelniony(int liczba) {
        return liczba % 2 == 1;
    }
}