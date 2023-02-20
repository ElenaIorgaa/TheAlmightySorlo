package com.Sorlo.game.entity.Proiectile;

import com.Sorlo.game.entity.Enemies.Enemy3;
import com.Sorlo.game.entity.Entity;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;


public class proiectilVerde extends Entity {

    boolean flag;
    public Coliziuni ssense;
    int r=32;
    boolean flag2;
    Enemy3 e;


    public proiectilVerde(Sprite32 sprite, Vector2f origin, int size, Enemy3 e) {

        super(sprite, origin, size);

        flag=true;
        flag2=true;
        this.e=e;



    }


    public void move() throws InterruptedException {
        dx += 0.1;

    }

    public double getDx()
    {
        return dx;
    }


    public void render(Graphics2D g) throws InterruptedException {
        if(pos.x<3160) {
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            pos.x += dx;
            System.out.println("La Proiectil: " + pos.x);
            move();

        }
        else
        {
            e.Disappear();
        }

    }


    @Override
    public Vector2f getPos() {
        return null;
    }
    public void input(MouseHandler mouse, KeyHandler key) throws InterruptedException {
        if(mouse.getButton()==1){
            System.out.println("Ac: "+pos.x+","+pos.y);
        }

        if(key.attack.down){
            attack=true;

        }else {
            attack = false;
        }
    }

}


