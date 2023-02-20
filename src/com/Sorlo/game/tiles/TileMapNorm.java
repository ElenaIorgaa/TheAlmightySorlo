package com.Sorlo.game.tiles;

import com.Sorlo.game.graphics.Sprites.Sprite;
import com.Sorlo.game.graphics.Sprites.SpriteSheet;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.util.ArrayList;


/**
 * Clasa TileMapNorm implementeaza obiectele prin care personajul poatre trece fara probleme
 * adica cu care nu interactioneaza
 */
public class TileMapNorm extends TileMap {


    private ArrayList<Block> blocks;

    public TileMapNorm(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new ArrayList<Block>();

        String[] block = data.split(",");
        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            System.out.println(temp + " " + (i % width) * tileWidth + " " + (int) (i / width) * tileHeight);
            if (temp != 0) {
                blocks.add(new NormBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns)), new Vector2f((int) (i % width) * tileWidth, (int) (i / width) * tileHeight), tileWidth, tileHeight));
            }
        }

    }

    public TileMapNorm(String data, SpriteSheet sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new ArrayList<Block>();


        String[] block = data.split(",");
        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                blocks.add(new NormBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns)), new Vector2f((int) (i % width) * tileWidth, (int) (i / width) * tileHeight), tileWidth, tileHeight));
                ;


            }
        }

    }


    public void render(Graphics2D g, Coliziuni cam) {

        int x = (int) ((cam.getPos().x) / 16);
        int y = (int) ((cam.getPos().y) / 16);

        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);

        }


    }
    public void render(Graphics2D g) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);

        }

    }
}




