package com.ozankurt.entities;

import com.ozankurt.Handler;

import java.awt.*;

public abstract class Square extends Entity {

    protected int currentSide;

    protected static final int LEFT_OFFSET = 19;
    protected static final int RIGHT_OFFSET = 58 + 19;

    public static final int DEFAULT_WIDTH = 32, DEFAULT_HEIGHT = 32;

    public Square(Handler handler, int x, int y) {
        super(handler, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void tick() {
        y += 4;
    }

    public abstract void render(Graphics g);

}
