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
    Tile currentTile;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        screenX = gamePanel.ScreenWidth/2-gamePanel.TILE_SIZE/2;
        screenY = gamePanel.ScreenHeight/2-gamePanel.TILE_SIZE/2;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gamePanel.TILE_SIZE *23;
        worldY = gamePanel.TILE_SIZE *23;

        speed = 4;
        direction = "down";

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

        if (keyH.upPressed == true) {
            direction = "up";
            worldY -= speed;
        }
        if (keyH.downPressed == true) {
            direction = "down";
            worldY += speed;
        }

        if (keyH.leftPressed == true) {
            direction = "left";
            worldX -= speed;
        }
        if (keyH.rightPressed == true) {
            direction = "right";
            worldX += speed;
        }

    }

    public void render(Graphics g) {
        BufferedImage img = null;
        switch (direction) {
            case "up":
                if (worldY % 3 == 0) {
                    img = up;
                } else {
                    img = up2;
                }
                break;
            case "down":
                if (worldY % 3 == 0) {
                    img = down;
                } else {
                    img = down2;
                }
                break;
            case "left":
                if (worldX % 3 == 0) {
                    img = left;
                } else {
                    img = left2;
                }
                break;
            case "right":
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
