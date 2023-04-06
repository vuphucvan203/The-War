package main;

import entity.Bomb;
import entity.Entity;

import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCollision {

    GamePanel gp;
    public CheckCollision(GamePanel gp)
    {
        this.gp = gp;
    }

    public void checkLimitLeft()
    {
        // Get player's solid area position
        gp.player.solidArea.x = gp.player.positionX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.positionY + gp.player.solidArea.y;

        switch (gp.player.direction)
        {
            case "left": gp.player.solidArea.x -= gp.player.speed;
            case "right": gp.player.solidArea.x += gp.player.speed;
        }

        if(gp.player.solidArea.intersects(gp.leftScreen.solidArea))
        {
                gp.player.collision = true;
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
    }
    public void checkLimitRight()
    {
        // Get player's solid area position
        gp.player.solidArea.x = gp.player.positionX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.positionY + gp.player.solidArea.y;

        switch (gp.player.direction)
        {
            case "left": gp.player.solidArea.x -= gp.player.speed;break;
            case "right": gp.player.solidArea.x += gp.player.speed;break;
        }

        if(gp.player.solidArea.intersects(gp.rightScreen.solidArea))
        {
                gp.player.collision = true;
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
    }
    public int checkEntity(ArrayList<Entity> target)
    {
        int index = 999;
        for(int i = 0; i < target.size(); i++)
        {
            if(target.get(i) != null)
            {
                //Get entity's solid area position
                gp.player.solidArea.x = gp.player.positionX + gp.player.solidArea.x;
                gp.player.solidArea.y = gp.player.positionY + gp.player.solidArea.y;

                //Get target's solid area position
                target.get(i).solidArea.x = target.get(i).positionX + target.get(i).solidArea.x;
                target.get(i).solidArea.y = target.get(i).positionY + target.get(i).solidArea.y;

                switch (gp.player.direction)
                {
                    case "left": gp.player.solidArea.x -= gp.player.speed;
                    case "right": gp.player.solidArea.x += gp.player.speed;
                }
                target.get(i).solidArea.y += target.get(i).speed;

                if(gp.player.solidArea.intersects(target.get(i).solidArea))
                {
                    if(target.get(i) != gp.player)
                    {
                        gp.player.collision = true;
                        index = i;
                    }
                }
                gp.player.solidArea.x = gp.player.solidAreaDefaultX;
                gp.player.solidArea.y = gp.player.solidAreaDefaultY;
                target.get(i).solidArea.x = target.get(i).solidAreaDefaultX;
                target.get(i).solidArea.y = target.get(i).solidAreaDefaultY;
            }
        }
        return index;
    }


    public boolean checkPlayer(Entity entity)
    {
                boolean contact = false;
                //Get entity's solid area position
                gp.player.solidArea.x = gp.player.positionX + gp.player.solidArea.x;
                gp.player.solidArea.y = gp.player.positionY + gp.player.solidArea.y;

                //Get target's solid area position
                entity.solidArea.x = entity.positionX + entity.solidArea.x;
                entity.solidArea.y = entity.positionY + entity.solidArea.y;

                switch (gp.player.direction)
                {
                    case "left": gp.player.solidArea.x -= gp.player.speed;break;
                    case "right": gp.player.solidArea.x += gp.player.speed;break;
                }
                entity.solidArea.y += entity.speed;

                if(entity.solidArea.intersects(gp.player.solidArea))
                {
                    entity.collision = true;
                    contact = true;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.player.solidArea.x = gp.player.solidAreaDefaultX;
                gp.player.solidArea.y = gp.player.solidAreaDefaultY;
                return contact;
    }
}
