package com.Sorlo.game.entity;

import com.Sorlo.game.entity.Ace.Ac;
import com.Sorlo.game.entity.Ace.Ac2;
import com.Sorlo.game.entity.Ace.Ac3;
import com.Sorlo.game.entity.Culori.*;
import com.Sorlo.game.entity.Enemies.Enemy;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Enemies.Enemy3;
import com.Sorlo.game.graphics.Font;
import com.Sorlo.game.graphics.Sprites.Sprite;
import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.states.PlayState;
import com.Sorlo.game.util.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity {


    int pozitie;
    Rect scara;
    private Butoi butoi1;
    private Butoi butoi2;
    private Butoi butoi3;

    public Font font;
    double gravity;
    double friction;

    public Rect CameraDreapta;


    protected CuloareRosie cRosie;
    protected CuloareGalbena cGalbena;
    protected CuloareRoz cRoz;
    protected CuloareAlbastra cAlbastru;
    protected CuloareMov cMov;
    protected CuloareVerde cVerde;
    protected CuloareRosie cRosie2;
    protected CuloareGalbena cGalbena2;
    protected CuloareRoz cRoz2;
    protected CuloareAlbastra cAlbastru2;
    protected CuloareMov cMov2;
    protected CuloareVerde cVerde2;

    protected CuloareRosie cRosie3;
    protected CuloareGalbena cGalbena3;
    protected CuloareRoz cRoz3;
    protected CuloareAlbastra cAlbastru3;
    protected CuloareMov cMov3;
    protected CuloareVerde cVerde3;

    protected Ac ac;
    protected Ac2 ac2;
    protected Ac3 ac3;
    int attackPoz;

    public Coliziuni incercare;

    Enemy e;
    Enemy2 e2;
    Enemy3 e3;
    Cheie cheie1;
    Cheie cheie2;
    Cheie cheie3;
    Cheie cheie4;

    public boolean onArena;
    public boolean onArena2;
    public boolean onArena3;
    public boolean isAlive;
    public int DY;
    boolean saritura;
    int inc2 = 300;
    Rect sc;
    Rect cheieRect1;
    Rect cheieRect2;
    Rect cheieRect3;
    Rect cheieRect4;
    boolean esteCheia1;
    boolean esteCheia2;
    boolean esteCheia3;
    boolean esteCheia4;
    boolean esteButoi1;
    boolean esteButoi2;
    boolean esteButoi3;
    Rect b1r;
    Rect b2r;
    Rect b3r;
    public int cheiColectate;
    public int butoaieColectate;
    public int entitatiOmorate;
    public boolean once1;
    public boolean once2;
    public boolean once3;
    public boolean once4;
    public boolean bonce1;
    public boolean bonce2;
    public boolean bonce3;
    public boolean nextLevel;
    Rect arena1;
    Rect arena2;
    Rect arena3;


    public Player(Sprite sprite, Vector2f origin, int size, Enemy e, Enemy2 e2, Enemy3 e3) { //aici initializam playerul
        super(sprite, origin, size);
        bounds.setWidth(40);
        bounds.setHeight(16);
        bounds.setXOffset(4);
        bounds.setyOffset(0);

        bounds1.setWidth(40);
        bounds1.setHeight(16);
        bounds1.setXOffset(4);
        bounds1.setyOffset(16);

        bounds2.setWidth(40);
        bounds2.setHeight(16);
        bounds2.setXOffset(4);
        bounds2.setyOffset(32);

        butoi1 = new Butoi(new Sprite16("entity/Butoi.png"), new Vector2f(496, 320), 16);
        b1r = new Rect(496, 320, 16, 16, this);
        butoi2 = new Butoi(new Sprite16("entity/Butoi.png"), new Vector2f(1776, 320), 16);
        b2r = new Rect(1776, 320, 16, 16, this);
        butoi3 = new Butoi(new Sprite16("entity/Butoi.png"), new Vector2f(3152, 320), 16);
        b3r = new Rect(3152, 320, 16, 16, this);
        esteButoi1 = true;
        esteButoi2 = true;
        esteButoi3 = true;
        font = new Font("font/font.png", 10, 10);
        cheiColectate = 0;
        butoaieColectate = 0;
        entitatiOmorate = 0;

        nextLevel = false;

        bounds3.setWidth(40);
        bounds3.setHeight(16);
        bounds3.setXOffset(4);
        bounds3.setyOffset(46);


        incercare = new Coliziuni(origin, size, size);
        incercare.setWidth(40);
        incercare.setHeight(64);
        incercare.setXOffset(4);
        incercare.setyOffset(0);

        this.sc = new Rect((int) (21 * 16), 50, 16, 300, this);
        this.scara = new Rect(1920, 176, 16, 200, this);

        cheie2 = new Cheie(new Sprite16("entity/Cheie.png"), new Vector2f(1648, 336), 16);
        cheieRect2 = new Rect(1648, 336, 16, 16, this);
        cheie3 = new Cheie(new Sprite16("entity/Cheie.png"), new Vector2f(3440, 304), 16);
        cheieRect3 = new Rect(3440, 304, 16, 16, this);
        cheie4 = new Cheie(new Sprite16("entity/Cheie.png"), new Vector2f(3376, 112), 16);
        cheieRect4 = new Rect(3376, 112, 16, 16, this);

        cheie1 = new Cheie(new Sprite16("entity/Cheie.png"), new Vector2f(96, 160), 16);
        cheieRect1 = new Rect(96, 160, 16, 16, this);

        cheie2 = new Cheie(new Sprite16("entity/Cheie.png"), new Vector2f(1648, 336), 16);


        pozitie = 0;
        entitateAlbastra = false;
        entitateGalbena = false;
        entitateRosie = false;

        entitateVerde = false;


        this.e = e;
        this.e2 = e2;
        this.e3 = e3;
        ac = new Ac(new Sprite16("entity/PentruAc.png"), new Vector2f(1291, 100), 32, e, e2, this);
        ac2 = new Ac2(new Sprite16("entity/PentruAc.png"), new Vector2f(2480, 150), 32, e2, this);
        ac3 = new Ac3(new Sprite16("entity/PentruAc.png"), new Vector2f(2800, 60), 32, e3, this);
        cRosie = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(1300, 100), 32);

        cGalbena = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(1332, 100), 32);
        cRoz = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(1364, 100), 32);
        cAlbastru = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(1396, 100), 32);
        cMov = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(1428, 100), 32);
        cVerde = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(1460, 100), 32);

        cRosie2 = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(2480, 150), 32);

        cGalbena2 = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(2512, 150), 32);
        cRoz2 = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(2544, 150), 32);
        cAlbastru2 = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(2576, 150), 32);
        cMov2 = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(2608, 150), 32);
        cVerde2 = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(2640, 150), 32);

        cRosie3 = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(2800, 60), 32);

        cGalbena3 = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(2832, 60), 32);
        cRoz3 = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(2864, 60), 32);
        cAlbastru3 = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(2896, 60), 32);
        cMov3 = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(2928, 60), 32);
        cVerde3 = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(2960, 60), 32);
        isAlive = true;
        life = 300;
        saritura = true;
        once1 = true;
        once2 = true;
        once3 = true;
        once4 = true;
        bonce1 = true;
        bonce2 = true;
        bonce3 = true;


        moveSpeed = 0.3;
        acc = 0.3;
        deacc = 0.3;

        stopSpeed = 0.4;
        fallSpeed = 0.15;
        maxFallSpeed = 4.0;
        jumpStart = -4.8;
        stopJumpSpeed = 0.3;
        gravity = 0.5;
        friction = 0.5;
        onArena = false;
        onArena2 = false;
        onArena3 = false;

        esteCheia1 = true;
        esteCheia2 = true;
        esteCheia3 = true;
        esteCheia4 = true;


        arena1 = new Rect(64 * 16, 21 * 16, 35 * 16, 16, this);
        arena2 = new Rect(147 * 16, 21 * 16, 33 * 16, 16, this);
        arena3 = new Rect(173 * 16, 10 * 16, 26 * 16, 16, this);


        CameraDreapta=new Rect(153*16,21*16,70*16,80,this);

    }

    public void move(Enemy e) throws InterruptedException {

        if (e != null) {
            System.out.println("acc: " + acc + " maxSpeed: " + maxSpeed + " deaccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc: " + deacc);
            if (isAlive && nextLevel == false) {
                if (jump && (bounds3.collisionTile(0, dy))) {
                    dy = -80;
                    dy *= friction;

                } else {
                    dy += gravity;
                    if (dy < 0) {
                        dy = 0;
                    }

                }

                if (down) {

                    dy += acc;
                    if (dy > maxSpeed) {
                        dy = maxSpeed;
                    }
                } else {
                    if (dy > 0) {
                        dy -= deacc;
                        if (dy < 0)
                            dy = 0;
                    }


                }
                if (up) {
                    dy -= acc * 6;

                    if (dy < -maxSpeed) {
                        dy = -maxSpeed;
                    }
                } else {
                    if (dy < 0) {
                        dy += deacc;
                        if (dy > 0) {
                            dy = 0;
                        }
                    }
                }

                if (left && !bounds.collisionTile(dx, 0) && !bounds1.collisionTile(dx, 0) && !bounds2.collisionTile(dx, 0) && !bounds3.collisionTile(dx, 0) && !e.sense.colCircleBox(getBounds()) && !e2.sense.colCircleBox(getBounds()) && !right && !e3.sense.colCircleBox(getBounds())) {
                    dx -= acc;

                    if (dx < -maxSpeed) {
                        dx = (float) -maxSpeed;

                    }
                } else {
                    if (dx < 0) {
                        dx += deacc;

                        if (dx > 0) {
                            dx = 0;
                            dy = 0;

                        }
                    }
                }
                if (right && !bounds.collisionTile(dx, 0) && !bounds1.collisionTile(dx, 0) && !bounds2.collisionTile(dx, 0) && !bounds3.collisionTile(dx, 0) && !e.sense.colCircleBox(getBounds()) && !e2.sense.colCircleBox(getBounds()) && !left && !e3.sense.colCircleBox(getBounds())) {
                    dx += acc;


                    if (dx > maxSpeed) {
                        dx = (float) maxSpeed;


                    }
                } else {
                    if (dx > 0) {
                        dx -= deacc;


                        if (dx < 0) {
                            dy = 0;
                            dx = 0;
                        }
                    }

                }
                if (attack && ac.isGalben(ac.pozx) == false && e.isAlive) {


                    ac.atacare();
                    ac.pos.x = 1291;

                }
                if (attack && e2.isAlive && ac2.isRosu2(ac2.pozx) == false && !e.isAlive && pos.y != 97) {

                    ac2.atacare();
                    ac2.pos.x = 2480;
                }
                if (attack && e3.isAlive && onArena3 && ac3.isVerde3(ac3.pozx) == false) {

                    ac3.atacare();
                    ac3.pos.x = 2800;
                }

            }
        }


    }


    public boolean camDreapta()
    {
        if(doOverlap(incercare,CameraDreapta))
        {
            return true;
        }
        else return false;

    }

    public void update2(Enemy e) throws IOException, InterruptedException {
        if (isAlive && nextLevel == false) {
            super.update();
            animate2();
            if (doOverlap(incercare,sc) && !bounds3.collisionTile(0, dy) && up && dy<0) {
                System.out.println("YES=================================================================================+" + maxSpeed + "]]]]]]]]]]]]]]]]]]]");
                pos.y += dy;
            }
            if (doOverlap(incercare, scara) && !bounds3.collisionTile(0, dy) &&up &&dy<0) {

                pos.y += dy;
            }
            if (cheieRect1.doOverlap()) {
                esteCheia1 = false;
                if (once1 == true)
                    cheiColectate++;
                once1 = false;


            }
            if (cheieRect2.doOverlap()) {
                esteCheia2 = false;
                if (once2 == true)
                    cheiColectate++;
                once2 = false;

            }
            if (cheieRect3.doOverlap()) {
                esteCheia3 = false;
                if (once3 == true)
                    cheiColectate++;
                once3 = false;

            }
            if (cheieRect4.doOverlap()) {
                esteCheia4 = false;
                if (once4 == true)
                    cheiColectate++;
                once4 = false;

            }
            if (b1r.doOverlap()) {
                esteButoi1 = false;
                if (bonce1 == true)
                    butoaieColectate++;
                bonce1 = false;
            }
            if (b2r.doOverlap()) {
                esteButoi2 = false;
                if (bonce2 == true)
                    butoaieColectate++;
                bonce2 = false;
            }
            if (b3r.doOverlap()) {

                esteButoi3 = false;
                if (bonce3 == true)
                    butoaieColectate++;
                bonce3 = false;
            }

            System.out.println("YES=================================================================================+" + maxSpeed + "]]]]]]]]]]]]]]]]]]]" + acc + "--" + deacc);
            move(e);
            System.out.println("PENTRU POZITIA PERSONAJULUI X ADICA CE TREBUIE LALALLLA" + pos.y + "---" + pos.x);

            if (PlayState.map.x < 0)
                PlayState.map.x = 0;
            if (!bounds.collisionTile(dx, 0) && !bounds1.collisionTile(dx, 0) && !bounds2.collisionTile(dx, 0) && !bounds3.collisionTile(dx, 0) ) {


                pos.x += dx;

            }

            if (!bounds.collisionTile(0, dy) && !bounds1.collisionTile(0, dy) && !bounds2.collisionTile(0, dy) && !bounds3.collisionTile(0, dy) && !up) {

                pos.y += dy;
            }

            if (doOverlap(incercare, arena1)) {
                onArena = true;
            } else onArena = false;
            if (doOverlap(incercare, arena2)) {
                onArena2 = true;
            } else onArena2 = false;
            if (doOverlap(incercare, arena3)) {
                onArena3 = true;
            } else onArena3 = false;

            if(cheiColectate==4 && butoaieColectate==3)
                nextLevel=true;




        }

    }

    boolean doOverlap(Coliziuni incercare, Rect sc) {

        int r1x = (int) sc.x;
        int r1y = (int) sc.y;
        int r1width = (int) sc.z;
        int r1height = sc.t;

        int r2x = (int) (pos.x + incercare.getXOffset());
        int r2y = (int) (pos.y + incercare.getYOffset());
        int r2width = incercare.getWidth();
        int r2height = incercare.getHeight();
        float xmin = Math.max(r1x, r2x);
        float xmax1 = r1x + r1width;
        float xmax2 = r2x + r2width;
        float xmax = Math.min(xmax1, xmax2);
        if (xmax > xmin) {
            float ymin = Math.max(r1y, r2y);
            float ymax1 = r1y + r1height;
            float ymax2 = r2y + r2height;
            float ymax = Math.min(ymax1, ymax2);
            if (ymax > ymin) {

                return true;
            }
        }
        return false;
    }


    public double getDx() {
        return dx;
    }


    public void render(Graphics2D g) throws InterruptedException, IOException {

        if (isAlive == true && nextLevel == false) {
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            sc.render(g);
            scara.render(g);
            if (esteCheia1 == true)
                cheie1.render(g);
            if (esteCheia2 == true)
                cheie2.render(g);

            if (esteCheia3 == true)
                cheie3.render(g);

            if (esteCheia4 == true)
                cheie4.render(g);

            if (esteButoi1 == true)
                butoi1.render(g);
            if (esteButoi2 == true)
                butoi2.render(g);
            if (esteButoi3 == true)
                butoi3.render(g);


            Sprite.drawArray(g, font, " Chei colectate:" + cheiColectate, new Vector2f(pos.x, pos.y - 50), 16, 16, 10, 0);
            Sprite.drawArray(g, font, " Butoaie colectate:" + butoaieColectate, new Vector2f(pos.x, pos.y - 70), 16, 16, 10, 0);
            g.setColor(Color.red);
            g.drawRect((int) (pos.x + incercare.getXOffset()), (int) (pos.y + incercare.getYOffset()), incercare.getWidth(), incercare.getHeight());
            //g.drawRect(CameraDreapta.x,CameraDreapta.y,CameraDreapta.z,CameraDreapta.t);

            if (onArena == true) {
                cRosie.render(g);
                cGalbena.render(g);
                cRoz.render(g);
                cAlbastru.render(g);
                cMov.render(g);
                cVerde.render(g);
                ac.render(g);
            }
            if (onArena2 == true) {
                cRosie2.render(g);
                cGalbena2.render(g);
                cRoz2.render(g);
                cAlbastru2.render(g);
                cMov2.render(g);
                cVerde2.render(g);
                ac2.render(g);
            }

            if (onArena3 == true) {
                cRosie3.render(g);
                cGalbena3.render(g);
                cRoz3.render(g);
                cAlbastru3.render(g);
                cMov3.render(g);
                cVerde3.render(g);
                ac3.render(g);
                onArena3=true;
            }

        }

    }



    @Override
    public Vector2f getPos() {
        return new Vector2f(this.dx, this.dy);
    }
    public int getPosX2() {
        return (int)pos.x;
    }




    public void input(MouseHandler mouse, KeyHandler key){
        if(isAlive) {
            if (mouse.getButton() == 1) {

            }
            if (key.up.down) {
                up = true;
            } else {
                up = false;
            }
            if (key.jump.down) {
                jump = true;

            } else {

                jump = false;

            }
            if (key.down.down) {
                down = true;
            } else {
                down = false;
            }
            if (key.left.down) {
                left = true;

            } else {
                left = false;
            }
            if (key.right.down) {
                right = true;

            } else {
                right = false;
            }
            if (key.attack.down) {
                attack = true;
            } else {
                attack = false;

            }

        }

    }
    public void animate2(){
        if(attack){
            /*if(e.isAlive && nextLevel==false)
            {
                if(currentAnimation!=4||ani.getDelay()==-1)
                    setAnimation(4,sprite.getSpriteArray(4),5);
            }
            if(!e.isAlive && e2.isAlive &&pos.x>2335 && pos.y==273) {
                if (currentAnimation!=5||ani.getDelay() == -1)
                    setAnimation(5, sprite.getSpriteArray(5), 5);
            }*/
            if(onArena)
            {
                if(currentAnimation!=4||ani.getDelay()==-1)
                    setAnimation(4,sprite.getSpriteArray(4),5);
            }
            if(onArena2)
            {
                if(currentAnimation!=5||ani.getDelay()==-1)
                    setAnimation(5,sprite.getSpriteArray(5),5);
            }
            if(onArena3)
            {
                if(currentAnimation!=7||ani.getDelay()==-1)
                    setAnimation(7,sprite.getSpriteArray(7),5);
            }

        }

    }
}
