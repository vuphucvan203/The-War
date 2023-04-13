package entity;

import main.GamePanel;

import java.awt.*;

public class LimitLeftScreen extends Entity{

    public Rectangle solidArea = new Rectangle();

    public LimitLeftScreen(GamePanel gp) {
        super(gp);
        setSolidArea();
    }

    private void setSolidArea()
    {
        solidArea.x = 5;
        solidArea.y = 0;
        solidArea.width = 1;
        solidArea.height = gp.screenHeight;
    }

}
