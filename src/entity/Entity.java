package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Entity {
    GamePanel gp;

    Random random = new Random();
    private Rectangle solidArea = new Rectangle();
    private int solidAreaDefaultX, solidAreaDefaultY;
    private int positionX, positionY;
    private String name;

    private int speed;

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public String getName() {
        return name;
    }

    private boolean collision = false;

    public void setName(String name) {
        this.name = name;
    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
    Bomb bomb;

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
        if(gp.player.getBlood() <= 0) gp.gameState = gp.overGameState;
    }
    public void draw(Graphics g)
    {
//        bomb.draw(g);
    }
}
