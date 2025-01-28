package org.game.tile;

import org.game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int[][] mapTileNum;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("/maps/world.txt");
    }

    public void getTileImage() {
        try {
            tiles[Tiles.SNOW.getValue()] = new Tile(false, Tiles.SNOW);
            tiles[Tiles.SNOW.getValue()].image = ImageIO.read(getClass().getResource("/tiles/snow_tile.png"));

            tiles[Tiles.GRASS.getValue()] = new Tile(false, Tiles.GRASS);
            tiles[Tiles.GRASS.getValue()].image = ImageIO.read(getClass().getResource("/tiles/tile_grass.png"));

            tiles[Tiles.ROAD.getValue()] = new Tile(false, Tiles.ROAD);
            tiles[Tiles.ROAD.getValue()].image = ImageIO.read(getClass().getResource("/tiles/tile_road.png"));

            tiles[Tiles.WALL.getValue()] = new Tile(true, Tiles.WALL);
            tiles[Tiles.WALL.getValue()].image = ImageIO.read(getClass().getResource("/tiles/tile_wall.png"));

            tiles[Tiles.TREE.getValue()] = new Tile(true, Tiles.TREE);
            tiles[Tiles.TREE.getValue()].image = ImageIO.read(getClass().getResource("/tiles/tile_tree.png"));

            tiles[Tiles.SAND.getValue()] = new Tile(false, Tiles.SAND);
            tiles[Tiles.SAND.getValue()].image = ImageIO.read(getClass().getResource("/tiles/tile_sand.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {


        for (int worldCol = 0; worldCol < gamePanel.maxWorldCol; worldCol++) {
            for (int worldRow = 0; worldRow < gamePanel.maxWorldRow; worldRow++) {
                int tileNum = mapTileNum[worldRow][worldCol];

                int worldX = worldCol * gamePanel.TILE_SIZE;
                int worldY = worldRow * gamePanel.TILE_SIZE;
                int screenX = worldX - gamePanel.getPlayer().worldX + gamePanel.getPlayer().screenX;
                int screenY = worldY - gamePanel.getPlayer().worldY + gamePanel.getPlayer().screenY;


                g.drawImage(tiles[tileNum].image, screenX, screenY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);


            }


        }
    }


    public void loadMap(String file) {
        try {
            InputStream is = getClass().getResourceAsStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gamePanel.maxWorldRow; row++) {
                String line = br.readLine();
                if (line != null) {
                    String[] numbers = line.split("\\s+"); // Handle any whitespace
                    for (int col = 0; col < gamePanel.maxWorldCol; col++) {
                        if (col < numbers.length) {
                            // Fill mapTileNum[row][col] with the parsed number
                            mapTileNum[row][col] = Integer.parseInt(numbers[col]);
                        } else {
                            // Fill remaining columns with default value (e.g., 0)
                            mapTileNum[row][col] = Tiles.GRASS.getValue();
                        }
                    }
                } else {
                    // If no line exists, fill the entire row with default value
                    for (int col = 0; col < gamePanel.maxWorldCol; col++) {
                        mapTileNum[row][col] = Tiles.GRASS.getValue();
                    }
                }
                // Move to the next row after processing all columns
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
