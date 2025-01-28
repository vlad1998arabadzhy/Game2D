package org.game.entity;

import org.game.GamePanel;
import org.game.KeyHandler;
import org.game.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;


    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        screenX = gamePanel.ScreenWidth / 2 - gamePanel.TILE_SIZE / 2;
        screenY = gamePanel.ScreenHeight / 2 - gamePanel.TILE_SIZE / 2;

        //Colision Rectangle;
        solidArea = new Rectangle(8, 16, 32, 32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = 100;
        worldY = 100;

        speed = 4;
        direction = Direction.DOWN;

    }


    public void getPlayerImage() {
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/player/player_up.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up2.png"));

            down = ImageIO.read(getClass().getResourceAsStream("/player/player_down.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down2.png"));

            left = ImageIO.read(getClass().getResourceAsStream("/player/player_left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left2.png"));

            right = ImageIO.read(getClass().getResourceAsStream("/player/player_right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update() {

        if (keyH.upPressed) {
            direction = Direction.UP;

        } else if (keyH.downPressed) {
            direction = Direction.DOWN;

        } else if (keyH.leftPressed) {
            direction = Direction.LEFT;

        } else if (keyH.rightPressed) {
            direction = Direction.RIGHT;

        }
        //CHECK COLISION
        colision = false;
        gamePanel.colisionHandler.checkColision(this);

        if (!colision) {
            switch (direction) {
                case UP:
                    if (keyH.upPressed) worldY -= speed;colision = false;
                    break;
                case DOWN:
                    if (keyH.downPressed) worldY += speed;colision = false;
                    break;
                case LEFT:
                    if (keyH.leftPressed) worldX -= speed;colision = false;
                    break;
                case RIGHT:
                    if (keyH.rightPressed) worldX += speed;colision = false;
                    break;
            }
        }

    }


    public void render(Graphics g) {
        BufferedImage img = null;

        switch (direction) {
            case UP:
                if (worldY % 3 == 0) {
                    img = up;
                } else {
                    img = up2;
                }
                break;
            case DOWN:
                if (worldY % 3 == 0) {
                    img = down;
                } else {
                    img = down2;
                }
                break;
            case LEFT:
                if (worldX % 3 == 0) {
                    img = left;
                } else {
                    img = left2;
                }
                break;
            case RIGHT:
                if (worldX % 3 == 0) {
                    img = right;
                } else {
                    img = right2;
                }
                break;
        }
        g.drawImage(img, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);

    }

}
