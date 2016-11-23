package com.ozankurt.entities;

import com.ozankurt.Handler;
import com.ozankurt.gfx.Assets;

import java.awt.event.KeyEvent;

public class BlueCar extends Car {

    public static final int TOGGLE_KEY = KeyEvent.VK_J;

    public BlueCar(Handler handler) {
        super(handler, (8 + ((54 / 2) - Car.DEFAULT_WIDTH / 2)) + handler.getWidth() / 2, 440);

        this.image = Assets.blueCar;
    }

}
