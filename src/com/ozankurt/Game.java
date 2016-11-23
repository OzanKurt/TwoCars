package com.ozankurt;

import com.ozankurt.gfx.Assets;
import com.ozankurt.input.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private String title;

    private Thread thread;

    private Display display;

    private int width;
    private int height;

    private Graphics g;
    private BufferStrategy buffer;

    private EntityManager entityManager;

    //Input
    private KeyManager keyManager;

    //Handler
    private Handler handler;

    private int loopStep = 0;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();
    }

    public void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);

        // Initialize assets
        Assets.init();

        // Instantiate handler
        handler = new Handler(this);

        entityManager = new EntityManager(handler);
        entityManager.init();
    }

    public synchronized void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        entityManager.tick();
    }

    public void render() {
        buffer = display.canvas.getBufferStrategy();
        if (buffer == null) {
            display.canvas.createBufferStrategy(3);
            return;
        }

        g = buffer.getDrawGraphics();
//        g.clearRect(0, 0, width, height);

        //draw start
        entityManager.render(g);

        //draw end
        buffer.show();
        g.dispose();
    }

    public void run() {
        init();
        int fps = 64;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long current = System.nanoTime();

        while (true) {
            delta = delta + (System.nanoTime() - current) / timePerTick;
            current = System.nanoTime();
            if (delta >= 1) {
                tick();
                render();
                delta--;

                loopStep++;

                if (loopStep > fps) {
                    loopStep = 0;
                }
            }
        }
    }

    public Display getDisplay() {
        return display;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLoopStep() {
        return loopStep;
    }

}
