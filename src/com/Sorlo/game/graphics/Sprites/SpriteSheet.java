package com.Sorlo.game.graphics.Sprites;


import com.Sorlo.game.graphics.Font;
import com.Sorlo.game.util.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteSheet {

    private BufferedImage SPRITESHEET=null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE=16;
    public int w;
    public int h;
    private int wSprite;
    private int hSprite;



    public BufferedImage SpriteSheet(BufferedImage img)
    {
        w=TILE_SIZE;
        h=TILE_SIZE;

        System.out.println("Loading: ....");
        SPRITESHEET=img;
        return SPRITESHEET;
    }

    public SpriteSheet(String file)
    {

        w=TILE_SIZE;
        h=TILE_SIZE;

        System.out.println("Loading: "+file+"....");
        SPRITESHEET=loadSprite(file);
        wSprite=SPRITESHEET.getWidth() / w;
        hSprite=SPRITESHEET.getHeight() / h;

        loadSpriteArray();
    }
    public SpriteSheet(String file, int w, int h)
    {
        this.w=w;
        this.h=h;

        System.out.println("Loading: "+file+"....");
        SPRITESHEET=loadSprite(file);

        wSprite=SPRITESHEET.getWidth()/w;
        hSprite=SPRITESHEET.getHeight()/h;
        loadSpriteArray();
    }
    public void setSize(int width, int height)
    {
        setWidth(width);
        setHeight(height);
    }
    public void setWidth(int i)
    {
        w=i;
        wSprite=SPRITESHEET.getWidth()/w;
    }
    public void setHeight(int i)
    {
        h=i;
        hSprite=SPRITESHEET.getHeight()/h;
    }
    public int getWidth(){
        return w;
    }
    public int getHeight()
    {
        return h;
    }

    private BufferedImage loadSprite(String file)
    {
        BufferedImage sprite=null;
        try{
            sprite= ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));

        } catch(Exception e){

            System.out.println("ERROR: could not load file"+file);
        }
        return sprite;
    }
    public void loadSpriteArray()
    {
        spriteArray=new BufferedImage[hSprite][wSprite];
        for(int y=0; y<hSprite; y++){
            for(int x=0; x<wSprite; x++)
                spriteArray[y][x]=getSprite(x,y);
        }
    }
    public BufferedImage getSpriteSheet(){
        return SPRITESHEET;
    }

    public BufferedImage getSprite(int x, int y) {
        //System.out.println(x * w + "-" + y * h);
        return SPRITESHEET.getSubimage(x*w,y*h,w,h);
    }

    public BufferedImage[] getSpriteArray(int i)
    {
        return spriteArray[i];
    }
    public BufferedImage getSpriteArray()
    {
        return SPRITESHEET;
    }
    public BufferedImage[][] getSpriteArray2(int i){
        return spriteArray;
    }
    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img, Vector2f pos, int width, int height, int xOffset, int yOffset)
    {
        double x= pos.x;
        double y=pos.y;

        for(int i=0; i<img.size(); i++){
            if(img.get(i)!=null){
                g.drawImage(img.get(i), (int ) x, (int) y, width, height, null);

            }
            x+=xOffset;
            y+=yOffset;
        }
    }
    public static void drawArray(Graphics2D g, Font f, String word, Vector2f pos, int width, int height, int xOffset, int yOffset)
    {
        double x=pos.x;
        double y=pos.y;

        for(int i=0; i<word.length(); i++) {
            if (word.charAt(i) != 32)//every character has a special number to them
                g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
            x += xOffset;
            y += yOffset;
        }

    }
    public SpriteSheet(BufferedImage buffImg) { //retine referinta catre BufferedImage object
        SPRITESHEET = buffImg;
    }

    public BufferedImage crop(int x, int y) {
        return SPRITESHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage crop2()
    {
        return SPRITESHEET;
    }



}
