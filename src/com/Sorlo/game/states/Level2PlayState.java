package com.Sorlo.game.states;

import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.graphics.Font;
import com.Sorlo.game.graphics.Sprites.Sprite;
import com.Sorlo.game.graphics.Sprites.Sprite48;
import com.Sorlo.game.graphics.Sprites.Sprite482;
import com.Sorlo.game.graphics.Sprites.Sprite80;
import com.Sorlo.game.tiles.TileManager2;
import com.Sorlo.game.util.*;


import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;


public class Level2PlayState extends GameState {

    public Font font;
    public PlayerNivel2 player;

    private TileManager2 tm;
    private Camera cam;
    public ENEM e;
    public ENEM e2;
    public ENEM e3;
    public ENEM e4;
    public ENEM e5;
    public ENEM e6;
    public FlgrDreapta fd;
    public FlgrStanga fs;
    public FlgJos fj1;
    public FlgJos fj2;
    public FlgJos fj3;
    public FlgJos fj4;
    public FlgJos fj5;
    public FlgJos fj6;
    public FlgJos fj7;
    public FlgJos fj8;
    public FlgJos fj9;
    private Timer timer;


    public static Vector2f map;//pozitia mapei

    public Level2PlayState(GameStateManager gam, Camera cam) throws SQLException {


        super(gam);



        map = new Vector2f();
        Vector2f.setWorldVar(0, 0);
        cam = new Camera(new Coliziuni(new Vector2f(0, 0), 1280, 432));



        e = new ENEM(new Sprite48("entity/frosii.png"), new Vector2f((float) 1069, 288), 48, Color.red);
        e2 = new ENEM(new Sprite48("entity/fverzi.png"), new Vector2f((float) 73 * 16, 7 * 16), 48, Color.green);
        e3 = new ENEM(new Sprite48("entity/falbastre.png"), new Vector2f(213 * 16, 18 * 16), 48, Color.blue);
        e4 = new ENEM(new Sprite48("entity/fGalbene2.png"), new Vector2f(180 * 16, 7 * 16), 48, Color.yellow);
        e5 = new ENEM(new Sprite48("entity/frosii.png"), new Vector2f((float) 293 * 16, 18 * 16), 48, Color.red);
        e6 = new ENEM(new Sprite48("entity/fverzi.png"), new Vector2f((float) 387 * 16, 7 * 16), 48, Color.green);
        player = new PlayerNivel2(new Sprite("entity/SORLO!.png"), new Vector2f(60, 288), 64, e, e2, e3, e4, e5, e6);
        fd = new FlgrDreapta(new Sprite80("entity/FlgrDreapta.png"), new Vector2f(154 * 16, 13 * 16), 80, player);
        fs = new FlgrStanga(new Sprite482("entity/LSTG.png"), new Vector2f(159 * 16, 6 * 16), 48, player);
        fj1 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(110 * 16, 14 * 16), 80,player);
        fj2 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(118 * 16, 14 * 16), 80,player);
        fj3 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(127 * 16, 14 * 16), 80,player);
        fj4 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(225 * 16, 2 * 16), 80,player);
        fj5 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(319 * 16, 3 * 16), 80,player);
        fj6 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(333 * 16, 4 * 16), 80,player);
        fj7 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(349 * 16, 14 * 16), 80,player);
        fj8 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(359 * 16, 14 * 16), 80,player);
        fj9 = new FlgJos(new Sprite80("entity/flgrJoss.png"), new Vector2f(372 * 16, 14 * 16), 80,player);


        timer = new Timer();



        font = new Font("font/font.png", 10, 10);
        cam.target(player);
        this.cam = cam;
        tm = new TileManager2("tile/Level2A.xml", cam);

        Table.AddEntry(GameStateManager.s,Table.SelectLast(GameStateManager.s),2,0,0,0);

    }


    public void update() throws IOException, InterruptedException, SQLException {
        Vector2f.setWorldVar(map.x, map.y);

        cam.update2();
        e.update(player);
        e2.update(player);
        e3.update(player);
        e4.update(player);
        e5.update(player);
        e6.update(player);
        player.update2();
        if (!player.isAlive && player.nextLevel == false && player.cheiColectate != 7 && player.butoaieColectate != 4) {
            gsm.setNivel2(GameStateManager.LEVEL2);

        }
    }

    ;

    public void input(MouseHandler mouse, KeyHandler key) {

        player.input(mouse, key);

    }

    ;

    public void render(Graphics2D g) throws InterruptedException, IOException {


        if (player.isAlive && player.nextLevel == false) {

            tm.render(g);

            try {
                fd.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fs.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj1.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj2.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj3.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj4.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj5.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj6.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj7.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj8.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            try {
                fj9.render(g);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }


        //Sprite.drawArray(g, font, GamePanel.oldFrameCount + " CHEI", new Vector2f(GamePanel.width - 192, 10), 32, 32, 24, 0);
        player.render(g);
        cam.render2(g, 0);
        e.render(g);


        e2.render(g);
        e3.render(g);
        e4.render(g);
        e5.render(g);
        e6.render(g);


        //cheie1.render(g);

        //scara.render(g);
    }
}





