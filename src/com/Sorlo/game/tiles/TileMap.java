package com.Sorlo.game.tiles;

import com.Sorlo.game.tiles.Block;
import com.Sorlo.game.util.Coliziuni;

import java.awt.*;


/**
 * clasa abstraca TileMap din care se vor extinde TileMapNorm si TileMapObj, adica obiectele cu care nu interactioneaza
 * si cu care da
 */

public abstract class TileMap {

    //public abstract Block[] getBlocks();

    public abstract void render(Graphics2D g, Coliziuni cam);


    public abstract void render(Graphics2D g);
}
