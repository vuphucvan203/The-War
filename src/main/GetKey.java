package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GetKey implements KeyListener {

    GamePanel gp;
    public boolean moveLeft, moveRight;

    public GetKey(GamePanel gp)
    {
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) moveLeft = true;
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) moveRight = true;
        if(code == KeyEvent.VK_SPACE) gp.gameState = gp.playGameState;
        if(code == KeyEvent.VK_P )
        {
            if(gp.gameState == gp.playGameState)
            {
                gp.gameState = gp.pauseGameState;
            }
            else if(gp.gameState == gp.pauseGameState)
            {
                gp.gameState = gp.playGameState;
            }
        }
        if(code == KeyEvent.VK_ENTER) gp.gameState = gp.resetGameState;
        if(code == KeyEvent.VK_ESCAPE) gp.gameState = gp.quitGameState;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) moveLeft = false;
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) moveRight = false;
    }
}
