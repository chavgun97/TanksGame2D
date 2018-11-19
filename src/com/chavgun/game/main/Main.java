package com.chavgun.game.main;

import com.chavgun.game.display.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {


    public static void main(String[] args) {

        Display display = Display.getInstance();
        display.create(800, 600, "MyFirstTitle");


        Timer t = new Timer(1000/60,new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                display.render();
            }
        });
        t.setRepeats(true);
        t.start();

    }
}
