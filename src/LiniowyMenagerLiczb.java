public class LiniowyMenagerLiczb extends MenagerLiczb {
    public LiniowyMenagerLiczb(Pozycja pozycja, GamePanel gp) {
        super(pozycja, gp);
    }

    @Override
    public void update() {
        for (Liczba liczba : liczby) {
            liczba.getPozycja().setY(liczba.getPozycja().getY() + 1);
        }
    }
}
