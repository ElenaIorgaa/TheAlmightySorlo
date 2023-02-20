package com.Sorlo.game.states;

import com.Sorlo.game.tiles.TileManagerMeniu2;
import com.Sorlo.game.util.*;

import java.awt.*;
import java.sql.SQLException;

public class MenuState2 extends GameState {
    private TileManagerMeniu2 tmm;
    public static Vector2f map;
    private int currentchoice=0;
    boolean flag;

    private Camera cam;
    public MenuState2(GameStateManager gsm) {
        super(gsm);
        tmm=new TileManagerMeniu2("tile/MeniuInitial2.xml");
        map=new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        this.gsm=gsm;
        flag=true;


    }

    private void select() throws SQLException {
        if(currentchoice == 1) {
            gsm.setNivel2(GameStateManager.LEVEL2);
        }
        if(currentchoice == 0) {
            // help
        }
        if(currentchoice == 2) {
            System.exit(0);
        }
    }

    @Override
    public void update() {
        Vector2f.setWorldVar(map.x,map.y);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) throws SQLException {
        if(mouse.getButton()==1){
            if(mouse.getX()>=563 && mouse.getX()<=688 && mouse.getY()<=170 && mouse.getY()>=126) {
                currentchoice = 1;
                System.out.println(mouse.getX()+" -mouse- "+ mouse.getY()+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                select();
            }
        }



    }

    @Override
    public void render(Graphics2D g) {
        if(flag==true) {
            g.translate(0, 0);
            tmm.render(g);
            flag=false;
        }


    }
}
