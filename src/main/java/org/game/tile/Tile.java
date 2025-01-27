package org.game.tile;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public boolean colision = false;

    Tile() {
    }

    Tile(boolean colision) {
        this.colision = colision;
    }

    public void setColision(boolean colision) {
        this.colision = colision;

    }

    public void setColision() {
        this.colision = true;
    }


}
