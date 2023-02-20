package com.Sorlo.game.util;

import com.Sorlo.game.entity.Entity;
import com.Sorlo.game.entity.Player;
import com.Sorlo.game.entity.Rect;
import com.Sorlo.game.tiles.Block;
import com.Sorlo.game.tiles.TileMapObj;

import java.awt.*;
import java.util.Map;
import java.util.Vector;

/**
 * Aceasta este clasa care implementeaza coliziunile jocului, adica daca playerul se va lovi de entitati, obiecte solide,
 * pereti, podea
 */
public class Coliziuni {

    private Vector2f pos;///pentru a stabili pozitia la care se fac coliziunile
    private int xOffset = 0;///offset-ul pe axa x initial este de 0
    private int yOffset = 0;///offset-ul pe axa y initial este de 0
    private int w;///aceasta va fi lungimea patratului de  coliziunie
    private int h;///inaltimea patratului de coliziune
    private float r;///raza pentru obiectele ale caror coliziuni vor fi un cerc (inamicii)
    private int size;



    public Coliziuni(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w, h);///dimensiunea va fi maximul dintre lungime si inaltime

    }


    /**
     * acesta este constructorul pentru coliziunile circulare care primeste ca parametrii:
     * @param pos - pozitia la care initializam coliziunea
     * @param r - raza acesteia
     */
    public Coliziuni(Vector2f pos, int r) {
        this.pos = pos;
        this.r = r;

        size = r;
    }

    public Vector2f getPos() {
        return pos;
    }



    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }



    public void setWidth(int f) {
        w = f;
    }

    public void setHeight(int f) {
        h = f;
    }

    public void setXOffset(int f) {
        xOffset = f;
    }

    public void setyOffset(int f) {
        yOffset = f;
    }

    public int getXOffset()
    {
        return xOffset;
    }
    public int getYOffset()
    {
        return yOffset;
    }


    /**
     * aceasta clasa implementeaza coliziunea dintre obiectul al carei coliziune a fost implementata sub forma de dreptunghi
     * si cel care este sub forma de cerc
     *
     * @param aBox - coliziunea in forma de patrulater
     * @return
     */
    public boolean colCircleBox(Coliziuni aBox) {///coliziunea dintre cerc si box

        double dx=Math.max(aBox.getPos().x+aBox.getXOffset(),Math.min(pos.x+(r/2),aBox.getPos().x+aBox.getXOffset()+aBox.getWidth()));
        double dy=Math.max(aBox.getPos().y+aBox.getYOffset(),Math.min(pos.y+(r/2),aBox.getPos().y+aBox.getYOffset()+aBox.getHeight()));

        dx=pos.x+(r/2)-dx;
        dy=pos.y+(r/2)-dy;
        if(Math.sqrt(dx*dx+dy*dy)<r/2){
            return true;
        }

        return false;
    }


    /**
     * aceasta va implementa tiles-urile cu care se vor face coliziunile
     * acestea vor fi calculate in fiecare colt al tile-ului
     * @param ax
     * @param ay
     * @return
     */
    public boolean collisionTile(double ax, double ay) {
        for (int c = 0; c < 4; c++)//merge in fiecare colt al tile-ului
        {
            int xt = (int) ((pos.x + ax) + (c % 2) * w + xOffset) / 16;
            int yt = (int) ((pos.y + ay) + (c / 2) * h + yOffset) / 16;

            if (TileMapObj.tmo_blocks.containsKey(String.valueOf(xt) + "," + String.valueOf(yt))) {
                return TileMapObj.tmo_blocks.get(String.valueOf(xt) + "," + String.valueOf(yt)).update(this);///Obiectele din tilemapobj for fi facute cu coliziuni ca personajul sa se loveasca de ele
            }



        } return false;


    }


}

