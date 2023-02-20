package com.Sorlo.game.entity.Ace;

import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Culori.*;
import com.Sorlo.game.entity.Enemies.Enemy3;
import com.Sorlo.game.entity.Proiectile.ProiectilGalben;
import com.Sorlo.game.entity.Proiectile.proiectilVerde;
import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;

public class Ac3 extends Entity {


    protected Enemy3 e3;
    protected Player p;
    boolean flag;

    int nrAtacuri;
    com.Sorlo.game.entity.Proiectile.proiectilVerde proiectilVerde;
    boolean schimbare;
    public int pozx;
    boolean rendered;





    public Ac3(Sprite16 sprite, Vector2f origin, int size, Enemy3 e3, Player p) {


        super(sprite, origin, size);
        bounds.setWidth(1);
        bounds.setHeight(1);
        bounds.setXOffset(14);
        bounds.setyOffset(0);
        flag = true;
        this.e3=e3;
        this.p=p;
        pozx = 0;


        flag = true;
        nrAtacuri = 0;

        schimbare = false;

        rendered=false;



     proiectilVerde=new proiectilVerde(new Sprite32("entity/ProiectilVerde.png"),new Vector2f(2820,92),32,e3);


    }

    public void move() throws InterruptedException {
        if (e3.isAlive && rendered) {
            if (!e3.killsPlayer()) {
                System.out.println(p.attack);
                if (p.attack) {
                    e3.move();
                    e3.setFlag(true);
                } else {
                    if (pos.x >= 2800 && pos.x <= 2890) {
                        dx += 0.1;
                        e3.setInc(300);
                    } else {
                        dx -= 0.1;

                    }
                }


            } else
                p.isAlive=false;
        }
    }





    public boolean isRosu3(int pozx) {
        if (pozx >=2800 && pozx < 2831 && p.pos.y==97)
            return true;
        else return false;
    }

    public boolean isGalben3(int pozx ) {
        if (pozx >= 2831 && pozx <2861 && p.pos.y==97)
            return true;
        else return false;
    }

    public boolean isRoz3(int pozx) {
        if (pozx >= 2861 && pozx < 2891)
            return true;
        else return false;
    }

    public boolean isAlbastru3(int pozx) {
        if (pozx >= 2891 && pozx < 2921 )
            return true;
        else return false;
    }

    public boolean isMov3(int pozx) {
        if (pozx >= 2921 && pozx < 2951 )
            return true;
        else return false;
    }

    public boolean isVerde3(int pozx) {
        if (pozx >= 2951&& pozx < 2981 )
            return true;
        else return false;
    }


    public synchronized void  atacare() {
        if(e3.isAlive){
            dx = 0;
            pozx = (int) pos.x;

        }
    }


    public double getDx() {
        return dx;
    }



    public void render(Graphics2D g) throws InterruptedException, IOException {


        if(e3.isAlive ) {
            rendered=true;
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            g.setColor(Color.blue);
            g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), bounds.getWidth(), bounds.getHeight());
            move();
            pos.x += dx;


            if (isVerde3(pozx)) {
                {

                    dx = 0;
                    pos.x = 2800;
                   proiectilVerde.render(g);


                }

            } else if (isRosu3(pozx) || isAlbastru3(pozx) || isGalben3(pozx) || isMov3(pozx) || isRoz3(pozx)) {

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
