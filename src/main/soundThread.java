package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class soundThread extends Thread{

    Clip clip;

    URL soundURL[] = new URL[10];

    public soundThread()
    {
        soundURL[0] = getClass().getResource("/sound/gameMusic.wav");
        soundURL[1] = getClass().getResource("/sound/BombExplode.wav");
        soundURL[2] = getClass().getResource("/sound/HumanInjured.wav");
        soundURL[3] = getClass().getResource("/sound/TakeItems.wav");
    }

    @Override
    public void run()
    {
       playMusic();
    }
    public void setFile(int i)
    {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e){}
    }

    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playMusic()
    {
        setFile(0);
        play();
        loop();
    }
    public void playSoundEffect(int i)
    {
        setFile(i);
        play();
    }

}
