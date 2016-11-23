package com.ozankurt.entities;

import com.ozankurt.Handler;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class RedSquare extends Square {

    public RedSquare(Handler handler) {
        // (8 + ((54 / 2) - 32 / 2))
        super(handler, 0, -32);

        currentSide = ThreadLocalRandom.current().nextInt(1, 3);

        if (currentSide == 1) {
            x = LEFT_OFFSET;
        } else {
            x = RIGHT_OFFSET;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
