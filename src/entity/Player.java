package entity;
import main.GamePanel;
import main.GetKey;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GetKey getkey;
    public Rectangle solidArea = new Rectangle();
    GamePanel gp;

    public Player(GamePanel gp, GetKey gk)
    {
        super(gp);
        this.gp = gp;
        this.getkey = gk;
        solidArea.x = 12;
        solidArea.y = 3;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 26;
        solidArea.height = 47;
        life = 10;
        getImagePlayer();
        setDefaultVale();

        direction = "left";
    }
    public void update()
    {
        collision = false;
        if(getkey.moveLeft == true || getkey.moveRight == true)
        {
            if(getkey.moveLeft == true) direction = "left";
            else if(getkey.moveRight == true) direction = "right";

            //Check collision
            gp.checkCollision.checkLimitLeft();
            gp.checkCollision.checkLimitRight();
            int entityIndex = gp.checkCollision.checkEntity(gp.listEntity);
            contactEntity(entityIndex);
            //Player can move
            if(collision == false)
            {
                switch (direction)
                {
                    case "left": positionX -= speed; break;
                    case "right": positionX += speed; break;
                }
            }
        }
        //Delay
        if(delay == true)
        {
            delayCount++;
            if(delayCount > 60)
            {
                delay = false;
                delayCount = 0;
            }
        }
    }

    public void contactEntity(int i)
    {
        if(i != 999)
        {
            if(gp.listEntity.get(i).name == "Bomb")
            {
                 gp.listEntity.remove(i);
            }
        }
    }

    public void setDefaultVale()
    {
        positionX = gp.unitSize * 9;
        positionY = gp.unitSize * 28;
        speed = gp.unitSize/5;
    }
    public void getImagePlayer()
    {
        try {
            imageEntity = ImageIO.read(getClass().getResourceAsStream("/player/human.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void draw(Graphics g)
    {
        BufferedImage image;
        image = imageEntity;
        g.drawImage(image, positionX, positionY ,gp.unitSizePlayer,gp.unitSizePlayer,null);
    }

}
