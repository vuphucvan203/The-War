package main;

import java.awt.*;

public class UI {

    Font arial;
    Graphics g;
    GamePanel gp;
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial = new Font("Arial",Font.PLAIN,30);
    }

    public void draw(Graphics g)
    {
        g.setFont(arial);
        g.setColor(Color.RED);
        g.drawString(String.valueOf(gp.player.life),9 * gp.unitSize, 2 * gp.unitSize);
        drawGameOver(g);
    }
    public void drawGameOver(Graphics g)
    {
        if(gp.overGameStatus == true)
        {
            g.drawString("Game over",7 * gp.unitSize, 15 * gp.unitSize);
        }
    }

}
