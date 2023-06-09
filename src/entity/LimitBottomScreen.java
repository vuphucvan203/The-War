package entity;

import main.GamePanel;

import java.awt.*;

public class LimitBottomScreen extends Entity{

    @Override
    public Rectangle getSolidArea() {
        return solidArea;
    }

    @Override
    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    private Rectangle solidArea = new Rectangle();

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
