package main;
import entity.*;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class GamePanel extends JPanel implements Runnable{

    public final int screenWidth = 500;
    public final int screenHeight = 750;
    public final int unitSize = 25;
    public final int unitSizePlayer = unitSize * 2;
    public boolean overGameStatus = false;


    int FPS = 60;
    Thread gameThread;

    GetKey getKey = new GetKey();
    public CheckCollision checkCollision = new CheckCollision(this);
    BombManager bombManager = new BombManager(this);
    public Player player = new Player(this, getKey);
    public LimitLeftScreen leftScreen = new LimitLeftScreen(this);
    public LimitRightScreen rightScreen = new LimitRightScreen(this);
    public UI ui = new UI(this);
    public ArrayList<Entity> listEntity = new ArrayList<Entity>();

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(getKey);
        this.setFocusable(true);
        this.setupGame();
        this.startGameThread();
    }

    public void setupGame()
    {
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;
        int drawCount = 0;

        while (gameThread != null)
        {
            if(overGameStatus == false)
            {
                currentTime = System.nanoTime();

                delta += (currentTime - lastTime) / drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if(delta >=1)
                {
                    update();
                    repaint();
                    delta--;
                    drawCount++;
                }
                if(timer >= 1000000000)
                {
                    System.out.println("FPS: "+drawCount);
                    drawCount = 0;
                    timer = 0;
                }
            }
        }
    }
    public void update()
    {
        player.update();
        bombManager.update();
        for(int i = 0; i < listEntity.size(); i++)
        {
            if(listEntity.get(i) != null) listEntity.get(i).update();
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
//        draw(g);
        ui.draw(g);
        player.draw(g);

        for(int i = 0; i < listEntity.size(); i++)
        {
            if(listEntity.get(i) != null) listEntity.get(i).draw(g);
        }
    }
    public void draw(Graphics g)
    {
        for(int i = 0; i < screenHeight; i++)
        {
            g.drawLine(i*unitSize, 0, i*unitSize, screenHeight);
            g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
        }
    }
}