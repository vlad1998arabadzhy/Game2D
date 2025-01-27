package org.game;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setTitle("Game");
        window.setResizable(true);

        GamePanel gamePanel = new GamePanel();
        gamePanel.requestFocus();
        window.add(gamePanel);
        SwingUtilities.invokeLater(gamePanel::requestFocusInWindow);
        window.pack();
    //
       gamePanel.startGameThread();







    }
}