package com.ozankurt.entities;

import com.ozankurt.Handler;

import java.awt.*;

public abstract class Entity {

    /** Handler */
    protected Handler handler;

    /** Positions */
    protected int x, y;

    /** Size */
    protected int width, height;

    public Entity(Handler handler, int x, int y, int width, int height){
        this.handler = handler;

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
