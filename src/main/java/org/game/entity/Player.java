package org.game.entity;

import org.game.GamePanel;
import org.game.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 5;
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
            y -= speed;
        }
        if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        }

        if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        }
        if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }

    }

    public void render(Graphics g) {
        BufferedImage img = null;
        switch (direction) {
            case "up":
                if (y % 2 == 0) {
                    img = up;
                } else {
                    img = up2;
                }
                break;
            case "down":
                if (y % 2 == 0) {
                    img = down;
                } else {
                    img = down2;
                }
                break;
            case "left":
                if (x % 2 == 0) {
                    img = left;
                } else {
                    img = left2;
                }
                break;
            case "right":
                if (x % 2 == 0) {
                    img = right;
                } else {
                    img = right2;
                }
                break;
        }
        g.drawImage(img, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);

    }

}
