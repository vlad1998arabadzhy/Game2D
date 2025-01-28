package org.game.tile;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public boolean colision = false;
    public Tiles tileName;

    Tile() {
    }

    Tile(boolean colision) {
        this.colision = colision;
    }


    Tile(boolean colision, Tiles tileName) {
        this.colision = colision;
        this.tileName = tileName;
    }
    public void setColision(boolean colision) {
        this.colision = colision;

    }

    public void setColision() {
        this.colision = true;
    }


}
