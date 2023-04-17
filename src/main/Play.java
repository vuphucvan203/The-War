package main;
import javax.swing.JFrame;
import java.sql.SQLException;

public class Play {
    public static void main(String[] args) throws ClassNotFoundException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("The War");

        frame.add(new GamePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}