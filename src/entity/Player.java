package entity;
import main.GamePanel;
import main.GetKey;
import main.GetMouse;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

//    GetKey getkey;
    GetMouse getMouse;
    Rectangle solidArea = new Rectangle();

    GamePanel gp;

    private boolean injured = false;
    private int blood;
    private int score;
    private boolean delay = false;
    private BufferedImage imagePlayer, imageInjured;
    private int delayCount = 0;
    private boolean moveRight, moveLeft;
    private boolean mouseRight, mouseLeft;

    public boolean isMouseRight() {
        return mouseRight;
    }

    public void setMouseRight(boolean mouseRight) {
        this.mouseRight = mouseRight;
    }

    public boolean isMouseLeft() {
        return mouseLeft;
    }

    public void setMouseLeft(boolean mouseLeft) {
        this.mouseLeft = mouseLeft;
    }

    private String direction = "";
    private boolean move = false;


    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    @Override
    public Rectangle getSolidArea() {
        return solidArea;
    }

    @Override
    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public boolean isDelay() {
        return delay;
    }

    public void setDelay(boolean delay) {
        this.delay = delay;
    }

    public int getDelayCount() {
        return delayCount;
    }

    public void setDelayCount(int delayCount) {
        this.delayCount = delayCount;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    

    public Player(GamePanel gp, GetMouse gm)
    {
        super(gp);
        this.gp = gp;
        this.getMouse = gm;
        setSolidArea();
        getImagePlayer();
        setDefaultVale();
        setBlood();
        setScore();
        direction = "left";
    }

    public void contactEntity(int i)
    {
        if(i != 999)
        {
            if(gp.listEntity.get(i).getName() == "Bomb")
            {
                gp.listEntity.remove(i);
                injured = true;
                if(gp.player.isDelay() == false)
                {
                    gp.player.blood -= 1;
                    delay = true;
                }
            }
        }
    }
    public void setScore()
    {
        score = 0;
    }
    public void setDefaultVale()
    {
        setPositionX(gp.unitSize * 9);
        setPositionY(gp.unitSize * 28);
        setSpeed(gp.unitSize/ 5);
    }

    public void setSolidArea()
    {
        solidArea.x = 12;
        solidArea.y = 3;
        setSolidAreaDefaultX(solidArea.x);
        setSolidAreaDefaultY(solidArea.y);
        solidArea.width = 26;
        solidArea.height = 47;
    }

    public void setBlood()
    {
        blood = 5;
    }
    public void getImagePlayer()
    {
        try {
            imagePlayer = ImageIO.read(getClass().getResourceAsStream("/player/human.png"));
            imageInjured = ImageIO.read(getClass().getResourceAsStream("/player/humanInjured.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update()
    {
        setCollision(false);
        if(moveLeft == true || moveRight == true)
        {
            if(moveLeft == true) direction = "left";
            else if(moveRight == true) direction = "right";

            //Check collision
            gp.checkCollision.checkLimitLeft();
            gp.checkCollision.checkLimitRight();
            int entityIndex = gp.checkCollision.checkEntity(gp.listEntity);
            boolean takeItems = gp.checkCollision.checkItems();
            contactEntity(entityIndex);
            //Player can move
            if(isCollision() == false)
            {
                switch (direction)
                {
                    case "left": setPositionX(getPositionX() - getSpeed()); break;
                    case "right": setPositionX(getPositionX() + getSpeed()); break;
                }
            }

            //Take items
            if(takeItems == true)
            {
                gp.player.score += 1;
                gp.sound.playSoundEffect(3);
                gp.items.createItems();
                takeItems = false;
            }
        }
        if(move == true)
        {
            //Check collision
            boolean takeItems = gp.checkCollision.checkItems();

            //Take items
            if(takeItems == true)
            {
                gp.player.score += 1;
                gp.sound.playSoundEffect(3);
                gp.items.createItems();
                takeItems = false;
            }
        }
        //Delay
        if(delay == true)
        {
            delayCount++;
            if(delayCount > 60)
            {
                delay = false;
                delayCount = 0;
            }
        }


    }
    public void draw(Graphics g)
    {
        BufferedImage image = null;
        if(injured == true)
        {
            image = imageInjured;
            gp.sound.playSoundEffect(2);
            injured = false;
        }
        else
        {
            image = imagePlayer;
        }
        g.drawImage(image, getPositionX(), getPositionY() ,gp.unitSizePlayer,gp.unitSizePlayer,null);
    }

}
