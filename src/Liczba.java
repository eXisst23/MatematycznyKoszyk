import java.awt.*;

public class Liczba extends ObiektGry {

    private int wartosc;
    private boolean czyZebrana;

    private Font font;

    public Liczba(Pozycja pozycja, GamePanel gp, int wartosc) {
        super(pozycja, gp);
        this.wartosc = wartosc;
        this.czyZebrana = false;
        this.font = new Font ("Courier New", 1, 20);
        setRozmiar(new Rozmiar(50, 50));
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public boolean czyZebrana() {
        return czyZebrana;
    }

    public void setCzyZebrana(boolean czyZebrana) {
        this.czyZebrana = czyZebrana;
    }

    @Override
    public void draw(Graphics2D g2) {
        if (!czyZebrana) {
            g2.setColor(Color.YELLOW);
            g2.fillRect(getPozycja().getX(), getPozycja().getY(), getRozmiar().getSzerokosc(), getRozmiar().getWysokosc());
            g2.setColor(Color.BLACK);
            g2.setFont (font);
            g2.drawString(String.valueOf(wartosc), getPozycja().getX() + 5, getPozycja().getY() + getRozmiar().getWysokosc() / 2 + 5);
        }
    }
    @Override
    public void update() {}
}
