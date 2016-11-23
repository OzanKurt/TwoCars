package com.ozankurt.entities;

import com.ozankurt.Handler;
import com.ozankurt.gfx.Assets;

import java.awt.event.KeyEvent;

public class RedCar extends Car {

    public static final int TOGGLE_KEY = KeyEvent.VK_G;

    public RedCar(Handler handler) {
        super(handler, (8 + ((54 / 2) - Car.DEFAULT_WIDTH / 2)), 512 - 8 - 64);

        this.image = Assets.redCar;
    }

}
