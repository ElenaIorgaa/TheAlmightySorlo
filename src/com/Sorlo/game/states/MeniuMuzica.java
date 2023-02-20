package com.Sorlo.game.states;

import com.Sorlo.game.graphics.Font;
import com.Sorlo.game.graphics.Sprites.Sprite;
import com.Sorlo.game.tiles.TileManagerMeniu;
import com.Sorlo.game.tiles.TileManagerMeniuMuzica;
import com.Sorlo.game.util.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MeniuMuzica extends GameState {
    public static Statement s;
    private TileManagerMeniuMuzica tmm;
    public static Vector2f map;
    private int currentchoice=0;
    public Font font;
    boolean flag;
    String p;
    boolean changed;


    Vector<Audio> audios;

    private Camera cam;
    public MeniuMuzica(GameStateManager gsm) {
        super(gsm);
        tmm=new TileManagerMeniuMuzica("tile/MeniuMuzica.xml");
        map=new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        this.gsm=gsm;
       audios=GameStateManager.getMusic();
        font = new Font("font/font.png", 10, 10);
        p="HarryPotter";
        flag=true;
        changed=false;




    }

    private void select() throws SQLException {
        if(currentchoice == 1) {
            gsm.setState(GameStateManager.PLAY);
        }
        if(currentchoice == 0) {

        }
        if(currentchoice == 2) {
            System.exit(0);
        }
    }
    public void setCurrentchoice(int c)
    {
        currentchoice=c;
    }

    @Override
    public void update() throws SQLException {

        Vector2f.setWorldVar(map.x,map.y);
        if(changed==true) {

                Table.AddEntry(GameStateManager.s, p,0,0,0,0);
            changed=false;
        }
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) throws SQLException {
        if(mouse.getButton()==1){
            System.out.println(mouse.getX()+"-------------------------"+mouse.getY());
            if(mouse.getX()>=228-100 && mouse.getX()<=387-100 && mouse.getY()<=105 && mouse.getY()>=76) {

                audios.get(0).stop();
                audios.clear();
                audios.add(new Audio("/Songs/H.mp3"));
                audios.get(0).play();
                p="/Songs/H.mp3";
                changed=true;
            }
            if(mouse.getX()>=127 && mouse.getX()<=509 && mouse.getY()<=150 && mouse.getY()>=127) {

                audios.get(0).stop();
                audios.clear();
                audios.add(new Audio("/Songs/POC.mp3"));
                audios.get(0).play();
                p="/Songs/POC.mp3";
                changed=true;
            }
            if(mouse.getX()>=127 && mouse.getX()<=373 && mouse.getY()<=205 && mouse.getY()>=184) {

                audios.get(0).stop();
                audios.clear();
                audios.add(new Audio("/Songs/HP.mp3"));
                audios.get(0).play();
                p="/Songs/HP.mp3";
                changed=true;
            }
            if(mouse.getX()>=1007 && mouse.getX()<=1067 && mouse.getY()<=108 && mouse.getY()>=58) {

                gsm.setStateMenu(GameStateManager.MENU);
                flag=false;
            }
        }



    }

    @Override
    public void render(Graphics2D g) {
        if (flag == true) {
            tmm.render(g);
            Sprite.drawArray(g, font, " Harry Potter", new Vector2f(100, 200 - 50), 32, 32, 20, 0);
            Sprite.drawArray(g, font, " Piratii din Caraibe", new Vector2f(100, 150 - 50), 32, 32, 20, 0);
            Sprite.drawArray(g, font, " Hobbitul", new Vector2f(100, 100 - 50), 32, 32, 20, 0);

        }
    }
}
