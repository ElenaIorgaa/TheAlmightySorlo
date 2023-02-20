package com.Sorlo.game.tiles;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import com.Sorlo.game.util.Vector2f;
import com.Sorlo.game.util.Coliziuni;

public class NormBlock extends Block {
    public NormBlock(BufferedImage img, Vector2f pos, int w, int h)
    {
        super(img,pos,w,h);
    }

    public boolean update(Coliziuni p) {
        return false;
    }
    public void render(Graphics2D g)
    {
        super.render(g);
    }
}
