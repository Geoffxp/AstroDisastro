package JavaBreaker;

import javax.swing.*;
import java.awt.*;

public class Triangle {
    int x;
    int y;
    int mouseX;
    int mouseY;
    int xDistance;
    int yDistance;
    double rotationAngle;
    double rotationAngleL;
    double rotationAngleR;
    double topX;
    double leftX;
    double rightX;
    double topY;
    double leftY;
    double rightY;
    int ySpeed;
    int xSpeed;
    double centerX;
    double centerY;

    public Triangle() {
        this.x = 720;
        this.y = 450;
        this.mouseX = 0;
        this.mouseY = 0;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        this.xDistance = x - mouseX;
        this.yDistance = y - mouseY;
        this.rotationAngle = Math.toDegrees(Math.atan2(yDistance, xDistance));
        this.rotationAngleL = rotationAngle + 30;
        this.rotationAngleR = rotationAngle - 30;
        this.topX = x;
        this.leftX = x + 100 * Math.cos(2 * Math.PI * rotationAngleL / 360);
        this.rightX = x + 100 * Math.cos(2 * Math.PI * rotationAngleR / 360);
        this.topY = y;
        this.leftY = y + 100 * Math.sin(2 * Math.PI * rotationAngleL / 360);
        this.rightY = y + 100 * Math.sin(2 * Math.PI * rotationAngleR / 360);
        this.centerX = (topX + rightX + leftX) / 3;
        this.centerY = (topY + rightY + leftY) / 3;
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawPolygon(
                new int[] {(int) this.leftX,
                        (int) this.topX, (int) this.rightX},
                new int[]{(int) this.leftY,
                        (int) this.topY, (int) this.rightY},
                3);
    }
    public void tick() {
        this.xDistance = x - mouseX;
        this.yDistance = y - mouseY;
        this.rotationAngle = Math.toDegrees(Math.atan2(yDistance, xDistance));
        this.rotationAngleL = rotationAngle + 30;
        this.rotationAngleR = rotationAngle - 30;
        this.topX = x;
        this.leftX = x + 100 * Math.cos(2 * Math.PI * rotationAngleL / 360);
        this.rightX = x + 100 * Math.cos(2 * Math.PI * rotationAngleR / 360);
        this.topY = y;
        this.leftY = y + 100 * Math.sin(2 * Math.PI * rotationAngleL / 360);
        this.rightY = y + 100 * Math.sin(2 * Math.PI * rotationAngleR / 360);
        this.x += this.xSpeed;
        this.y += this.ySpeed;
        this.centerX = (topX + rightX + leftX) / 3;
        this.centerY = (topY + rightY + leftY) / 3;

    }
    public void goTo(int x, int y) {
        double dx = topX - mouseX;
        double dy = topY - mouseY;
        this.xSpeed = (int) -dx / 15;
        this.ySpeed = (int) -dy / 15;
    }

    public void setXSpeed(int x) {
        this.xSpeed = x;
    }
    public void setYSpeed(int y) {
        this.ySpeed = y;
    }
    public void setMouseX(int x) {
        this.mouseX = x;
    }
    public void setMouseY(int y) {
        this.mouseY = y;
    }
}
