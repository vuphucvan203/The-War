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

        //Move
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) moveLeft = true;
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) moveRight = true;

        //Menu state
        if(gp.gameState == gp.menuGameState)
        {
            if(code == KeyEvent.VK_UP)
            {
                gp.ui.flagNum--;
                if(gp.ui.flagNum < 0)
                {
                    gp.ui.flagNum = 2;
                }
            }
            if(code == KeyEvent.VK_DOWN)
            {
                gp.ui.flagNum++;
                if(gp.ui.flagNum > 2)
                {
                    gp.ui.flagNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER)
            {
                if(gp.ui.flagNum == 0) gp.gameState = gp.playGameState;
                if(gp.ui.flagNum == 1) gp.gameDiary = true;
                if(gp.ui.flagNum == 2) gp.gameState = gp.quitGameState;
            }
        }

        //Pause state
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

        //Over game state
        if(gp.gameState == gp.overGameState)
        {
            if(code == KeyEvent.VK_UP)
            {
                gp.ui.flagNum--;
                if(gp.ui.flagNum < 0)
                {
                    gp.ui.flagNum = 2;
                }
            }
            if(code == KeyEvent.VK_DOWN)
            {
                gp.ui.flagNum++;
                if(gp.ui.flagNum > 2)
                {
                    gp.ui.flagNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER)
            {
                if(gp.ui.flagNum == 0) gp.save = true;
                if(gp.ui.flagNum == 1) gp.gameState = gp.resetGameState;
                if(gp.ui.flagNum == 2) gp.gameState = gp.quitGameState;
            }
        }
        if(code == KeyEvent.VK_S) gp.save = true;

        if(code == KeyEvent.VK_ESCAPE) gp.gameState = gp.quitGameState;
        if(code == KeyEvent.VK_G)
        {
            if(gp.gameDiary == true)
            {
                gp.gameDiary = false;
            }
            else if(gp.gameDiary == false)
            {
                gp.gameDiary = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) moveLeft = false;
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) moveRight = false;
    }
}
