package com.ozankurt.entities;

import com.ozankurt.Handler;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Car extends Entity {

    public static final int DEFAULT_HEALTH = 10;

    public static final int DEFAULT_WIDTH = 32,
                            DEFAULT_HEIGHT = 64;

    private int currentSide = SIDE_LEFT;

    private static final int SIDE_LEFT = 1;
    private static final int SIDE_RIGHT = 2;

    protected int health;

    protected BufferedImage image;

    public Car(Handler handler, int x, int y) {
        super(handler, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.health = DEFAULT_HEALTH;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public void switchSide() {
        int roadHalfWidth = ((handler.getWidth() / 2) - 16 - 4) / 2 + 4;
        if (currentSide == Car.SIDE_LEFT) {
            currentSide = Car.SIDE_RIGHT;
            x += roadHalfWidth;
        } else {
            currentSide = Car.SIDE_LEFT;
            x -= roadHalfWidth;
        }
    }

}
