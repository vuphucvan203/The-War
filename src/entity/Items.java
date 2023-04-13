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
        g.drawImage(image,gp.unitSize * 2, gp.unitSize * 28, gp.unitSizePlayer, gp.unitSizePlayer, null);
    }

}
