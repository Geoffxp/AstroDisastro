package JavaBreaker;

public class Ball {
    int size = 10;
    int xPos;
    int yPos;
    int xDir;
    int yDir;
    int xCenter;
    int yCenter;

    public Ball(int xPos, int yPos, int xDir, int yDir) {
        this.size = size;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xDir = xDir;
        this.yDir = yDir;
        this.xCenter = this.xPos + this.size / 2;
        this.yCenter = this.yPos + this.size / 2;
    }

    void tick() {
        if (this.xPos < 0 || this.xPos + this.size > 1422) {
            this.xDir = -this.xDir;
        }
        if (this.yPos < 0 || this.yPos + this.size > 859) {
            this.yDir = -this.yDir;
        }
        this.xPos += this.xDir;
        this.yPos += this.yDir;
        this.xCenter += this.xDir;
        this.yCenter += this.yDir;
    }

    void setDirection(int x, int y)  {
        this.xDir = x;
        this.yDir = y;
    }
}
