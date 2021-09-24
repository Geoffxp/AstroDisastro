package JavaBreaker;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener, MouseMotionListener {
    public static void main(String[] args) {

    }
    // Transparent 16 x 16 pixel cursor image.


    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private Timer sleeper = new Timer(500, this);
    private int delay = 10;
    private Paddle paddle = new Paddle(150, 10, 300, 545);
    private Ball ball = new Ball(50, 400, -1, -5);
    private Triangle triangle = new Triangle();

    private Ball[] balls = new Ball[]{
            new Ball(400, 500, -5, 5),
            new Ball(25, 333, -3, 1),
            new Ball(400, 450, 5, -3),
            new Ball(1000, 600, -1, 5),
            new Ball(10, 450, -7, 5),
            new Ball(345, 123, 7, -5),
            new Ball(1111, 555, -3, 6),
            new Ball(342, 234, -5, 5),
    };
    private Collision collision = new Collision(balls, paddle, triangle);

    public Game() {
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(1, 1, 1422, 859);

        g.setColor(Color.WHITE);
        /*g.fillRect(paddle.xPos,
                paddle.yPos,
                paddle.width,
                paddle.height);*/

        g.setColor(Color.WHITE);
        for (int i = 0; i<balls.length; i++) {
            g.fillOval(balls[i].xPos, balls[i].yPos, balls[i].size, balls[i].size);
        }


        g.drawPolygon(
                new int[] {(int) triangle.leftX,
                (int) triangle.topX, (int) triangle.rightX},
                new int[]{(int) triangle.leftY,
                (int) triangle.topY, (int) triangle.rightY},
                3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        paddle.tick();
        if (play) {
            for (int i = 0; i<balls.length; i++) {
                balls[i].tick();
            }
            triangle.tick();
            triangle.goTo(triangle.mouseX, triangle.mouseY);
        }
        collision.triangleCollision();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*if (e.getKeyCode() == 65 || e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }
        if (e.getKeyCode() == 68 || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }

        if (e.getKeyCode() == 83 || e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown();
        }*/

        if (e.getKeyCode() == 87 || e.getKeyCode() == KeyEvent.VK_UP) {
            goTo();

        }
    }

    public void goTo() {
        play = true;

    }
    /*public void moveLeft() {
        play = true;
        triangle.setXSpeed(-5);
    }
    public void moveRight() {
        play = true;
        triangle.setXSpeed(5);
    }
    public void moveUp() {
        play = true;
        triangle.setYSpeed(-5);
    }
    public void moveDown() {
        play = true;
        triangle.setYSpeed(5);
    }*/

    //a65 d68 s83 w87
    @Override
    public void keyReleased(KeyEvent e) {
        /*if (e.getKeyCode() == 65 || e.getKeyCode() == KeyEvent.VK_LEFT && paddle.xSpeed < 0) {
            paddle.setXSpeed(0);
            triangle.setXSpeed(0);
        }
        if (e.getKeyCode() == 68 || e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.xSpeed > 0) {
            paddle.setXSpeed(0);
            triangle.setXSpeed(0);
        }*/
        if (e.getKeyCode() == 87 || e.getKeyCode() == KeyEvent.VK_UP && triangle.ySpeed < 0) {
            //triangle.stop(sleeper);
        }
        /*
        if (e.getKeyCode() == 83 || e.getKeyCode() == KeyEvent.VK_DOWN && triangle.ySpeed > 0) {
            triangle.setYSpeed(0);
        }*/
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        play = true;
        triangle.setMouseX(e.getX());
        triangle.setMouseY(e.getY());
        //goTo();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        play = true;
        triangle.setMouseX(e.getX());
        triangle.setMouseY(e.getY());
        //goTo();
    }
}
