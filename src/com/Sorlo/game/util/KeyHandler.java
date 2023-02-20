package com.Sorlo.game.util;
import com.Sorlo.game.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;


/**
 * este clasa ce ne va ajuta sa inregistram input-ul de la tastatura
 */
public class KeyHandler implements KeyListener{

    public static List<Key> keys = new ArrayList<Key>();//facem o lista de chei ( tastele ce vor fi apasate)
    public AWTKeyStroke ke;
    boolean spacePressed=false;

    public class Key {
        public int presses, absorbs;
        public boolean down, clicked;



        public Key() {
            keys.add(this);
        }
        public AWTKeyStroke getKe()
        {
            return ke;
        }

        public void toggle(boolean pressed) { ///comuta la tasta apasata
            if(pressed != down) {
                down = pressed;
            }
            if(pressed) {
                presses++;
            }
        }

        public void tick() {
            if(absorbs < presses) {
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }

    public Key up = new Key(); ///face o noua ,,cheie" care va fi denumita up
    public Key down = new Key(); ///face o noua ,,cheie" care va fi denumita down
    public Key left = new Key(); ///face o noua ,,cheie" care va fi denumita left
    public Key right = new Key(); ///face o noua ,,cheie" care va fi denumita right
    public Key jump= new Key(); ///face o noua ,,cheie" care va fi denumita jump
    public Key menu = new Key(); ///face o noua ,,cheie" care va fi denumita menu
    public Key attack = new Key(); ///face o noua ,,cheie" care va fi denumita attack
    public Key escape = new Key(); ///face o noua ,,cheie" care va fi denumita escape
    public Key shift = new Key(); ///face o noua ,,cheie" care va fi denumita shift


    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);//KeyListener-ul este cel care va fi notificat atunci cand schimbam tasta apasata
    }


    public void toggle(KeyEvent e, boolean pressed) {
        if(e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed); ///Daca apasam tasta W, atunci cheia up va fi activata
        if(e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);///Daca apasam tasta S, atunci cheia down va fi activata
        if(e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);///Daca apasam tasta A, atunci cheia left va fi activata
        if(e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);///Daca apasam tasta D, atunci cheia right va fi activata
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {jump.toggle(pressed);///Daca apasam tasta SPACE, atunci cheia space va fi activata

            }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) attack.toggle(pressed);///Daca apasam tasta ENTER atunci cheia attack va fi activata
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);///Daca apasam tasta ESCAPE, atunci cheia ESCAPE va fi activata

    }



    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {

        toggle(e,true);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);

    }
}
