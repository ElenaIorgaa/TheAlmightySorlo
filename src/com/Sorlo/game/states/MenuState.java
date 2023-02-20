package com.Sorlo.game.states;

import com.Sorlo.game.tiles.TileManagerMeniu;
import com.Sorlo.game.util.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;

public class MenuState extends GameState {
    private TileManagerMeniu tmm;
    public static Vector2f map;
    private int currentchoice=0;



    private Camera cam;
    public MenuState(GameStateManager gsm) throws SQLException {
        super(gsm);
        tmm=new TileManagerMeniu("tile/MeniuInitial2.xml");
        map=new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        this.gsm=gsm;
       // Vector<Audio> audios=GameStateManager.getMusic();
        Table.AddEntry(GameStateManager.s,Table.SelectLast(GameStateManager.s),0,0,0,0);

    }

    private void select() {
        if(currentchoice == 1) {

        }
        if(currentchoice == 2) {
            System.out.println("7777777777777777777777777777777777777777777777777777777777777");
           gsm.setStateMuzica(GameStateManager.MUZICA);
        }
    }
    public void setCurrentchoice(int c)
    {
        currentchoice=c;
    }

    @Override
    public void update() {
        Vector2f.setWorldVar(map.x,map.y);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) throws SQLException {
            if(mouse.getButton()==1){
               // System.out.println(mouse.getX()+"-------------------------"+mouse.getY());

                if( mouse.getY()<=250 && mouse.getY()>=205 && mouse.getX()>=563 && mouse.getX()<=688 ) {

                    System.out.println(mouse.getX()+"-------------------------"+mouse.getY());
                    gsm.setStateMuzica(GameStateManager.MUZICA);
                    //System.out.println("?????????????????????????????????????");
                }
                if(mouse.getX()>=563 && mouse.getX()<=688 && mouse.getY()<=170 && mouse.getY()>=126) {
                    gsm.setState(GameStateManager.PLAY);
                }
            }



        }

    @Override
    public void render(Graphics2D g) {
        g.translate(0,0);
        tmm.render(g);


    }
}
