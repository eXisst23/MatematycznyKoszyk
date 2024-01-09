public class SinusoidalnyMenagerLiczb extends MenagerLiczb {

    public SinusoidalnyMenagerLiczb(Pozycja pozycja, GamePanel gp) {
        super(pozycja, gp);
    }

    @Override
    public void update() {

        for (Liczba liczba : liczby) {
            liczba.getPozycja().setX((int)(100 * Math.sin((double) (liczba.getPozycja().getY() + 1) / 100)) + pozycjaStartowa.getX());
            liczba.getPozycja().setY(liczba.getPozycja().getY() + (3/2));
        }
    }
}
