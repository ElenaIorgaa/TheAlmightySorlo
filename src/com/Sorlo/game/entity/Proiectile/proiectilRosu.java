package com.Sorlo.game.entity.Proiectile;

import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Entity;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;


public class proiectilRosu extends Entity {

    boolean flag;
    public Coliziuni ssense;
    int r=32;
    boolean flag2;
    Enemy2 e;
    ENEM e1;


    public proiectilRosu(Sprite32 sprite, Vector2f origin, int size, Enemy2 e) {

        super(sprite, origin, size);

        flag=true;
        flag2=true;
        this.e=e;



    }
    public proiectilRosu(Sprite32 sprite, Vector2f origin, int size, ENEM e) {

        super(sprite, origin, size);

        flag=true;
        flag2=true;
        this.e1=e;



    }



    public void move() throws InterruptedException {
        dx += 0.1;

    }

    public double getDx()
    {
        return dx;
    }


    public void render(Graphics2D g) throws InterruptedException {
        if(pos.x<2840) {
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
    public void render(Graphics2D g, int pozitiaFantomitei) throws InterruptedException {
        if(pos.x<pozitiaFantomitei) {
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            pos.x += dx;
            System.out.println("La Proiectil: " + pos.x);
            move();

        }
        else
        {
            if(e1!=null)
             e1.Disappear();
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


