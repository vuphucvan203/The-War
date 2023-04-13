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
    public boolean injured = false;
    GamePanel gp;

    public Player(GamePanel gp, GetKey gk)
    {
        super(gp);
        this.gp = gp;
        this.getkey = gk;
        setSolidArea();
        getImagePlayer();
        setDefaultVale();
        setBlood();
        setScore();
        direction = "left";
    }

    public void contactEntity(int i)
    {
        if(i != 999)
        {
            if(gp.listEntity.get(i).name == "Bomb")
            {
                gp.listEntity.remove(i);
                gp.playSoundEffect(2);
                injured = true;
                if(gp.player.delay == false)
                {
                    gp.player.blood -= 1;
                    gp.player.delay = true;
                }
            }
        }
    }
    public void setScore()
    {
        score = 0;
    }
    public void setDefaultVale()
    {
        positionX = gp.unitSize * 9;
        positionY = gp.unitSize * 28;
        speed = gp.unitSize/5;
    }

    public void setSolidArea()
    {
        solidArea.x = 12;
        solidArea.y = 3;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 26;
        solidArea.height = 47;
    }

    public void setBlood()
    {
        blood = 5;
    }
    public void getImagePlayer()
    {
        try {
            imageEntity = ImageIO.read(getClass().getResourceAsStream("/player/human.png"));
            imageInjured = ImageIO.read(getClass().getResourceAsStream("/player/humanInjured.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public void draw(Graphics g)
    {
        BufferedImage image = null;
        if(injured == true)
        {
            image = imageInjured;
            injured = false;
        }
        else
        {
            image = imageEntity;
        }
        g.drawImage(image, positionX, positionY ,gp.unitSizePlayer,gp.unitSizePlayer,null);
    }

}
