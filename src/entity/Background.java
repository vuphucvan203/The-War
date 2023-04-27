package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {
    GamePanel gp;
    BufferedImage imageBackground;


    public Background(GamePanel gp)
    {
        this.gp = gp;
        getImageBackground();
    }

    public void getImageBackground()
    {
        try {
            imageBackground = ImageIO.read(getClass().getResourceAsStream("/background/Background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawBackground(Graphics g)
    {
        BufferedImage image;
        image = imageBackground;
        g.drawImage(image, 0,0, gp.screenWidth, gp.screenHeight, null);
    }
}
