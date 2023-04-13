package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bomb extends Entity{

    GamePanel gp;
    public boolean explode = false;


    public Bomb(GamePanel gp)
    {
        super(gp);
        name = "Bomb";
        this.gp = gp;
        getImageBomb();
        speed = gp.unitSize/5;
        setSolidArea();
    }

    private void setSolidArea()
    {
        solidArea = new Rectangle();
        solidArea.x = 2;
        solidArea.y = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 21;
        solidArea.height = 25;
        positionY = -25;
    }

    public void getImageBomb()
    {
        try {
            imageEntity = ImageIO.read(getClass().getResourceAsStream("/weapon/bomb.png"));
            imageExplode = ImageIO.read(getClass().getResourceAsStream("/weapon/bombExplode.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void update() {
       collision = false;
       //Collision
       boolean contactPlayer = gp.checkCollision.checkPlayer(this);
       boolean contactBottom = gp.checkCollision.checkLimitBottom(this);


        if(collision == false)
        {
            positionY += speed;
        }
        if(contactPlayer == true)
        {
            gp.player.injured = true;
            explode = true;
            gp.playSoundEffect(2);
            if(gp.player.delay == false)
            {
                gp.player.blood -= 1;
                gp.player.delay = true;
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
            g.drawImage(image2, positionX, positionY, gp.unitSizeBombExplode, gp.unitSizeBombExplode, null);
        }
        else
        {
            image = imageEntity;
            g.drawImage(image, positionX, positionY ,gp.unitSize,gp.unitSize,null);
        }
    }
}
