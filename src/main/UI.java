package main;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;

public class UI {

    Font arial20, arial30, arial50;
    Graphics g;
    GamePanel gp;
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial30 = new Font("Arial",Font.PLAIN,30);
        arial50 = new Font("Arial", Font.BOLD, 50);
        arial20 = new Font("Arial", Font.BOLD, 20);
    }

    public void draw(Graphics g)
    {
        drawPlayerIndex(g);
        if(gp.gameState == gp.pauseGameState)
        {
            drawPauseGame(g);
        }
        if(gp.gameState == gp.overGameState)
        {
            drawGameOver(g);
        }
    }

    public void drawMenuGame(Graphics g)
    {
        String textPlay = "Play";

        g.setColor(new Color(0,0,0,200));
        g.fillRect(0,0, gp.screenWidth,gp.screenHeight);

        g.setFont(arial50);
        g.setColor(Color.WHITE);
        g.drawString(textPlay, getXTextCenter(textPlay,g), gp.screenHeight / 2);
    }

    public  void drawPlayerIndex(Graphics g)
    {

        String textBlood = "Blood: " + String.valueOf(gp.player.blood);
        String textScore = "Score: " + String.valueOf(gp.player.score);
        String textLevel = "Level " + String.valueOf(gp.level);

        //Draw blood
        g.setFont(arial20);
        g.setColor(Color.WHITE);
        g.drawString(textBlood, gp.unitSize * 1, gp.unitSize * 1);

        //Draw score
        g.setFont(arial20);
        g.setColor(Color.WHITE);
        g.drawString(textScore, gp.unitSize * 6, gp.unitSize * 1);

        //Draw level
        g.setFont(arial20);
        g.setColor(Color.WHITE);
        g.drawString(textLevel, gp.unitSize * 11, gp.unitSize * 1);

    }
    public void drawPauseGame(Graphics g)
    {
        String textPause = "Pause";
        String textContinue = "Press P to continue";
        g.setColor(new Color(100,100,100,150));
        g.fillRect(0,0, gp.screenWidth,gp.screenHeight);

        //Draw pause game
        g.setFont(arial50);
        g.setColor(Color.WHITE);
        g.drawString(textPause, getXTextCenter(textPause, g), gp.screenHeight / 2);

        //Draw continue game
        g.setFont(arial20);
        g.setColor(Color.WHITE);
        g.drawString(textContinue, getXTextCenter(textContinue, g), gp.unitSize * 17);
    }
    public void drawGameOver(Graphics g)
    {
        String textOverGame = "Game Over";
        String textScore = "Score: " + gp.player.score;
        String textReset = "Press ENTER to rest";
        String textQuit = "Press ESC to quit";
        g.setColor(new Color(100,100,100,150));
        g.fillRect(0,0, gp.screenWidth,gp.screenHeight);

        //Draw over game
        g.setFont(arial50);
        g.setColor(Color.RED);
        g.drawString(textOverGame, getXTextCenter(textOverGame, g), gp.screenHeight / 3 + gp.unitSize * 3);

        //Draw score
        g.setFont(arial30);
        g.setColor(Color.WHITE);
        g.drawString(textScore, getXTextCenter(textScore, g), gp.screenHeight / 2);

        //Draw reset game
        g.setFont(arial20);
        g.setColor(Color.WHITE);
        g.drawString(textReset, getXTextCenter(textReset, g), gp.unitSize * 17);

        //Draw quit
        g.setFont(arial20);
        g.setColor(Color.WHITE);
        g.drawString(textQuit, getXTextCenter(textQuit, g), gp.unitSize * 18);
    }
    public int  getXTextCenter(String text, Graphics g)
    {
        FontMetrics metrics = g.getFontMetrics();
        int x = (gp.screenWidth - metrics.stringWidth(text)) / 2;
        return x;
    }
}
