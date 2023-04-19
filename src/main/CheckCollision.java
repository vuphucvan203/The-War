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
        gp.player.getSolidArea().x = gp.player.getPositionX() + gp.player.getSolidArea().x;
        gp.player.getSolidArea().y = gp.player.getPositionY() + gp.player.getSolidArea().y;

        switch (gp.player.getDirection())
        {
            case "left": gp.player.getSolidArea().x -= gp.player.getSpeed();
            case "right": gp.player.getSolidArea().x += gp.player.getSpeed();
        }

        if(gp.player.getSolidArea().intersects(gp.leftScreen.getSolidArea()))
        {
                gp.player.setCollision(true);
        }
        gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
        gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
    }
    public void checkLimitRight()
    {
        // Get player's solid area position
        gp.player.getSolidArea().x = gp.player.getPositionX() + gp.player.getSolidArea().x;
        gp.player.getSolidArea().y = gp.player.getPositionX() + gp.player.getSolidArea().y;

        switch (gp.player.getDirection())
        {
            case "left": gp.player.getSolidArea().x -= gp.player.getSpeed();break;
            case "right": gp.player.getSolidArea().x += gp.player.getSpeed();break;
        }

        if(gp.player.getSolidArea().intersects(gp.rightScreen.getSolidArea()))
        {
                gp.player.setCollision(true);
        }
        gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
        gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
    }

    public boolean checkLimitBottom(Entity entity)
    {
        boolean contact = false;
        // Get entity's solid area position
        entity.getSolidArea().x = entity.getPositionX() + entity.getSolidArea().x;
        entity.getSolidArea().y = entity.getPositionY() + entity.getSolidArea().y;

        entity.getSolidArea().y += entity.getSpeed();

        if(entity.getSolidArea().intersects(gp.bottomScreen.getSolidArea()))
        {
            contact = true;
        }
        entity.getSolidArea().x = entity.getSolidAreaDefaultX();
        entity.getSolidArea().y = entity.getSolidAreaDefaultY();
        return contact;
    }
    public int checkEntity(ArrayList<Entity> target)
    {
        int index = 999;
        for(int i = 0; i < target.size(); i++)
        {
            if(target.get(i) != null)
            {
                //Get entity's solid area position
                gp.player.getSolidArea().x = gp.player.getPositionX() + gp.player.getSolidArea().x;
                gp.player.getSolidArea().y = gp.player.getPositionY() + gp.player.getSolidArea().y;

                //Get target's solid area position
                target.get(i).getSolidArea().x = target.get(i).getPositionX() + target.get(i).getSolidArea().x;
                target.get(i).getSolidArea().y = target.get(i).getPositionY() + target.get(i).getSolidArea().y;

                switch (gp.player.getDirection())
                {
                    case "left": gp.player.getSolidArea().x -= gp.player.getSpeed();
                    case "right": gp.player.getSolidArea().x += gp.player.getSpeed();
                }
                target.get(i).getSolidArea().y += target.get(i).getSpeed();

                if(gp.player.getSolidArea().intersects(target.get(i).getSolidArea()))
                {
                    if(target.get(i) != gp.player)
                    {
                        gp.player.setCollision(true);
                        index = i;
                    }
                }
                gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
                gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
                target.get(i).getSolidArea().x = target.get(i).getSolidAreaDefaultX();
                target.get(i).getSolidArea().y = target.get(i).getSolidAreaDefaultY();
            }
        }
        return index;
    }


    public boolean checkPlayer(Entity entity)
    {
                boolean contact = false;
                //Get player's solid area position
                gp.player.getSolidArea().x = gp.player.getPositionX() + gp.player.getSolidArea().x;
                gp.player.getSolidArea().y = gp.player.getPositionY() + gp.player.getSolidArea().y;

                //Get entity's solid area position
                entity.getSolidArea().x = entity.getPositionX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getPositionY() + entity.getSolidArea().y;

                switch (gp.player.getDirection())
                {
                    case "left": gp.player.getSolidArea().x -= gp.player.getSpeed();break;
                    case "right": gp.player.getSolidArea().x += gp.player.getSpeed();break;
                }
                entity.getSolidArea().y += entity.getSpeed();

                if(entity.getSolidArea().intersects(gp.player.getSolidArea()))
                {
                    entity.setCollision(true);
                    contact = true;
                }
                entity.getSolidArea().x = entity.getSolidAreaDefaultX();
                entity.getSolidArea().y = entity.getSolidAreaDefaultY();
                gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
                gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
                return contact;
    }
    public boolean checkItems()
    {
        boolean takeItems = false;
        //Get player's solid area position
        gp.player.getSolidArea().x = gp.player.getPositionX() + gp.player.getSolidArea().x;
        gp.player.getSolidArea().y = gp.player.getPositionY() + gp.player.getSolidArea().y;

        //Get entity's solid area position
        gp.items.getSolidArea().x = gp.items.getPositionX() + gp.items.getSolidArea().x;
        gp.items.getSolidArea().y = gp.items.getPositionY() + gp.items.getSolidArea().y;

        switch (gp.player.getDirection())
        {
            case "left": gp.player.getSolidArea().x -= gp.player.getSpeed();break;
            case "right": gp.player.getSolidArea().x += gp.player.getSpeed();break;
        }

        if(gp.player.getSolidArea().intersects(gp.items.getSolidArea()))
        {
            gp.player.setCollision(true);
            takeItems = true;
        }
        gp.items.getSolidArea().x = gp.items.getSolidAreaDefaultX();
        gp.items.getSolidArea().y = gp.items.getSolidAreaDefaultY();
        gp.player.getSolidArea().x = gp.player.getSolidAreaDefaultX();
        gp.player.getSolidArea().y = gp.player.getSolidAreaDefaultY();
        return takeItems;
    }
}
