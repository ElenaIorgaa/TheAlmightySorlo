package com.Sorlo.game.entity;

import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;


public class Cheie extends Entity {


    public Coliziuni ssense;
    int r=32;

    Player p;



    public Cheie(Sprite16 sprite, Vector2f origin, int size) {

        super(sprite, origin, size);
        this.p=p;



    }



    public void move() throws InterruptedException {

    }

    public double getDx()
    {
        return dx;
    }



    public void render(Graphics2D g) throws InterruptedException {

        g.drawImage(ani.getImage(),(int)(pos.x),(int)(pos.y), size, size, null);

    }


    @Override
    public Vector2f getPos() {
        return null;
    }
    public void input(MouseHandler mouse, KeyHandler key){
    }

}


