package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bomb extends Entity{

    GamePanel gp;
    private boolean explode = false;
    private BufferedImage imageExplode, imageBomb;
    private Rectangle solidArea = new Rectangle();

    @Override
    public Rectangle getSolidArea() {
        return solidArea;
    }

    @Override
    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public Bomb(GamePanel gp)
    {
        super(gp);
        setName("Bomb");
        this.gp = gp;
        getImageBomb();
        setSpeed(gp.unitSize/5);
        setSolidArea();
    }

    private void setSolidArea()
    {
        solidArea = new Rectangle();
        solidArea.x = 2;
        solidArea.y = 0;
        setSolidAreaDefaultX(solidArea.x);
        setSolidAreaDefaultY(solidArea.y);
        solidArea.width = 21;
        solidArea.height = 25;
        setPositionY(-25);
    }

    public void getImageBomb()
    {
        try {
            imageBomb = ImageIO.read(getClass().getResourceAsStream("/weapon/bomb.png"));
            imageExplode = ImageIO.read(getClass().getResourceAsStream("/weapon/bombExplode.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void update() {
       setCollision(false);
       //Collision
       boolean contactPlayer = gp.checkCollision.checkPlayer(this);
       boolean contactBottom = gp.checkCollision.checkLimitBottom(this);


        if(isCollision() == false)
        {
            setPositionY(getPositionY() + getSpeed());
        }
        if(contactPlayer == true)
        {
            gp.player.setInjured(true);
            explode = true;
            gp.sound.playSoundEffect(2);
            if(gp.player.isDelay() == false)
            {
                gp.player.setBlood(gp.player.getBlood() - 1);
                gp.player.setDelay(true);
            }
        }
        if(contactBottom == true)
        {
            explode = true;
        }

    }
    public void draw(Graphics g)
    {
        BufferedImage image, image2;
        if(explode == true)
        {
            image2 = imageExplode;
            explode = false;
            g.drawImage(image2, getPositionX(), getPositionY(), gp.unitSizeBombExplode, gp.unitSizeBombExplode, null);
        }
        else
        {
            image = imageBomb;
            g.drawImage(image, getPositionX(), getPositionY() ,gp.unitSize,gp.unitSize,null);
        }
    }
}
