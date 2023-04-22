package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GetKey implements KeyListener {

    GamePanel gp;

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
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) gp.player.setMoveLeft(true);
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) gp.player.setMoveRight(true);

        //Menu state
//        if(gp.gameState == gp.menuGameState)
//        {
//            if(code == KeyEvent.VK_UP)
//            {
//                gp.ui.setFlagNum(gp.ui.getFlagNum() - 1);
//                if(gp.ui.getFlagNum() < 0)
//                {
//                    gp.ui.setFlagNum(1);
//                }
//            }
//            if(code == KeyEvent.VK_DOWN)
//            {
//                gp.ui.setFlagNum(gp.ui.getFlagNum() + 1);
//                if(gp.ui.getFlagNum() > 1)
//                {
//                    gp.ui.setFlagNum(0);
//                }
//            }
//            if(code == KeyEvent.VK_ENTER)
//            {
//                if(gp.ui.getFlagNum() == 0) gp.gameState = gp.playGameState;
//                if(gp.ui.getFlagNum() == 1) gp.gameState = gp.quitGameState;
//            }
//        }

        //Pause state
        if(code == KeyEvent.VK_P )
        {
            gp.gameState = gp.pauseGameState;
        }

        //Over game state
//        if(gp.gameState == gp.overGameState)
//        {
//            if(code == KeyEvent.VK_UP)
//            {
//                gp.ui.setFlagNum(gp.ui.getFlagNum() - 1);
//                if(gp.ui.getFlagNum() < 0)
//                {
//                    gp.ui.setFlagNum(2);
//                }
//            }
//            if(code == KeyEvent.VK_DOWN)
//            {
//                gp.ui.setFlagNum(gp.ui.getFlagNum() + 1);
//                if(gp.ui.getFlagNum() > 2)
//                {
//                    gp.ui.setFlagNum(0);
//                }
//            }
//            if(code == KeyEvent.VK_ENTER)
//            {
//                if(gp.ui.getFlagNum() == 0) gp.save = true;
//                if(gp.ui.getFlagNum() == 1) gp.gameState = gp.resetGameState;
//                if(gp.ui.getFlagNum() == 2) gp.gameState = gp.quitGameState;
//            }
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) gp.player.setMoveLeft(false);
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) gp.player.setMoveRight(false);
    }
}
