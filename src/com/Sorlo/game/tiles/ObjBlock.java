package com.Sorlo.game.tiles;

import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;
import com.Sorlo.game.tiles.Block;

import com.Sorlo.game.tiles.NormBlock;
import com.Sorlo.game.tiles.ObjBlock;


public class ObjBlock extends Block {

    public ObjBlock(BufferedImage img, Vector2f pos, int w, int h){
        super(img, pos, w, h);
    }
    @Override
    public boolean update(Coliziuni p) {
        return true;
    }

    public void render(Graphics2D g)
    {
        super.render(g);
        //g.setColor(Color.white);
        //g.drawRect((int) pos.x, (int) pos.y,w,h);

    }
}
