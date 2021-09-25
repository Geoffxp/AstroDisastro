package JavaBreaker;

import java.awt.*;

public class Particle {
    int xTail;
    int yTail;
    int xHead;
    int yHead;
    int xDir;
    int yDir;
    int initXHead;
    int initYHead;
    int initXTail;
    int initYTail;

    boolean remove;

    public Particle(int x, int y, int xDir, int yDir) {
        this.initXHead = x;
        this.initYHead = y;
        this.initXTail = x;
        this.initYTail = y;
        this.xTail = x;
        this.yTail = y;
        this.xHead = x;
        this.yHead = y;
        this.xDir = xDir;
        this.yDir = yDir;
        this.remove = false;

    }

    void draw (Graphics g) {
        if (!this.remove) {
            g.setColor(Color.WHITE);
            g.drawLine(this.xTail, this.yTail, this.xHead, this.yHead);
        }

    }

    void tick() {
        if (this.xDir > 0 && this.yDir == 0) {
            if (this.xHead < this.initXHead + 20) {
                this.xHead += this.xDir;
            }
            if (this.xHead > this.initXHead + 5) {
                this.xTail += this.xDir;
            }
            if (this.xTail > this.xHead) {
                this.remove = true;
            }
        }
        if (this.xDir < 0 && this.yDir == 0) {
            if (this.xHead > this.initXHead - 20) {
                this.xHead += this.xDir;
            }
            if (this.xHead < this.initXHead - 5) {
                this.xTail += this.xDir;
            }
            if (this.xTail < this.xHead) {
                this.remove = true;
            }
        }
        if (this.yDir > 0 && this.xDir == 0) {
            if (this.yHead < this.initYHead + 20) {
                this.yHead += this.yDir;
            }
            if (this.yHead > this.initYHead + 5) {
                this.yTail += this.yDir;
            }
            if (this.yTail > this.yHead) {
                this.remove = true;
            }
        }
        if (this.yDir < 0 && this.xDir == 0) {
            if (this.yHead > this.initYHead - 20) {
                this.yHead += this.yDir;
            }
            if (this.yHead < this.initYHead - 5) {
                this.yTail += this.yDir;
            }
            if (this.yTail < this.yHead) {
                this.remove = true;
            }
        }
        if (this.xDir > 0 && this.yDir > 0) {
            if (this.xHead < this.initXHead + 15 && this.yHead < this.initYHead + 15) {
                this.xHead += this.xDir;
                this.yHead += this.yDir;
            }
            if (this.xHead > this.initXHead + 5 && this.yHead > this.initYHead + 5) {
                this.xTail += this.xDir;
                this.yTail += this.yDir;
            }
            if (this.xTail > this.xHead) {
                this.remove = true;
            }
        }
        if (this.xDir < 0 && this.yDir < 0) {
            if (this.xHead > this.initXHead - 15 && this.yHead > this.initYHead - 15) {
                this.xHead += this.xDir;
                this.yHead += this.yDir;
            }
            if (this.xHead < this.initXHead - 5 && this.yHead < this.initYHead - 5) {
                this.xTail += this.xDir;
                this.yTail += this.yDir;
            }
            if (this.xTail < this.xHead) {
                this.remove = true;
            }
        }
        if (this.xDir > 0 && this.yDir < 0) {
            if (this.xHead < this.initXHead + 15 && this.yHead > this.initYHead - 15) {
                this.xHead += this.xDir;
                this.yHead += this.yDir;
            }
            if (this.xHead > this.initXHead + 5 && this.yHead < this.initYHead - 5) {
                this.xTail += this.xDir;
                this.yTail += this.yDir;
            }
            if (this.xTail > this.xHead) {
                this.remove = true;
            }
        }
        if (this.xDir < 0 && this.yDir > 0) {
            if (this.xHead > this.initXHead - 15 && this.yHead < this.initYHead + 15) {
                this.xHead += this.xDir;
                this.yHead += this.yDir;
            }
            if (this.xHead < this.initXHead - 5 && this.yHead > this.initYHead + 5) {
                this.xTail += this.xDir;
                this.yTail += this.yDir;
            }
            if (this.xTail < this.xHead) {
                this.remove = true;
            }
        }



    }

}
