package entity;

import main.GamePanel;

import java.awt.*;

public class LimitBottomScreen extends Entity{

    public Rectangle solidArea = new Rectangle();

    public LimitBottomScreen(GamePanel gp)
    {
        super(gp);
        setSolidArea();
    }

    private void setSolidArea()
    {
        solidArea.x = 0;
        solidArea.y = 700;
        solidArea.width = gp.screenWidth;
        solidArea.height = 50;
    }
}
