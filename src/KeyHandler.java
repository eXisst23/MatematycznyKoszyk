import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Klasa do obsługi przycisków.
 */
public class KeyHandler implements KeyListener {

    public boolean leftPressed;
    public boolean rightPressed;
    public boolean pausePressed;
    public boolean wznowPressed;
    public boolean menu;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }

        if (code == KeyEvent.VK_P) {
            pausePressed = true;
        }

        if (code == KeyEvent.VK_O) {
            wznowPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

        if (code == KeyEvent.VK_P) {
            pausePressed = false;
        }

        if (code == KeyEvent.VK_O) {
            wznowPressed = false;
        }

        if (code == KeyEvent.VK_I) {
            menu = true;
        }
    }
}
