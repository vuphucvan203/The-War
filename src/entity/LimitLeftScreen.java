package entity;

import main.GamePanel;

import java.awt.*;

public class LimitLeftScreen extends Entity{

    @Override
    public Rectangle getSolidArea() {
        return solidArea;
    }

    @Override
    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    private Rectangle solidArea = new Rectangle();

    public LimitLeftScreen(GamePanel gp) {
        super(gp);
        setSolidArea();
    }

    private void setSolidArea()
    {
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 5;
        solidArea.height = gp.screenHeight;
    }

}
