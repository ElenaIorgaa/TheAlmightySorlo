package com.Sorlo.game.tiles;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import com.Sorlo.game.util.Vector2f;
import com.Sorlo.game.util.Coliziuni;


public abstract class Block {
    protected int w;
    protected int h;

    protected BufferedImage img;
    protected Vector2f pos;


    public Block(BufferedImage img, Vector2f pos, int w, int h){
        this.img=img;
        this.pos=pos;
        this.w=w;
        this.h=h;


    }
    public abstract boolean update(Coliziuni p);

    public void render(Graphics2D g)
    {
        g.drawImage(img, (int)pos.x,(int) pos.y,w,h,null);

    }

}
