package entity;

import main.GamePanel;

import java.awt.*;

public class LimitRightScreen extends Entity{

    public Rectangle solidArea = new Rectangle();

    public LimitRightScreen(GamePanel gp) {
        super(gp);
        solidArea.x = 500;
        solidArea.y = 0;
        solidArea.width = 1;
        solidArea.height = gp.screenHeight;
    }
}
