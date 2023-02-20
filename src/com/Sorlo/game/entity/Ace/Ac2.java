package com.Sorlo.game.entity.Ace;

import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Culori.*;
import com.Sorlo.game.entity.Enemies.Enemy;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Proiectile.ProiectilGalben;
import com.Sorlo.game.entity.Proiectile.proiectilRosu;
import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;

public class Ac2 extends Entity {

    protected Enemy2 e2;
    protected Player p;
    boolean flag;
    protected com.Sorlo.game.entity.Proiectile.proiectilRosu proiectilRosu;
    public int pozx;
    boolean rendered;







    public Ac2(Sprite16 sprite, Vector2f origin, int size, Enemy2 e2, Player p) {


        super(sprite, origin, size);

        bounds.setWidth(1);
        bounds.setHeight(1);
        bounds.setXOffset(14);
        bounds.setyOffset(0);
        flag = true;

        this.e2=e2;
        this.p=p;
        pozx = 0;
        proiectilRosu=new proiectilRosu(new Sprite32("entity/ProiectilRosu.png"),new Vector2f(2600,300),32,e2);



    }

    public void move() throws InterruptedException {
        if (e2.isAlive && rendered==true && p.onArena2) {
            if (!e2.killsPlayer()) {
                System.out.println(p.attack);
                if (p.attack) {
                    e2.move();
                    e2.setFlag(true);
                } else {
                    if (pos.x >= 2480 && pos.x <= 2570) {
                        dx += 0.1;
                        e2.setInc(300);
                    } else {
                        dx -= 0.1;

                    }
                }


            } else
                p.isAlive=false;
        }
    }





    public boolean isGalben2(int pozx) {
        if (pozx >= 2510 && pozx < 2540 && p.pos.y!=97)
            return true;
        else return false;
    }

    public boolean isRosu2(int pozx) {
        if (pozx >= 2481 && pozx <2510 && p.pos.y!=97)
            return true;
        else return false;
    }

    public boolean isRoz2(int pozx) {
        if (pozx >= 2540 && pozx < 2570 && p.pos.y!=97)
            return true;
        else return false;
    }

    public boolean isAlbastru2(int pozx) {
        if (pozx >= 2570 && pozx < 2600 && p.pos.y!=97)
            return true;
        else return false;
    }

    public boolean isMov2(int pozx) {
        if (pozx >= 2600 && pozx < 2630 && p.pos.y!=97)
            return true;
        else return false;
    }

    public boolean isVerde2(int pozx) {
        if (pozx >= 2630 && pozx < 2660 && p.pos.y!=97)
            return true;
        else return false;
    }


    public synchronized void  atacare() {
        if(e2.isAlive && p.onArena2){
            dx = 0;
            pozx = (int) pos.x;

        }
    }


    public double getDx() {
        return dx;
    }



    public void render(Graphics2D g) throws InterruptedException, IOException {



        if(e2.isAlive && p.onArena2) {
            rendered=true;
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            g.setColor(Color.blue);
            g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), bounds.getWidth(), bounds.getHeight());
            move();
            pos.x += dx;


            if (isRosu2(pozx)) {
                {

                    dx = 0;
                    pos.x = 2480;
                    proiectilRosu.render(g);
                }

            } else if (isVerde2(pozx) || isAlbastru2(pozx) || isGalben2(pozx) || isMov2(pozx) || isRoz2(pozx)) {
                System.out.println("Inca nu a murit hahahhahahahaha");

            }
        }



    }


    public void update() throws InterruptedException {
    }

    @Override
    public Vector2f getPos() {
        return null;
    }
    public void input(MouseHandler mouse, KeyHandler key){
        if(mouse.getButton()==1){
            System.out.println("Ac: "+pos.x+","+pos.y);
        }

        if(key.attack.down){
            attack=true;

        }else {
            attack = false;
        }
    }
    public void animate(){
        if(attack)
        {

            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }



    }



}
