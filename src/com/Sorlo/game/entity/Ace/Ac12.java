package com.Sorlo.game.entity.Ace;

import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Culori.*;
import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.entity.Enemies.Enemy;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Proiectile.proiectilRosu;
import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;

public class Ac12 extends Entity {


    protected Player p;

    protected com.Sorlo.game.entity.Proiectile.proiectilRosu proiectilRosu;

    boolean schimbare;
    public int pozx;

    ENEM m1;
    PlayerNivel2 n1;









    public Ac12(Sprite16 sprite, Vector2f origin, int size, ENEM e1, PlayerNivel2 playerNivel2) {
        super(sprite, origin, size);

        bounds.setWidth(1);
        bounds.setHeight(1);
        bounds.setXOffset(14);
        bounds.setyOffset(0);
        this.m1=e1;
        this.n1=playerNivel2;
        pozx = 0;
        proiectilRosu=new proiectilRosu(new Sprite32("entity/PRosu.png"),new Vector2f(600,300),32,e1);

        schimbare = false;



    }

    public void move() throws InterruptedException {
        if(n1!=null) {
            if (n1.isAlive) {
                if (!m1.killsPlayer(1069)) {
                    System.out.println(n1.attack);
                    if (n1.attack) {
                        System.out.println("A ATACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCAT");
                        m1.move(600);
                        m1.setFlag(true);
                    } else {
                        if (pos.x >= 600 && pos.x <= 600+32*2+16) {
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
        if (pozx >= 600+32 && pozx < 600+32+32)
            return true;
        else return false;
    }

    public boolean isRosuu(int pozx) {
        if (pozx >= 601 && pozx < 600+32)
            return true;
        else return false;
    }

    public boolean isRozu(int pozx) {
        if (pozx >= 600+32+32 && pozx < 600+32+32+32)
            return true;
        else return false;
    }

    public boolean isAlbastruu(int pozx) {
        if (pozx >= 600+32+32+32 && pozx < 600+32+32+32+32)
            return true;
        else return false;
    }

    public boolean isMovu(int pozx) {
        if (pozx >= 600+32*4 && pozx < 600+32*5)
            return true;
        else return false;
    }

    public boolean isVerdeu(int pozx) {
        if (pozx >= 600+32*5 && pozx < 600+32*6)
            return true;
        else return false;
    }



    public synchronized void  atacare() {
        if(n1!=null) {
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


            if (isRosuu(pozx)) {
                {

                    dx = 0;
                    pos.x = 600;
                    proiectilRosu.render(g,1069);
                }

            } else if (isVerdeu(pozx) || isAlbastruu(pozx) || isGalbenu(pozx) || isMovu(pozx) || isRozu(pozx)) {
                System.out.println(isAlbastruu(pozx)+" "+isGalbenu(pozx)+isRosuu(pozx)+isRozu(pozx));

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
