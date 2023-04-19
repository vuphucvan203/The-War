package main;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{

    public final int screenWidth = 500;
    public final int screenHeight = 750;
    public final int unitSize = 25;
    public final int unitSizePlayer = unitSize * 2;
    public final int unitSizeBombExplode = unitSize * 2;

    public int gameState;
    public int menuGameState = 0;
    public int playGameState = 1;
    public int pauseGameState = 2;
    public int overGameState = 3;
    public int resetGameState = 4;
    public int quitGameState = 5;
    public boolean save = false;



    int FPS = 60;
    Thread gameThread;

    GetKey getKey = new GetKey(this);
    public CheckCollision checkCollision = new CheckCollision(this);
    BombManager bombManager = new BombManager(this);
    public Player player = new Player(this, getKey);
    public LimitLeftScreen leftScreen = new LimitLeftScreen(this);
    public LimitRightScreen rightScreen = new LimitRightScreen(this);
    public LimitBottomScreen bottomScreen = new LimitBottomScreen(this);
    public UI ui = new UI(this);
    public Database data = new Database(this);
    public soundThread sound = new soundThread();
    public Background background = new Background(this);
    public Items items = new Items(this);
    public ArrayList<Entity> listEntity = new ArrayList<Entity>();

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(getKey);
        this.setFocusable(true);
        this.setupGame();
        this.startGameThread();
        this.startSoundThread();
        if(save == true)
        {
            this.save();
        }
    }

    public void setupGame()
    {
        gameState = menuGameState;
    }

    public void playGame()
    {
        gameState = playGameState;
        items.createItems();
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void startSoundThread()
    {
        sound.start();
    }

    public void save()
    {
        try {
            data.insert();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            data.exportToFile();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameState = menuGameState;
    }
    public void reset()
    {
        playGame();
        player.setDefaultVale();
        player.setBlood();
        player.setScore();
        listEntity.clear();
    }

    public void quit()
    {
        System.exit(0);
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

    public void update()
    {
        if(gameState == playGameState)
        {
            player.update();
            bombManager.update();
            for(int i = 0; i < listEntity.size(); i++)
            {
                if(listEntity.get(i) != null) listEntity.get(i).update();
            }
        }
        if(gameState == pauseGameState)
        {
            //null
        }
        if(save == true)
        {
            save();
            save = false;
        }

        if(gameState == resetGameState)
        {
            reset();
        }
        if(gameState == quitGameState)
        {
            quit();
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        background.drawBackground(g);
        if(gameState == menuGameState)
        {
            ui.drawMenuGame(g);
        }
        else
        {
            player.draw(g);
            drawBomb(g);
            items.drawItems(g);
            ui.draw(g);
        }
    }
    public void drawBomb(Graphics g)
    {
        for(int i = 0; i < listEntity.size(); i++)
        {
            if(listEntity.get(i) != null) listEntity.get(i).draw(g);
        }
    }
}