package org.game.entity;

public enum Direction {
    UP("up"),
    DOWN("down"),
    LEFT("left"),
    RIGHT("right");


    private String direction;

    Direction(String direction) {
    }

    public String getDirection() {
        return this.direction;
    }
}
