package main;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UI {

    Font arial20, arial30, arial40, arial50, arial70;
    Graphics g;
    GamePanel gp;
    public int flagNum;
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial20 = new Font("Arial", Font.BOLD, 20);
        arial30 = new Font("Arial",Font.PLAIN,30);
        arial40 = new Font("Arial",Font.PLAIN,40);
        arial50 = new Font("Arial", Font.BOLD, 50);
        arial70 = new Font("Arial", Font.BOLD, 70);
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
        String theWar = "The War";
        String play = "Play";
        String gameDiary = "Game Diary";
        String quit = "Quit";

        g.setColor(new Color(0,0,0,200));
        g.fillRect(0,0, gp.screenWidth,gp.screenHeight);

        //String The War
        g.setFont(arial70);
        g.setColor(Color.WHITE);
        g.drawString(theWar, getXTextCenter(theWar, g), gp.unitSize * 5);


        //String Play
        g.setFont(arial30);
        g.drawString(play, getXTextCenter(play,g), gp.unitSize * 14);
        if(flagNum == 0)
        {
            g.drawString(">", getXTextCenter(play, g) - gp.unitSize, gp.unitSize * 14);
        }
        //String Game Diary
        g.drawString(gameDiary, getXTextCenter(gameDiary, g), gp.unitSize * 16);
        if(flagNum == 1)
        {
            g.drawString(">", getXTextCenter(gameDiary, g) - gp.unitSize, gp.unitSize * 16);
        }
        //String Quit
        g.drawString(quit, getXTextCenter(quit, g), gp.unitSize * 18);
        if(flagNum == 2)
        {
            g.drawString(">", getXTextCenter(quit, g) - gp.unitSize, gp.unitSize * 18);
        }
    }

    public  void drawPlayerIndex(Graphics g)
    {

        String textBlood = "Blood: " + String.valueOf(gp.player.blood);
        String textScore = "Score: " + String.valueOf(gp.player.score);

        //Draw blood
        g.setFont(arial20);
        g.setColor(Color.WHITE);
        g.drawString(textBlood, gp.unitSize * 1, gp.unitSize * 1);

        //Draw score
        g.drawString(textScore, gp.unitSize * 6, gp.unitSize * 1);
    }
    public void drawPauseGame(Graphics g)
    {
        String pause = "Pause";
        String continuePlay = "Press P to continue";
        g.setColor(new Color(100,100,100,150));
        g.fillRect(0,0, gp.screenWidth,gp.screenHeight);

        //Draw pause game
        g.setFont(arial50);
        g.setColor(Color.WHITE);
        g.drawString(pause, getXTextCenter(pause, g), gp.screenHeight / 2);

        //Draw continue game
        g.setFont(arial20);
        g.drawString(continuePlay, getXTextCenter(continuePlay, g), gp.unitSize * 17);
    }
    public void drawGameOver(Graphics g)
    {
        String overGame = "Game Over";
        String score = "Score: " + gp.player.score;
        String save = "Save game";
        String reset = "Reset game";
        String quit = "Quit";

        g.setColor(new Color(100,100,100,150));
        g.fillRect(0,0, gp.screenWidth,gp.screenHeight);

        //Draw over game
        g.setFont(arial50);
        g.setColor(Color.RED);
        g.drawString(overGame, getXTextCenter(overGame, g), gp.screenHeight / 3);

        //Draw score
        g.setFont(arial40);
        g.setColor(Color.WHITE);
        g.drawString(score, getXTextCenter(score, g), gp.screenHeight / 2 - gp.unitSize * 2);

        //Draw save game
        g.setFont(arial30);
        g.drawString(save, getXTextCenter(save, g), gp.unitSize * 16);
        if(flagNum == 0)
        {
            g.drawString(">", getXTextCenter(save, g) - gp.unitSize * 2, gp.unitSize * 16);
        }

        //Draw reset game
        g.drawString(reset, getXTextCenter(reset, g), gp.unitSize * 18);
        if(flagNum == 1)
        {
            g.drawString(">", getXTextCenter(reset, g) - gp.unitSize, gp.unitSize * 18);
        }

        //Draw quit
        g.drawString(quit, getXTextCenter(quit, g), gp.unitSize * 20);
        if(flagNum == 2)
        {
            g.drawString(">", getXTextCenter(quit, g) - gp.unitSize, gp.unitSize * 20);
        }
    }

    public int  getXTextCenter(String text, Graphics g)
    {
        FontMetrics metrics = g.getFontMetrics();
        int x = (gp.screenWidth - metrics.stringWidth(text)) / 2;
        return x;
    }
}
