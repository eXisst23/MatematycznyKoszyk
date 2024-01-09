/**
 * Rozmiar moowi o rozmiarze obiektów
 */

public class Rozmiar {

    private  int wysokosc;
    private int szerokosc;

    /**
     * Konstruktor klasy Rozmiar.
     */

    public Rozmiar(int wysokosc, int szerokosc) {
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }
}
