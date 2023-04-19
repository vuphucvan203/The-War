package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Items extends Entity{

    private BufferedImage imageItems;
    private Rectangle solidArea = new Rectangle();

    public Items(GamePanel gp) {
        super(gp);
        getImageItems();
        setSolidAreaItem();
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public void setSolidAreaItem()
    {
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 25;
        solidArea.height = 25;
        setPositionY(gp.unitSize * 29);
    }

    public void createItems()
    {
        setPositionX(random.nextInt(19) * gp.unitSize);
    }
    public void getImageItems()
    {
        try {
            imageItems = ImageIO.read(getClass().getResourceAsStream("/items/items.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawItems(Graphics g)
    {
        BufferedImage image;
        image = imageItems;
        g.drawImage(image,getPositionX(), getPositionY(), gp.unitSize, gp.unitSize, null);
    }

}
