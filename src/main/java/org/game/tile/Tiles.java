package org.game.tile;

import javax.imageio.ImageIO;

public enum Tiles {


    SNOW(0),
    GRASS(1),
    ROAD(2),
    WALL(3),
    TREE(4),
    SAND(5);

    private final int value;

    Tiles(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }


}
