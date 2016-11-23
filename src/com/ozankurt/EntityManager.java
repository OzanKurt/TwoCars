package com.ozankurt;

import com.ozankurt.entities.*;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Entity> entities = new ArrayList<>();

    private final Handler handler;

    private int obstacleDelay = 2;
    private int obstacleDelayCount = 0;

    public EntityManager(Handler handler) {
        this.handler = handler;
    }

    public void init() {
        Car redCar =  new RedCar(handler);
        Car blueCar = new BlueCar(handler);

        entities.add(redCar);
        entities.add(blueCar);

        handler.getKeyManager().setRedCar(redCar);
        handler.getKeyManager().setBlueCar(blueCar);
    }

    public void tick() {
        if (timeForNextObstacle()) {
            Square redSquare = new RedSquare(handler);
            entities.add(redSquare);
        }

        entities.forEach(Entity::tick);
    }

    private boolean timeForNextObstacle() {
        int loopStep = handler.getGame().getLoopStep();

        if (loopStep == 0) {
            if (obstacleDelayCount == obstacleDelay) {
                obstacleDelayCount = 0;
                return true;
            }

            obstacleDelayCount++;
            return false;
        }

        return false;
    }

    public void render(Graphics g) {
        final Color roadColor = new Color(105, 105, 105);
        final int roadWidth = handler.getWidth() / 2;
        final int barrierWidth = 8;
        final int barrierHeight = 32;

        g.setColor(roadColor);
        g.fillRect(0, 0, roadWidth, handler.getHeight());
        g.fillRect(roadWidth, 0, roadWidth, handler.getHeight());

        final int loopStep = 4 * handler.getGame().getLoopStep();

        for (int i = -8; i < handler.getHeight() / barrierHeight; i++) {
            toggleBarrierColor(g);
            g.fillRect(0                           , loopStep + i * barrierHeight, barrierWidth, barrierHeight);
            g.fillRect(roadWidth - barrierWidth    , loopStep + i * barrierHeight, barrierWidth, barrierHeight);
            g.fillRect(roadWidth                   , loopStep + i * barrierHeight, barrierWidth, barrierHeight);
            g.fillRect(roadWidth * 2 - barrierWidth, loopStep + i * barrierHeight, barrierWidth, barrierHeight);
        }

        final int whiteLineWidth = 4;
        final int whiteLineHeight = 32;
        final int whiteLineOffsetLeft = (roadWidth / 2) - (whiteLineWidth / 2);
        final int whiteLineOffsetTop = whiteLineHeight / 2;

        g.setColor(Color.WHITE);
        for (int i = -8; i < handler.getHeight() / whiteLineHeight; i++) {
            if (i % 2 == 0) {
                g.fillRect(whiteLineOffsetLeft            , loopStep + whiteLineOffsetTop + i * whiteLineHeight, whiteLineWidth, whiteLineHeight);
                g.fillRect(whiteLineOffsetLeft + roadWidth, loopStep + whiteLineOffsetTop + i * whiteLineHeight, whiteLineWidth, whiteLineHeight);
            }
        }

        for (Entity entity : entities) {
            entity.render(g);
        }
    }

    private void toggleBarrierColor(Graphics g) {
        if (g.getColor() == Color.YELLOW)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.YELLOW);
    }
}
