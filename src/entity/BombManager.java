package entity;

import main.GamePanel;

import java.util.Random;

public class BombManager extends Entity{
    Random random = new Random();
    private long currentTime = 0;
    private  long scaleTime = 0;
    private boolean unscale;
    private double scale = 1;
    public BombManager(GamePanel gp) {
        super(gp);
        scaleTime = System.currentTimeMillis();
    }
     public void createBomb(){
        Bomb bomb = new Bomb(gp);
        bomb.setPositionX(this.getPositionX());
        gp.listEntity.add(bomb);
    }
    public  void setBomb()
    {
        if(System.currentTimeMillis() - currentTime > 300 * scale)
        {
            int i = random.nextInt(20);
            setPositionX(gp.unitSize*i);
            createBomb();
            currentTime = System.currentTimeMillis();
        }
        if(!unscale){
            if(System.currentTimeMillis() - scaleTime > 20000){
                scale -= 0.1;
                scaleTime = System.currentTimeMillis();
                if(scale < 0.5 ) unscale = true;
            }
        }
    }

    public void update()
    {
        super.update();
        setBomb();
    }
}
