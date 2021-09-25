package JavaBreaker;

import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.Vector;

public class Collision {
    Ball[] balls;
    Paddle paddle;
    Triangle triangle;


    public Collision(Ball[] balls, Paddle paddle, Triangle triangle) {
        this.balls = balls;
        this.paddle = paddle;
        this.triangle = triangle;
    }
    /*void collide() {
        if (
            this.ball.yPos + this.ball.size >= this.paddle.yPos &&
            this.ball.xPos + this.ball.size >= this.paddle.xPos &&
            this.ball.xPos < this.paddle.xPos + this.paddle.width
        ) {
            this.ball.yDir = -this.ball.yDir;
        }
    }*/
    /*boolean paddleCollision() {
        for (int i = 0; i<balls.length; i++) {
            if (distance(balls[i], paddle) <= 5) {
                int diff = paddle.xCenter - balls[i].xCenter;
                int ratio = diff / -paddle.height;
                balls[i].xDir = ratio * 2;
                balls[i].yDir = -balls[i].yDir;
                return true;
            }
            return false;
        }
    }*/
    boolean triangleCollision(List particles) {
        int hit = 0;
        for (int i = 0; i<balls.length; i++) {
            Random rn = new Random();
            int randY = rn.nextInt(10) - 5;
            int randX = rn.nextInt(10) - 5;
            int randXPos = rn.nextInt(1400) + 10;
            int randYPos = rn.nextInt(840) + 10;

            if (triDistance(balls[i], triangle) <= 75) {
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, 1, 0));
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, -1, 0));
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, 1, 1));
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, -1, -1));
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, 1, -1));
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, -1, 1));
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, 0, 1));
                particles.add(new Particle(balls[i].xCenter, balls[i].yCenter, 0, -1));
                balls[i].xDir = randX;
                balls[i].yDir = randY;
                balls[i].xPos = randXPos;
                balls[i].yPos = randYPos;
                balls[i].xCenter = randXPos;
                balls[i].yCenter = randYPos;
                hit++;
            }
        }
        return (hit > 0) ? true : false;
    }
    private double triDistance(Ball ball, Triangle triangle) {
        double dx = Math.abs(ball.xCenter - triangle.centerX);
        double dy = Math.abs(ball.yCenter - triangle.centerY);
        double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
        return distance;
    }
    private double distance(Ball ball, Paddle paddle) {
        double dx = Math.abs(ball.xCenter - paddle.xCenter);
        double dy = Math.abs(ball.yCenter - paddle.yCenter);

        double l1 = (dx * paddle.height) / (2 * dy);
        double l2 = paddle.height / 2;

        if (l1 > paddle.width / 2) {
            l1 = (dy * (paddle.width)) / (2 * dx);
            l2 = paddle.width / 2;
        }

        double distance = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
        double d2e = Math.sqrt(Math.pow(l1, 2) + Math.pow(l2, 2));
        return distance - d2e - ball.size / 2;
    }
}
