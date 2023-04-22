package entity;

import main.GamePanel;

import java.awt.*;

public class LimitRightScreen extends Entity{

    @Override
    public Rectangle getSolidArea() {
        return solidArea;
    }

    @Override
    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    private Rectangle solidArea = new Rectangle();

    public LimitRightScreen(GamePanel gp) {
        super(gp);
        setSolidArea();
    }

    private void setSolidArea()
    {
        solidArea.x = 499;
        solidArea.y = 0;
        solidArea.width = 1;
        solidArea.height = gp.screenHeight;
    }
}
