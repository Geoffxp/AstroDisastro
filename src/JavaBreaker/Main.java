package JavaBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Game game = new Game();
        frame.setBounds(1920/2-720, 1080/2-450, 1440, 900);
        frame.setTitle("ShootEmUp");
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(game);
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");

        frame.getContentPane().setCursor(blankCursor);
    }
}

