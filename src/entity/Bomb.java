package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Bomb extends Entity{

    GamePanel gp;


    public Bomb(GamePanel gp)
    {
        super(gp);
        name = "Bomb";
        this.gp = gp;
        getImageBomb();
        speed = gp.unitSize/10;

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
            imageEntity = ImageIO.read(getClass().getResourceAsStream("/bomb/bomb.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void update() {
       collision = false;
//       gp.player.delay = false;
       boolean contactPlayer = gp.checkCollision.checkPlayer(this);
        if(collision == false)
        {
            positionY += speed;
        }
        if(contactPlayer == true)
        {
            if(gp.player.delay == false)
            {
                gp.player.life -= 1;
                gp.player.delay = true;
            }
        }

    }
    public void draw(Graphics g)
    {
        BufferedImage image;
        image = imageEntity;
        g.drawImage(image, positionX, positionY ,gp.unitSize,gp.unitSize,null);
    }
}
