package com.Sorlo.game.states;

import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Enemies.Enemy;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Enemies.Enemy3;
import com.Sorlo.game.graphics.Font;
import com.Sorlo.game.graphics.Sprites.Sprite;
import com.Sorlo.game.graphics.Sprites.Sprite48;
import com.Sorlo.game.tiles.TileManager;
import com.Sorlo.game.util.*;


import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class PlayState extends GameState{

    public Font font ;
    public Player player;
    private final TileManager tm;
    private final Camera cam;
    private final Enemy enemy1;
    private final Enemy3 enemy3;
    public boolean isPlayState;
    public int currchoice=0;
    private final Enemy2 enemy2;

    boolean k;
    public int posx;


    public static Vector2f map;//pozitia mapei

    public PlayState(GameStateManager gam, Camera cam) throws SQLException {
        super(gam);
        map=new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        cam=new Camera(new Coliziuni(new Vector2f(0,0),1280,432));
        enemy1=new Enemy(new Sprite48("entity/SpriteFinalFantomite3.png"),new Vector2f((float) 1550.8376,288),48,Color.yellow);
        enemy2=new Enemy2(new Sprite48("entity/SpriteFinalFantomite1.png"),new Vector2f((float) 2840,288),48,Color.red);
        enemy3=new Enemy3(new Sprite48("entity/SpriteFinalFantomite2.png"),new Vector2f((float) 3160,112),48,Color.green);

        player = new Player (new Sprite ("entity/SORLO!.png"), new Vector2f(30, 289), 64, enemy1, enemy2, enemy3);


        this.cam=cam;
        tm=new TileManager("tile/UltimaVersiuneNivel1.xml",cam);
        cam.target(player);

        font = new Font ("font/font.png", 10, 10);
        isPlayState=true;
        k=false;

        Table.AddEntry(GameStateManager.s,Table.SelectLast(GameStateManager.s),1,0,0,0);

    }
    private void select() throws SQLException {
        if(currchoice == 1) {
            gsm.setStateMenu(GameStateManager.MENU);

        }
        if(currchoice==2)
            gsm.setNivel2(GameStateManager.LEVEL2);
    }



    public void update() throws IOException, InterruptedException, SQLException {
        Vector2f.setWorldVar(map.x,map.y);
        player.update2(enemy1);


        enemy1.update(player);
        enemy2.update(player);
        enemy3.update(player);
        cam.update();

        if(!player.isAlive && player.nextLevel==false && player.cheiColectate!=4 && player.butoaieColectate!=3)
        {
            currchoice=1;
            gsm.setStateMenu(GameStateManager.MENU);

        }
        if( player.cheiColectate==4 && player.butoaieColectate==3)
        {
            System.out.println(" ar fi trebuit sa mearga -----------------------------------------------");
            gsm.setNivel2(GameStateManager.LEVEL2);
            k=true;
            player.cheiColectate=0;
            player.butoaieColectate=0;
            player.isAlive=false;
        }

        //GameStateManager.table.AddEntry(GameStateManager.s,1, player.butoaieColectate, player.cheiColectate );



    }

    public void input(MouseHandler mouse, KeyHandler key){

        player.input(mouse,key);


    }

    public void render(Graphics2D g) throws InterruptedException, IOException {
        if(player.isAlive && player.nextLevel==false) {

            tm.render(g);
            player.render(g);
            cam.render(g, 0);
            enemy1.render(g);
            enemy2.render(g);
            enemy3.render(g);

        }
        if( k==true)
        {

            g.translate(-cam.sum, 0);
            k=false;

        }







    }

}
