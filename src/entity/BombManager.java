package entity;

import main.GamePanel;

public class BombManager extends Entity{
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
        bomb.positionX = this.positionX;
        bomb.speed /= scale;
        gp.listEntity.add(bomb);
    }
    public void update()
    {
        super.update();
        if(System.currentTimeMillis() - currentTime > 1000 * scale){
            int i = random.nextInt(20);
            setPositionX(gp.unitSize*i);
            createBomb();
            currentTime = System.currentTimeMillis();
        }
        if(!unscale){
            if(System.currentTimeMillis() - scaleTime > 10000){
                scale -= 0.1;
                scaleTime = System.currentTimeMillis();
                if(scale <= 0.3) unscale = true;
            }
        }
    }
}
