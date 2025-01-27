package org.game;

import org.game.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GamePanel extends JPanel implements Runnable {



    //SCREEN SETTINGS
    final int ORIGINAL_TILE_SIZE = 16;//16x16
    final int SCALE = 3;

    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;//48x48

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int ScreenWidth = TILE_SIZE *maxScreenCol;//768pxl
    final int ScreenHeight = TILE_SIZE *maxScreenRow;//576 pxl

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();


    //Player
    int playerX=200;
    int playerY=100;
    int playerSpeed=4;
    int FPS = 60;
    Player player = new Player(this, keyH);


    //Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);

        this.setFocusable(true);
        this.requestFocusInWindow(true);
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("focusGained");
            }
           @Override
           public void focusLost(FocusEvent e) {
                System.out.println("focusLost");
           }
        });



    }

public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();


}
    @Override
    public void run() {
        double drawInterval= 1000000000/FPS ;// 0.01666 seconds
        double nextDrawTime = System.nanoTime()+drawInterval;

        while(gameThread!=null) {

        //Update: updates info  about  character
        this.update();

        //Draw: draw the screen with updated info
        this.repaint();

        try{
        double remainingTime=  nextDrawTime-System.nanoTime();
        remainingTime =remainingTime/1000000;

        if(remainingTime<0) remainingTime=0;

        Thread.sleep((long)remainingTime);
        nextDrawTime+=drawInterval;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    }


    public void update(){

    player.update();


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        player.render(g2d);

        g2d.dispose();
    }



}
