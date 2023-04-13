package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Entity {
    GamePanel gp;

    Random random = new Random();
    public Rectangle solidArea = new Rectangle();
    public String name;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public int positionX, positionY;
    public int speed;
    public int blood;
    public int score;
    public boolean delay = false;
    public int delayCount = 0;
    public boolean collision = false;
    public String direction = " ";
    public BufferedImage imageEntity, imageInjured, imageExplode;
    public Bomb bomb;
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public Entity(GamePanel gp)
    {
        this.gp = gp;
    }

    public void update()
    {
        if(gp.player.blood <= 0) gp.gameState = gp.overGameState;
    }
    public void draw(Graphics g)
    {
        bomb.draw(g);
    }
}
