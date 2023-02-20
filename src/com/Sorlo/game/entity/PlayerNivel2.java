package com.Sorlo.game.entity;

import com.Sorlo.game.entity.Ace.*;
import com.Sorlo.game.entity.Culori.*;
import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.graphics.Font;
import com.Sorlo.game.graphics.Sprites.Sprite;
import com.Sorlo.game.graphics.Sprites.Sprite16;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.states.GameStateManager;
import com.Sorlo.game.util.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;


public class PlayerNivel2 extends Entity {

    public int cheiColectate;
    public int butoaieColectate;

    private Butoi butoi1;
    private Butoi butoi2;
    private Butoi butoi3;
    private Butoi butoi4;
    Cheie cheie1;
    Cheie cheie2;
    Cheie cheie3;
    Cheie cheie4;
    Cheie cheie5;
    Cheie cheie6;
    Cheie cheie7;
    public boolean once1;
    public boolean once2;
    public boolean once3;
    public boolean once4;
    public boolean once5;
    public boolean once6;
    public boolean once7;
    public boolean bonce1;
    public boolean bonce2;
    public boolean bonce3;
    public boolean bonce4;
    Rect cheieRect1;
    Rect cheieRect2;
    Rect cheieRect3;
    Rect cheieRect4;
    Rect cheieRect5;
    Rect cheieRect6;
    Rect cheieRect7;
    boolean esteCheia1;
    boolean esteCheia2;
    boolean esteCheia3;
    boolean esteCheia4;
    boolean esteCheia5;
    boolean esteCheia6;
    boolean esteCheia7;
    boolean esteButoi1;
    boolean esteButoi2;
    boolean esteButoi3;
    boolean esteButoi4;

    public Font font;

    double gravity = 0.5;
    double friction = 0.5;


    protected Ac12 ac;
    protected Ac13 ac2;
    protected Ac23 ac3;
    protected Ac24 ac4;
    protected Ac25 ac5;
    protected Ac26 ac6;
    boolean pressedOnce;

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

    protected CuloareRosie cRosie4;
    protected CuloareGalbena cGalbena4;
    protected CuloareRoz cRoz4;
    protected CuloareAlbastra cAlbastru4;
    protected CuloareMov cMov4;
    protected CuloareVerde cVerde4;

    public Coliziuni incercare;


    public boolean isAlive;

    public boolean nextLevel;
    public Rect scara;
    public Rect funie1;
    public Rect funie2;
    public Rect arena1;
    public ENEM e1;
    public ENEM e2;
    public ENEM e3;
    public ENEM e4;
    public ENEM e5;
    public ENEM e6;

    boolean aren1;
    public Rect arena2;
    boolean aren2;
    public Rect arena3;
    boolean aren3;
    public Rect arena4;
    boolean aren4;
    public Rect arena5;
    boolean aren5;
    public Rect arena6;
    boolean aren6;
    public Rect CameraDreapta;

    Rect b1r;
    Rect b2r;
    Rect b3r;
    Rect b4r;




    public PlayerNivel2(Sprite sprite, Vector2f origin, int size, ENEM e1, ENEM e2, ENEM e3, ENEM e4, ENEM e5, ENEM e6) throws SQLException { //aici initializam playerul
        super(sprite, origin, size);
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
        this.e5 = e5;
        this.e6 = e6;
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


        bounds3.setWidth(40);
        bounds3.setHeight(16);
        bounds3.setXOffset(4);
        bounds3.setyOffset(46);


        incercare = new Coliziuni(origin, size, size);
        incercare.setWidth(48);
        incercare.setHeight(64);
        incercare.setXOffset(4);
        incercare.setyOffset(0);
        font = new Font ("font/font.png", 10, 10);
        isAlive = true;
        nextLevel = false;
        maxSpeed = 0.9;
        scara = new Rect(464, 10 * 16, 16, 9 * 16, this);
        funie2=new Rect(247*16,5*16,16,14*16,this);
        funie1=new Rect(160*16,2*16,16,17*16,this);
        arena1 = new Rect(36 * 16, 21 * 16, 560 - 16, 16, this);
        arena2 = new Rect(47 * 16, 10 * 16, 30 * 16, 16, this);
        arena3 = new Rect(179 * 16, 21 * 16, 37 * 16, 16, this);
        arena4 = new Rect(180 * 16, 10 * 16, 32 * 16, 16, this);
        arena5 = new Rect(264 * 16, 21 * 16, 31 * 16, 16, this);
        arena6 = new Rect(350 * 16, 10 * 16, 39 * 16, 16, this);
        aren1 = false;
        aren2 = false;
        aren3 = false;
        aren4 = false;
        aren5 = false;
        aren6 = false;

        butoaieColectate =Table.SelectLastB(GameStateManager.s);
        cheiColectate = Table.SelectLastC(GameStateManager.s);

        butoi1=new Butoi(new Sprite16("entity/Butoi.png"), new Vector2f(21*16,20*16),16);
        b1r=new Rect(21*16,20*16,16,16,this);
        butoi2=new Butoi(new Sprite16("entity/Butoi.png"), new Vector2f(90*16,20*16),16);
        b2r=new Rect(90*16,20*16,16,16,this);
        butoi3=new Butoi(new Sprite16("entity/Butoi.png"), new Vector2f(102*16,9*16),16);
        b3r=new Rect(102*16,9*16,16,16,this);
        butoi4=new Butoi(new Sprite16("entity/Butoi.png"), new Vector2f(430*16,20*16),16);
        b4r=new Rect(430*16,20*16,16,16,this);
        esteButoi1=true;
        esteButoi2=true;
        esteButoi3=true;
        esteButoi4=true;

        cheie2=new Cheie(new Sprite16("entity/cheie2.png"), new Vector2f(159*16,32),16);
        cheieRect2=new Rect(159*16,32,16,16);
        cheie3=new Cheie(new Sprite16("entity/cheie2.png"), new Vector2f(172*16,160),16);
        cheieRect3=new Rect(172*16,160,16,16);
        cheie4=new Cheie(new Sprite16("entity/cheie2.png"), new Vector2f(444*16,160),16);
        cheieRect4=new Rect(444*16,160,16,16);

        cheie1=new Cheie(new Sprite16("entity/cheie2.png"), new Vector2f(88*16,160),16);
        cheieRect1=new Rect(88*16,160,16,16);


        cheie5=new Cheie(new Sprite16("entity/cheie2.png"), new Vector2f(444*16,21*16),16);
        cheieRect5=new Rect(444*16,21*16,16,16);
        cheie6=new Cheie(new Sprite16("entity/cheie2.png"), new Vector2f(225*16,21*16),16);
        cheieRect6=new Rect(225*16,21*16,16,16);
        cheie7=new Cheie(new Sprite16("entity/cheie2.png"), new Vector2f(82*16,21*16),16);
        cheieRect7=new Rect(82*16,21*16,16,16);

        once1=true;
        once2=true;
        once3=true;
        once4=true;
        once5=true;
        once6=true;
        once7=true;
        bonce1=true;
        bonce2=true;
        bonce3=true;
        bonce4=true;

        esteCheia1=true;
        esteCheia2=true;
        esteCheia3=true;
        esteCheia4=true;
        esteCheia5=true;
        esteCheia6=true;
        esteCheia7=true;

        CameraDreapta=new Rect(378*16,21*16,70*16,80,this);
        Table.AddEntry(GameStateManager.s,Table.SelectLast(GameStateManager.s),2,0,0,0);
    }

    public void move() throws InterruptedException {

        System.out.println("acc: " + acc + " maxSpeed: " + maxSpeed + " deacc: " + deacc + " ============================================================");

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

        if (left && !bounds.collisionTile(dx, 0) && !bounds1.collisionTile(dx, 0) && !bounds2.collisionTile(dx, 0) && !bounds3.collisionTile(dx, 0) && !right&& !e1.sense.colCircleBox(getBounds()) && !e2.sense.colCircleBox(getBounds())&& !e3.sense.colCircleBox(getBounds()) && !e4.sense.colCircleBox(getBounds())&& !e5.sense.colCircleBox(getBounds()) && !e6.sense.colCircleBox(getBounds())) {
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
        if (right && !bounds.collisionTile(dx, 0) && !bounds1.collisionTile(dx, 0) && !bounds2.collisionTile(dx, 0) && !bounds3.collisionTile(dx, 0) && !left && !e1.sense.colCircleBox(getBounds()) && !e2.sense.colCircleBox(getBounds())&& !e3.sense.colCircleBox(getBounds()) && !e4.sense.colCircleBox(getBounds())&& !e5.sense.colCircleBox(getBounds()) && !e6.sense.colCircleBox(getBounds())) {
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
        if (attack && ac != null && ac2 == null && ac3==null && ac4==null) {
            {
                if (ac.isRosuu(ac.pozx) == false && e1.isAlive && doOverlap(incercare, arena1)) {
                    ac.atacare();
                    ac.pos.x = 600;
                }
            }
        }
        if (attack && ac2 != null && ac == null && ac3==null && ac4==null) {
            if (!ac2.isVerdeu(ac2.pozx) && e2.isAlive && doOverlap(incercare, arena2)) {
                ac2.atacare();
                ac2.pos.x = 59 * 16;
            }

        }
        if(attack && ac3!=null && ac==null && ac2==null && ac4==null)
            if (!ac3.isAlbastruu(ac3.pozx) && e3.isAlive && doOverlap(incercare, arena3)) {
                ac3.atacare();
               ac3.pos.x = 195 * 16;
            }
        if(attack && ac3==null && ac==null && ac2==null && ac4!=null)
            if (!ac4.isGalbenu(ac4.pozx) && e4.isAlive && doOverlap(incercare, arena4)) {
                ac4.atacare();
                ac4.pos.x = 192 * 16;
            }
        if(attack && ac3==null && ac==null && ac2==null && ac4==null && ac5!=null)
            if (!ac5.isRosuu(ac5.pozx) && e5.isAlive && doOverlap(incercare, arena5)) {
                ac5.atacare();
                ac5.pos.x = 273 * 16;
            }
        if(attack && ac3==null && ac==null && ac2==null && ac4==null && ac5==null && ac6!=null)
            if (!ac5.isRosuu(ac6.pozx) && e6.isAlive && doOverlap(incercare, arena6)) {
                ac6.atacare();
                ac6.pos.x = 367 * 16;
            }
    }





    public boolean colDreapta()
    {
        if(doOverlap(incercare,CameraDreapta))
            return true;
        else return false;
    }



    boolean doOverlap(Coliziuni incercare , Rect sc) {

        int r1x= (int) sc.x;
        int r1y=(int)sc.y;
        int r1width=(int)sc.z;
        int r1height=sc.t;

        int r2x= (int) (pos.x+incercare.getXOffset());
        int r2y=(int) (pos.y+incercare.getYOffset());
        int r2width=incercare.getWidth();
        int r2height=incercare.getHeight();
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



    public void update2() throws IOException, InterruptedException, SQLException {

        if(isAlive) {
            super.update();
            animate2();
            move();
            if (!bounds.collisionTile(dx, 0) && !bounds1.collisionTile(dx, 0) && !bounds2.collisionTile(dx, 0) && !bounds3.collisionTile(dx, 0)) {


                pos.x += dx;
            }


            if (!bounds.collisionTile(0, dy) && !bounds1.collisionTile(0, dy) && !bounds2.collisionTile(0, dy) && !bounds3.collisionTile(0, dy) && !up) {

                pos.y += dy;
            }

            if (doOverlap(incercare, scara) && up && dy<0) {
                pos.y += dy;
            }
            if(doOverlap(incercare,funie1)&& up && !bounds.collisionTile(0,dy) &&dy<0)
            {
                pos.y+=dy;
            }
            if(doOverlap(incercare,funie2)&& up &&dy<0)
            {
                pos.y+=dy;
            }
            if (doOverlap(incercare, arena1) && aren1 == false) {
                ac = new Ac12(new Sprite16("entity/PentruAc.png"), new Vector2f(600, 150), 32, e1, this);
                cRosie = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(600, 150), 32);

                cGalbena = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(600 + 32, 150), 32);
                cRoz = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(600 + 32 + 32, 150), 32);
                cAlbastru = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(600 + 32 + 32 + 32, 150), 32);
                cMov = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(600 + 32 + 32 + 32 + 32, 150), 32);
                cVerde = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(600 + 32 + 32 + 32 + 32 + 32, 150), 32);
                aren1 = true;
                ac2=null;
                ac3=null;
                ac4=null;
                ac5=null;
                ac6=null;

            }
            if (doOverlap(incercare, arena2) && aren2 == false) {
                ac2 = new Ac13(new Sprite16("entity/PentruAc.png"), new Vector2f(59*16, 4*16), 32, e2, this);
                cRosie2 = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(59*16, 4*16), 32);

                cGalbena2 = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(59*16+32, 4*16), 32);
                cRoz2 = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(59*16+32*2, 4*16), 32);
                cAlbastru2 = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(59*16+32*3, 4*16), 32);
                cMov2 = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(59*16+32*4, 4*16), 32);
                cVerde2 = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(59*16+32*5, 4*16), 32);
                aren2 = true;
                ac=null;
                ac3=null;
                ac4=null;
                ac5=null;
                ac6=null;

            }
            if (doOverlap(incercare, arena3) && aren3 == false) {
                ac3 = new Ac23(new Sprite16("entity/PentruAc.png"), new Vector2f(195*16, 17*16), 32, e3, this);
                cRosie3 = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(195*16, 17*16), 32);

                cGalbena3 = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(195*16+32, 17*16), 32);
                cRoz3 = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(195*16+32*2, 17*16), 32);
                cAlbastru3 = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(195*16+32*3, 17*16), 32);
                cMov3 = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(195*16+32*4, 17*16), 32);
                cVerde3 = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(195*16+32*5, 17*16), 32);
                aren3 = true;
                ac=null;
                ac2=null;
                ac4=null;
                ac5=null;
                ac6=null;

            }
            if (doOverlap(incercare, arena4) && aren4 == false) {
                ac4 = new Ac24(new Sprite16("entity/PentruAc.png"), new Vector2f(192*16, 4*16), 32, e4, this);
                cRosie4 = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(192*16, 4*16), 32);

                cGalbena4 = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(192*16+32, 4*16), 32);
                cRoz4 = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(192*16+32*2, 4*16), 32);
                cAlbastru4 = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(192*16+32*3, 4*16), 32);
                cMov4 = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(192*16+32*4, 4*16), 32);
                cVerde4 = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(192*16+32*5, 4*16), 32);
                aren4 = true;
                ac=null;
                ac2=null;
                ac3=null;
                ac5=null;
                ac6=null;

            }
            if (doOverlap(incercare, arena5) && aren5 == false) {
                ac5 = new Ac25(new Sprite16("entity/PentruAc.png"), new Vector2f(273*16, 16*16), 32, e5, this);
                cRosie4 = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(273*16, 16*16), 32);

                cGalbena4 = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(273*16+32, 16*16), 32);
                cRoz4 = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(273*16+32*2, 16*16), 32);
                cAlbastru4 = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(273*16+32*3, 16*16), 32);
                cMov4 = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(273*16+32*4, 16*16), 32);
                cVerde4 = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(273*16+32*5, 16*16), 32);
                aren5 = true;
                ac=null;
                ac2=null;
                ac3=null;
                ac4=null;
                ac6=null;

            }
            if (doOverlap(incercare, arena6) && aren6 == false) {
                ac6 = new Ac26(new Sprite16("entity/PentruAc.png"), new Vector2f(367*16, 4*16), 32, e6, this);
                cRosie4 = new CuloareRosie(new Sprite32("entity/Rosu.png"), new Vector2f(367*16, 4*16), 32);

                cGalbena4 = new CuloareGalbena(new Sprite32("entity/Galben.png"), new Vector2f(367*16+32, 4*16), 32);
                cRoz4 = new CuloareRoz(new Sprite32("entity/roz.png"), new Vector2f(367*16+32*2, 4*16), 32);
                cAlbastru4 = new CuloareAlbastra(new Sprite32("entity/Albastru.png"), new Vector2f(367*16+32*3, 4*16), 32);
                cMov4 = new CuloareMov(new Sprite32("entity/Mov.png"), new Vector2f(367*16+32*4, 4*16), 32);
                cVerde4 = new CuloareVerde(new Sprite32("entity/Verde.png"), new Vector2f(367*16+32*5, 4*16), 32);
                aren6 = true;
                ac=null;
                ac2=null;
                ac3=null;
                ac4=null;
                ac5=null;

            }



        }
        if(doOverlap(incercare, cheieRect1))
        {

            esteCheia1=false;
            if(once1==true)
                cheiColectate++;
            once1=false;



        }
        if(doOverlap(incercare, cheieRect2))
        {
            esteCheia2=false;
            if(once2==true)
                cheiColectate++;
            once2=false;

        }
        if(doOverlap(incercare, cheieRect3))
        {

            esteCheia3=false;
            if(once3==true)
                cheiColectate++;
            once3=false;

        }
        if(doOverlap(incercare, cheieRect4))
        {

            esteCheia4=false;
            if(once4==true)
                cheiColectate++;
            once4=false;

        }
        if(doOverlap(incercare, cheieRect5))
        {

            esteCheia5=false;
            if(once5==true)
                cheiColectate++;
            once5=false;

        }
        if(doOverlap(incercare, cheieRect6))
        {

            esteCheia6=false;
            if(once6==true)
                cheiColectate++;
            once6=false;

        }
        if(doOverlap(incercare, cheieRect7))
        {

            esteCheia7=false;
            if(once7==true)
                cheiColectate++;
            once7=false;

        }
        if(doOverlap(incercare,b1r))
        {
            esteButoi1=false;
            if(bonce1==true)
                butoaieColectate++;
            bonce1=false;
        }
        if(doOverlap(incercare,b2r))
        {
            esteButoi2=false;
            if(bonce2==true)
                butoaieColectate++;
            bonce2=false;
        }
        if(doOverlap(incercare,b3r))
        {

            esteButoi3=false;
            if(bonce3==true)
                butoaieColectate++;
            bonce3=false;
        }
        if(doOverlap(incercare,b4r))
        {

            esteButoi4=false;
            if(bonce4==true)
                butoaieColectate++;
            bonce4=false;
        }




        //Table.AddEntry(GameStateManager.s,Table.SelectLast(GameStateManager.s),Table.SelectLastS(GameStateManager.s),0, butoaieColectate,cheiColectate);


    }


    public double getDx()
    {
        return dx;
    }




    public void render(Graphics2D g) throws InterruptedException, IOException {

        if(isAlive) {
            g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), bounds.getWidth(), bounds.getHeight());
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);

            System.out.println("DRAWN");

            g.setColor(Color.red);
            g.drawRect((int) (pos.x + incercare.getXOffset()), (int) (pos.y + incercare.getYOffset()), incercare.getWidth(), incercare.getHeight());
            g.drawRect((int) (pos.x + bounds2.getXOffset()), (int) (pos.y + bounds2.getYOffset()), bounds2.getWidth(), bounds2.getHeight());
            Sprite.drawArray(g, font,  " Chei colectate:"+cheiColectate, new Vector2f(pos.x, pos.y-50), 16, 16, 10, 0);
            Sprite.drawArray(g, font,  " Butoaie colectate:"+butoaieColectate, new Vector2f(pos.x, pos.y-70), 16, 16, 10, 0);
            g.drawRect(scara.x, scara.y, scara.z, scara.t);
            g.drawRect(funie1.x, funie1.y, funie1.z, funie1.t);
            g.drawRect(arena1.x, arena1.y, arena1.z, arena1.t);
            g.drawRect(arena2.x, arena2.y, arena2.z, arena2.t);
            g.drawRect(arena3.x, arena3.y, arena3.z, arena3.t);
            g.drawRect(arena4.x, arena4.y, arena4.z, arena4.t);
            g.drawRect(arena5.x, arena5.y, arena5.z, arena5.t);
            g.drawRect(arena6.x, arena6.y, arena6.z, arena6.t);

            if(esteButoi1==true)
                butoi1.render(g);
            if(esteButoi2==true)
                butoi2.render(g);
            if(esteButoi3==true)
                butoi3.render(g);
            if(esteButoi4==true)
                butoi4.render(g);
            if(esteCheia1==true)
                cheie1.render(g);
            if(esteCheia2==true)
                cheie2.render(g);

            if(esteCheia3==true)
                cheie3.render(g);

            if(esteCheia4==true)
                cheie4.render(g);

            if(esteCheia5==true)
                cheie5.render(g);

            if(esteCheia6==true)
                cheie6.render(g);

            if(esteCheia7==true)
                cheie7.render(g);





            if (doOverlap(incercare, arena1) && ac!=null) {
                cRosie.render(g);
                cGalbena.render(g);
                cRoz.render(g);
                cAlbastru.render(g);
                cMov.render(g);
                cVerde.render(g);
                ac.render(g);

            }


            if(doOverlap(incercare,arena2) && ac2!=null )
            {
                cRosie2.render(g);
                cGalbena2.render(g);
                cRoz2.render(g);
                cAlbastru2.render(g);
                cMov2.render(g);
                cVerde2.render(g);
                ac2.render(g);

            }
            if(doOverlap(incercare,arena3) && ac3!=null )
            {
                cRosie3.render(g);
                cGalbena3.render(g);
                cRoz3.render(g);
                cAlbastru3.render(g);
                cMov3.render(g);
                cVerde3.render(g);
                ac3.render(g);

            }
            if(doOverlap(incercare,arena4) && ac4!=null )
            {
                cRosie4.render(g);
                cGalbena4.render(g);
                cRoz4.render(g);
                cAlbastru4.render(g);
                cMov4.render(g);
                cVerde4.render(g);
                ac4.render2(g);

            }
            if(doOverlap(incercare,arena5) && ac5!=null )
            {
                cRosie4.render(g);
                cGalbena4.render(g);
                cRoz4.render(g);
                cAlbastru4.render(g);
                cMov4.render(g);
                cVerde4.render(g);
                ac5.render(g);

            }
            if(doOverlap(incercare,arena6) && ac6!=null )
            {
                cRosie4.render(g);
                cGalbena4.render(g);
                cRoz4.render(g);
                cAlbastru4.render(g);
                cMov4.render(g);
                cVerde4.render(g);
                ac6.render(g);

            }




        }

    }



    @Override
    public Vector2f getPos() {
        return new Vector2f(this.dx, this.dy);
    }
    public double getPosX(Vector2f t) {
        return t.x;
    }
    public double getPosY(Vector2f t) {
        return t.y;
    }
    public int getPosX2() {
        return (int)pos.x;
    }

    public void input(MouseHandler mouse, KeyHandler key){
        if(mouse.getButton()==1){
            System.out.println("Player: "+pos.x+","+pos.y);
        }
        if(key.up.down)
        {
            up=true;
        }
        else{
            up=false;
        }
        if(key.jump.down ){
            jump=true;

        }else {

            jump = false;

        }
        if(key.down.down){
            down=true;
        }else {
            down=false;
        }
        if(key.left.down){
            left=true;

        }else{
            left=false;
        }
        if(key.right.down) {
            right = true;

        }else{
            right=false;
        }
        if(key.attack.down && !pressedOnce) {
            attack = true;
        }
        else
        {
            attack=false;

        }

    }
    public void animate2(){
        if(attack){
            if(this.isAlive && nextLevel==false && doOverlap(incercare,arena1))
            {
                if(currentAnimation!=5||ani.getDelay()==-1)
                    setAnimation(5,sprite.getSpriteArray(5),5);
            }
            if(this.isAlive && nextLevel==false && doOverlap(incercare,arena2))
            {
                if(currentAnimation!=7||ani.getDelay()==-1)
                    setAnimation(7,sprite.getSpriteArray(7),5);
            }
            if(this.isAlive && nextLevel==false && doOverlap(incercare,arena3))
            {
                if(currentAnimation!=6||ani.getDelay()==-1)
                    setAnimation(6,sprite.getSpriteArray(6),5);
            }
            if(this.isAlive && nextLevel==false && doOverlap(incercare,arena4))
            {
                if(currentAnimation!=4||ani.getDelay()==-1)
                    setAnimation(4,sprite.getSpriteArray(4),5);
            }
            if(this.isAlive && nextLevel==false && doOverlap(incercare,arena5))
            {
                if(currentAnimation!=5||ani.getDelay()==-1)
                    setAnimation(5,sprite.getSpriteArray(5),5);
            }
            if(this.isAlive && nextLevel==false && doOverlap(incercare,arena6))
            {
                if(currentAnimation!=7||ani.getDelay()==-1)
                    setAnimation(7,sprite.getSpriteArray(7),5);
            }



        }

    }
}
