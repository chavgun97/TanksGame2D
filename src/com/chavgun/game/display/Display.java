package com.chavgun.game.display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private boolean isCreated = false;
    private JFrame window;
    private Canvas content;
    private static volatile Display instance;
    private Display(){ }
    public static Display getInstance(){
        Display localInstance = instance;
        if(localInstance == null){
            synchronized (Display.class){
                localInstance = instance;
                if(localInstance==null){
                    instance = localInstance = new Display();
                }
            }
        }
        return localInstance;
    }



    public void create(int with, int height, String title){
        if(isCreated){
            return;
        }
        //Window:
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Content:
        content = new Canvas(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                render(g);
            }
        };
        //Size:
        Dimension size = new Dimension(with, height);
        content.setPreferredSize(size);
        content.setBackground(Color.BLACK);
        //NotChange:
        window.setResizable(false);

        window.getContentPane().add(content);
        //Size adapt content
        window.pack();
        //position center
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    public void render(){
        content.repaint();
    }

    private void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(400-50, 300-50, 100,100);
    }
}
