package com.Sorlo.game.entity.Culori;

import com.Sorlo.game.entity.Ace.*;
import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.entity.Enemies.Enemy;
import com.Sorlo.game.entity.Enemies.Enemy2;
import com.Sorlo.game.entity.Entity;
import com.Sorlo.game.graphics.Sprites.Sprite32;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;


public class CuloareAlbastra extends Entity {



    public CuloareAlbastra(Sprite32 sprite, Vector2f origin, int size) {

        super(sprite, origin, size);

    }





    public void move() throws InterruptedException {

    }

    public double getDx()
    {
        return dx;
    }


    public void render(Graphics2D g) throws InterruptedException {

            g.drawImage(ani.getImage(),(int)(pos.x),(int)(pos.y), size, size, null);

    }


    @Override
    public Vector2f getPos() {
        return null;
    }
    public void input(MouseHandler mouse, KeyHandler key){
    }

}


