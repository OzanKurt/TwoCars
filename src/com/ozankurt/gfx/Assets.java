package com.ozankurt.gfx;

import java.awt.image.BufferedImage;

public class Assets {

//    private static final int width = 32, height = 32;

    public static BufferedImage blueCar;
    public static BufferedImage redCar;

//    public static BufferedImage player, dirt, grass, stone, tree;

    public static void init() {
        redCar = ImageLoader.loadImage("/textures/redCar.png");
        blueCar = ImageLoader.loadImage("/textures/blueCar.png");

//        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
//
//        //PLAYER SPRITES PROVIDED BY: AddFact
//        player = sheet.crop(width * 4, 0, width, height);
//
//        dirt = sheet.crop(width, 0, width, height);
//        grass = sheet.crop(width * 2, 0, width, height);
//        stone = sheet.crop(width * 3, 0, width, height);
//        tree = sheet.crop(0, 0, width, height);
    }

}
