import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    Koszyk koszyk = new Koszyk(this, keyH);

    Random random = new Random();
    Ziemia ziemia;
    int FPS = 60;
    GameFrame gameFrame;

    List<MenagerLiczb> menageryLiczb;

    Warunek aktywnyWarunek;

    List<Warunek> warunki;

    private Font font;
    int punkty;
    int zycia;

    int iterator;


    public GamePanel(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        this.setPreferredSize(new Dimension(1280,1024));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setSize(new Dimension(1280,1024));
        this.ziemia = new Ziemia(this);
        this.menageryLiczb = new ArrayList<>();
        this.menageryLiczb.add(new LiniowyMenagerLiczb(new Pozycja(440, 10), this));
        this.menageryLiczb.add(new SinusoidalnyMenagerLiczb(new Pozycja(690, 10), this));
        this.warunki = new ArrayList<>();
        this.warunki.add(new WarunekParzystosci(this));
        this.warunki.add(new WarunekNieparzystosci(this));
        this.warunki.add(new WarunekPodzielnosciPrzezTrzy(this));
        this.warunki.add(new WarunekPodzielnosciPrzezPiec(this));
        this.warunki.add(new WarunekPodzielnosciPrzezDziewiec(this));
        this.aktywnyWarunek = warunki.getFirst();
        this.punkty = 0;
        this.iterator = 0;
        this.zycia = 2;
        this.font = new Font ("Courier New", 1, 32);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){

            input();

            if (!koszyk.pauza) {
                update();
                gameFrame.repaint();
                repaint();

                for (MenagerLiczb menagerLiczb : menageryLiczb) {
                    menagerLiczb.generujLiczbe();
                }

                if (zycia == 0) {
                    gameThread = null;
                }
            }
            try{

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime /1000000;

                if(remainingTime < 0){

                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
        for(MenagerLiczb menagerLiczb : menageryLiczb) {
            menagerLiczb.update();
        }

        koszyk.update();

        sprawdzKolizjeKoszyk();
        sprawdzKolizjeZiemia();
        nowyWarunek();
    }

    public void input() {
        if (keyH.pausePressed) {
            koszyk.pauza = true;
        }
        else if (keyH.wznowPressed) {
            koszyk.pauza = false;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;

        tlo(g2);

        for(MenagerLiczb menagerLiczb : menageryLiczb) {
            menagerLiczb.draw(g2);
        }

        koszyk.draw(g2);
        ziemia.draw(g2);

        //przyciski

        aktywnyWarunek.draw(g2);
        drawScoreAndLifes(g2);
        pauzaString(g2);

        if (zycia == 0) {
            gameOver(g2);
        }
        g2.dispose();

    }

    public void drawScoreAndLifes(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.setFont (font);
        g2.drawString("ZYCIA: " + zycia, 15, 30);
        g2.drawString("PUNKTY: " + punkty, 950, 30);
    }

    public void gameOver(Graphics2D g2) {
        g2.setFont (font);
        g2.drawString("KONIEC GRY", 440, 400);
        g2.drawString("PUNKTY: " + punkty, 440, 450);
    }

    public void pauzaString(Graphics2D g2) {
        if (koszyk.pauza) {
            g2.setFont(font);
            g2.drawString("PAUZA", 440, 400);
        }
    }

    private void sprawdzKolizjeKoszyk() {
        for(MenagerLiczb menagerLiczb : menageryLiczb) {
            for (Liczba liczba : menagerLiczb.getLiczby()) {
                if (koszyk.czyKolizja(liczba) && !liczba.czyZebrana()) {
                    liczba.setCzyZebrana(true);
                    if (aktywnyWarunek.czySpelniony(liczba.getWartosc())) {
                        punkty++;
                        iterator++;
                    } else {
                        zycia--;
                    }
                }
            }
        }
    }

    private void sprawdzKolizjeZiemia() {
        for(MenagerLiczb menagerLiczb : menageryLiczb) {
            for (Liczba liczba : menagerLiczb.getLiczby()) {
                if (ziemia.czyKolizja(liczba) && !liczba.czyZebrana()) {
                    liczba.setCzyZebrana(true);
                    if (aktywnyWarunek.czySpelniony(liczba.getWartosc())) {
                        zycia--;
                    } else {
                        punkty++;
                        iterator++;
                    }
                }
            }
        }
    }

    private void nowyWarunek() {
        if (iterator != 0 && iterator % 2 == 0) {
            iterator = 0;
            aktywnyWarunek = warunki.get(random.nextInt(warunki.size()));
        }
    }

    private void tlo(Graphics2D g2) {
        try {
            Image image = ImageIO.read(new File("src/pliki/tlo7.png"));
            g2.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
