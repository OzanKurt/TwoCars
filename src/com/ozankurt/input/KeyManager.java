package com.ozankurt.input;

import com.ozankurt.entities.BlueCar;
import com.ozankurt.entities.Car;
import com.ozankurt.entities.RedCar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private Car redCar;
    private Car blueCar;

    public KeyManager() {

    }

    public Car getRedCar() {
        return redCar;
    }

    public void setRedCar(Car redCar) {
        this.redCar = redCar;
    }

    public Car getBlueCar() {
        return blueCar;
    }

    public void setBlueCar(Car blueCar) {
        this.blueCar = blueCar;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == BlueCar.TOGGLE_KEY) {
            blueCar.switchSide();
        }

        if (key == RedCar.TOGGLE_KEY) {
            redCar.switchSide();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
