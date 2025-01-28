package org.game.tile;

public enum Tiles {


    SNOW(0, "snow" ),
    GRASS(1, "grass" ),
    ROAD(2, "road" ),
    WALL(3, "wall" ),
    TREE(4, "tree" ),
    SAND(5, "sand" ), ;

    private final int value;
    private  final String name;

    Tiles(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name;
    }


}
