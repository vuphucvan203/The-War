package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Items extends Entity{


    public Items(GamePanel gp) {
        super(gp);
        getImageItems();
        setSolidArea();
    }

    private void setSolidArea()
    {
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 25;
        solidArea.height = 25;
        positionY = gp.unitSize * 29;
    }

    public void createItems()
    {
        positionX = random.nextInt(19) * gp.unitSize;
    }
    private void getImageItems()
    {
        try {
            imageEntity = ImageIO.read(getClass().getResourceAsStream("/items/items.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawItems(Graphics g)
    {
        BufferedImage image;
        image = imageEntity;
        g.drawImage(image,positionX, positionY, gp.unitSize, gp.unitSize, null);
    }

}
