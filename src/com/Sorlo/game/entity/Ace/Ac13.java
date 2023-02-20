package com.Sorlo.game.entity.Ace;

import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Culori.*;
import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.entity.Enemies.Enemy;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Proiectile.ProiectilVerde2;
import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;

public class Ac13 extends Entity {

    protected Enemy e;
    protected Enemy2 e2;
    protected Player p;
    boolean flag;


    ProiectilVerde2 proiectilVerde;

    public int pozx;

    ENEM m1;
    PlayerNivel2 n1;






    public Ac13(Sprite16 sprite, Vector2f origin, int size, ENEM e1, PlayerNivel2 playerNivel2) {
        super(sprite, origin, size);
        bounds.setWidth(1);
        bounds.setHeight(1);
        bounds.setXOffset(14);
        bounds.setyOffset(0);
        flag = true;
        this.m1=e1;
        this.n1=playerNivel2;
        pozx = 0;

        proiectilVerde=new ProiectilVerde2(new Sprite32("entity/PVerde.png"),new Vector2f(50*16,8*16),32,m1);


    }

    public void move() throws InterruptedException {
        if(m1!=null) {
            if (m1.isAlive) {
                if (!m1.killsPlayer(73*16)) {
                    System.out.println(n1.attack);
                    if (n1.attack) {
                        System.out.println("A ATACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCAT");
                        m1.move(59*16);
                        m1.setFlag(true);
                    } else {
                        if (pos.x >= 59*16 && pos.x <= 59*16+32*2+16) {
                            dx += 0.1;
                            m1.setInc(300);
                        } else {
                            dx -= 0.1;

                        }
                    }


                } else {
                    n1.isAlive = false;
                }
            }
        }


    }



    public boolean isGalbenu(int pozx) {
        if (pozx >= 58*16+32 && pozx < 58*16+32+32)
            return true;
        else return false;
    }

    public boolean isRosuu(int pozx) {
        if (pozx >= 59*16 && pozx < 58*16+32)
            return true;
        else return false;
    }

    public boolean isRozu(int pozx) {
        if (pozx >= 58*16+32+32 && pozx < 58*16+32+32+32)
            return true;
        else return false;
    }

    public boolean isAlbastruu(int pozx) {
        if (pozx >= 58*16+32+32+32 && pozx < 58*16+32+32+32+32)
            return true;
        else return false;
    }

    public boolean isMovu(int pozx) {
        if (pozx >= 58*16+32*4 && pozx < 58*16+32*5)
            return true;
        else return false;
    }

    public boolean isVerdeu(int pozx) {
        if (pozx >= 58*16+32*5 && pozx < 58*16+32*6)
            return true;
        else return false;
    }



    public synchronized void  atacare() {
        if(n1!=null && m1.isAlive) {
            dx = 0;
            pozx = (int) pos.x;
        }
    }


    public double getDx() {
        return dx;
    }


    public void render(Graphics2D g) throws InterruptedException, IOException {
        if ( m1!=null)
        {
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            move();
            pos.x += dx;


            if (isVerdeu(pozx)) {
                {

                    dx = 0;
                    pos.x = 59*16;
                    proiectilVerde.render(g,59*16);

                }

            } else if (isRosuu(pozx) || isAlbastruu(pozx) || isGalbenu(pozx) || isMovu(pozx) || isRozu(pozx)) {


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
