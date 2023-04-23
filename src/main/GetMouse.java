package main;

import javax.swing.event.MouseInputListener;
import java.awt.event.*;

public class GetMouse implements MouseListener, MouseMotionListener, MouseInputListener {

    GamePanel gp;
    public static int mouseX, mouseY;
    public GetMouse(GamePanel gp)
    {
        this.gp = gp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        /* Menu game */

        if(gp.gameState == gp.menuGameState)
        {
            // Play button
            if(mouseX >= gp.unitSize * 9 && mouseX <= gp.unitSize * 11 && mouseY >= gp.unitSize * 13 && mouseY <= gp.unitSize * 14)
            {
                gp.gameState = gp.playGameState;
            }

            // Quit button
            if(mouseX >= gp.unitSize * 9 && mouseX <= gp.unitSize * 11 && mouseY >= gp.unitSize * 15 && mouseY <= gp.unitSize * 16)
            {
                gp.gameState = gp.quitGameState;
            }
        }


        /* Over game */

        if(gp.gameState == gp.overGameState)
        {
            // Reset button
            if(mouseX >= gp.unitSize * 7 && mouseX <= gp.unitSize * 13 && mouseY >= gp.unitSize * 15 && mouseY <= gp.unitSize * 16)
            {
                gp.save = true;
            }

            // Save button
            if(mouseX >= gp.unitSize * 7 && mouseX <= gp.unitSize * 13 && mouseY >= gp.unitSize * 17 && mouseY <= gp.unitSize * 18)
            {
                gp.gameState = gp.resetGameState;
            }
            // Quit button
            if(mouseX >= gp.unitSize * 9 && mouseX <= gp.unitSize * 11 && mouseY >= gp.unitSize * 19 && mouseY <= gp.unitSize * 20)
            {
                gp.gameState = gp.quitGameState;
            }
        }


       /* Pause */

        if(gp.gameState == gp.pauseGameState)
        {
            // continue button
            if(mouseX >= gp.unitSize * 8 && mouseX <= gp.unitSize * 12 && mouseY >= gp.unitSize * 14 && mouseY <= gp.unitSize * 15)
            {
                gp.gameState = gp.playGameState;
            }

            // Quit button
            if(mouseX >= gp.unitSize * 10 && mouseX <= gp.unitSize * 12 && mouseY >= gp.unitSize * 16 && mouseY <= gp.unitSize * 17)
            {
                gp.gameState = gp.quitGameState;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        gp.player.setMove(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
       mouseX = e.getX();
       mouseY = e.getY();
       gp.player.setMove(true);
       if(gp.gameState == gp.playGameState)
       {
           if(mouseX < gp.player.getPositionX() + gp.unitSize * 2 - gp.unitSize / 2)
           {
               gp.player.setPositionX(gp.player.getPositionX() - gp.player.getSpeed());
           }
           if(mouseX > gp.player.getPositionX() + gp.unitSize / 2)
           {
               gp.player.setPositionX(gp.player.getPositionX() + gp.player.getSpeed());
           }
       }
    }
}
