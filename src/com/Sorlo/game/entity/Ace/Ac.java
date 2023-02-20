package com.Sorlo.game.entity.Ace;

import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Culori.*;
import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.entity.Enemies.Enemy;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Proiectile.ProiectilGalben;
import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;

public class Ac extends Entity {

    protected Enemy e;
    protected Enemy2 e2;
    protected Player p;
    boolean flag;
    boolean flag2;

    protected ProiectilGalben proiectilGalben;


    public int pozx;

    boolean b;
    ENEM m1;
    PlayerNivel2 n1;





    public Ac(Sprite16 sprite, Vector2f origin, int size, Enemy e, Enemy2 e2, Player p) {


        super(sprite, origin, size);

        bounds.setWidth(1);
        bounds.setHeight(1);
        bounds.setXOffset(14);
        bounds.setyOffset(0);
        flag = true;
        this.e = e;
        this.e2=e2;
        this.p=p;
        pozx = 0;
        proiectilGalben = new ProiectilGalben(new Sprite32("entity/ProiectilGalben32.png"), new Vector2f(1100, 300), 32, e);

        flag2 = true;




    }

    public Ac(Sprite16 sprite, Vector2f origin, int size, ENEM e1, PlayerNivel2 playerNivel2) {
        super(sprite, origin, size);

        bounds.setWidth(1);
        bounds.setHeight(1);
        bounds.setXOffset(14);
        bounds.setyOffset(0);
        flag = true;
        this.m1=e1;
        this.n1=playerNivel2;
        pozx = 0;
        proiectilGalben = new ProiectilGalben(new Sprite32("entity/ProiectilGalben32.png"), new Vector2f(1100, 300), 32, e);



    }

    public void move() throws InterruptedException {
        if(e!=null) {
            if (e.isAlive) {
                if (!e.killsPlayer()) {
                    System.out.println(p.attack);
                    if (p.attack) {
                        e.move();
                        e.setFlag(true);
                    } else {
                        if (pos.x >= 1291 && pos.x <= 1381) {
                            dx += 0.1;
                            e.setInc(300);
                        } else {
                            dx -= 0.1;

                        }
                    }


                } else {
                    p.isAlive = false;
                }
            }
        }
        if(n1!=null) {
            if (n1.isAlive) {
                if (!m1.killsPlayer(1069)) {
                    System.out.println(n1.attack);
                    if (n1.attack) {
                        System.out.println("A ATACCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCAT");
                        m1.move(1069);
                        m1.setFlag(true);
                    } else {
                        if (pos.x >= 600 && pos.x <= 600+32*6) {
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

    public boolean isGalben(int pozx) {
        if (pozx >= 1321 && pozx < 1351)
            return true;
        else return false;
    }

    public boolean isRosu(int pozx) {
        if (pozx >= 1291 && pozx < 1321)
            return true;
        else return false;
    }

    public boolean isRoz(int pozx) {
        if (pozx >= 1351 && pozx < 1381)
            return true;
        else return false;
    }

    public boolean isAlbastru(int pozx) {
        if (pozx >= 1381 && pozx < 1411)
            return true;
        else return false;
    }

    public boolean isMov(int pozx) {
        if (pozx >= 1411 && pozx < 1441)
            return true;
        else return false;
    }

    public boolean isVerde(int pozx) {
        if (pozx >= 1441 && pozx < 1471)
            return true;
        else return false;
    }



    public synchronized void  atacare() {
        if(p!=null) {
            if (e.isAlive && e2.isAlive) {
                dx = 0;
                pozx = (int) pos.x;
                if (flag == true)
                    flag = false;
                else flag = true;
            }
        }


    }


    public double getDx() {
        return dx;
    }

    public void render(Graphics2D g) throws InterruptedException, IOException {
        if(e!=null) {
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            g.setColor(Color.blue);
            g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), bounds.getWidth(), bounds.getHeight());
            move();
            pos.x += dx;


            if (isGalben(pozx)) {
                {

                    dx = 0;
                    pos.x = 1291;
                    proiectilGalben.render(g);
                }

            } else if (isVerde(pozx) || isAlbastru(pozx) || isRosu(pozx) || isMov(pozx) || isRoz(pozx)) {
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
