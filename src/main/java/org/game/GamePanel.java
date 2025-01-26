package org.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTitleSize = 16;//16x16
    final int scale = 3;

    final int tileSize= originalTitleSize*scale;//48x48

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int ScreenWidth = tileSize*maxScreenCol;//768pxl
    final int ScreenHeight = tileSize*maxScreenRow;//576 pxl

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    int playerX=200;
    int playerY=100;
    int playerSpeed=4;

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
        double drawInterval= 1000000000/60.0 ;
        double nextDrawTime= System.nanoTime() + drawInterval ;

        while(gameThread!=null) {



        //Update: updates info  about  character
        this.update();

        //Draw: draw the screen with updated info
        this.repaint();

    }


    }


    public void update(){
        if(keyH.upPressed==true){
            playerY-=playerSpeed;
        }
        if(keyH.downPressed==true){
            playerY+=playerSpeed;
        }

        if(keyH.leftPressed==true){
            playerX-=playerSpeed;
        }
        if(keyH.rightPressed==true){
            playerX+=playerSpeed;
        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(playerX, playerY, tileSize, tileSize);
        g2d.dispose();
    }



}
