package org.game.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
public int worldX, worldY;
public int speed;
public BufferedImage up, down, left, right, up2, down2, left2, right2;
public Direction direction;
public Rectangle solidArea;
public boolean colision = false;



}
