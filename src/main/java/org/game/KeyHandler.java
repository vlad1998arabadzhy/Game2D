package org.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key= Character.toLowerCase(e.getKeyChar());
        System.out.println("Key pressed: " + key);

        switch (key) {
            case 'w':
                upPressed = true;
                break;
            case 's':
                downPressed = true;
                break;
            case 'a':
                leftPressed = true;
                break;
            case 'd':
                rightPressed = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key= Character.toLowerCase(e.getKeyChar());
        System.out.println("Key released: " + key);

        switch (key) {
            case 'w':
                upPressed = false;
                break;
            case 's':
                downPressed = false;
                break;
            case 'a':
                leftPressed = false;
                break;
            case 'd':
                rightPressed = false;
                break;
        }
    }
}
