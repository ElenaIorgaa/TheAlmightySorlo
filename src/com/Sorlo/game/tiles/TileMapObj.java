package com.Sorlo.game.tiles;

import com.Sorlo.game.graphics.Sprites.SpriteSheet;

import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.Vector2f;

import java.util.HashMap;
import java.awt.Graphics2D;

/**
 * Aceasta este clasa care va introduce tiles-urile prin care personajul nu poate trece si de care se va lovi
 */
public class TileMapObj extends TileMap {
    public static int width;
    public static int height;



    public static HashMap<String, Block> tmo_blocks;


    public TileMapObj(String data, SpriteSheet sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        Block tempBlock;



        tmo_blocks = new HashMap<String, Block>();

        String[] block = data.split(",");

        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if(temp!=0) {


            tempBlock = new ObjBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns)), new Vector2f((int) (i % width) * tileWidth, (int) (i / width) * tileHeight), tileWidth, tileHeight);

            tmo_blocks.put(String.valueOf((int) (i % width)) + "," + String.valueOf((int) (i / width)), tempBlock);
        }
    }

}



    public void render(Graphics2D g, Coliziuni cam)
    {
        int x = (int) ((cam.getPos().x) / 16);
        int y = (int) ((cam.getPos().y) / 16);
        for(Block block: tmo_blocks.values())
        {
            block.render(g);
        }

    }public void render(Graphics2D g) {

        for(Block block: tmo_blocks.values())
        {
            block.render(g);
        }

    }
}
