package JavaBreaker;

public class Paddle {
    int width;
    int height;
    int xPos;
    int yPos;
    int xSpeed;
    int xCenter;
    int yCenter;
    int ySpeed;
    int defaultSpeed;

    public Paddle(int width, int height, int xPos, int yPos) {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xCenter = this.xPos + this.width / 2;
        this.yCenter = this.yPos + this.height / 2;
        this.xSpeed = defaultSpeed;
        this.ySpeed = defaultSpeed;
    }

    public void tick() {
        if (this.xPos <= 0) {
            this.xPos = 1;
            this.xCenter = 1 + this.width / 2;
        }
        if (this.xPos + this.width >= 800) {
            this.xPos = 799 - this.width;
            this.xCenter = 799 - this.width / 2;
        } else {
            this.xPos += this.xSpeed;
            this.xCenter += this.xSpeed;
            this.yPos += this.ySpeed;
            this.yCenter += this.ySpeed;
        }
    }
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}
