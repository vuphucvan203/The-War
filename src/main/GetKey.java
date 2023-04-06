package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GetKey implements KeyListener {

    public boolean moveLeft, moveRight;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) moveLeft = true;
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) moveRight = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) moveLeft = false;
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) moveRight = false;
    }
}
