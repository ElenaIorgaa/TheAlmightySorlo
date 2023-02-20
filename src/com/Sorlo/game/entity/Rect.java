package com.Sorlo.game.entity;

import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;
import java.util.TimerTask;

public class Rect extends  Entity {
    Rectangle obj;
    Player p;
    PlayerNivel2 p2;

    public Rect( int x, int y, int z, int t, Player p)
    {
        super(x,y,z,t, new Vector2f(x,y), p);
        bounds.setWidth(z);
        bounds.setHeight(t);
        bounds.setXOffset(0);
        bounds.setyOffset(0);
        this.obj=new Rectangle(x,y,z,t);
        this.p=p;

    }
    public Rect( int x, int y, int z, int t, PlayerNivel2 p2)
    {
        super(x,y,z,t, new Vector2f(x,y), p2);
        bounds.setWidth(z);
        bounds.setHeight(t);
        bounds.setXOffset(0);
        bounds.setyOffset(0);
        this.obj=new Rectangle(x,y,z,t);
        this.p2=p2;

    }
    public Rect( int x, int y, int z, int t)
    {
        super(x,y,z,t, new Vector2f(x,y));

        this.obj=new Rectangle(x,y,z,t);


    }


    public Rectangle getRectangle()
    {
        Rectangle rect=new Rectangle((int) (p.pos.x+p.bounds.getXOffset()),(int)(p.pos.y+p.bounds.getYOffset()),p.bounds.getWidth(),p.bounds.getHeight());
        return rect;
    }
    boolean doOverlap() {


        int r1x= (int) x;
        int r1y=(int)y;
        int r1width=(int)z;
        int r1height=t;

        int r2x= (int) (p.pos.x+p.incercare.getXOffset());
        int r2y=(int) (p.pos.y+p.incercare.getYOffset());
        int r2width=p.incercare.getWidth();
        int r2height=p.incercare.getHeight();

        Rectangle out = null;


        float xmin = Math.max(r1x, r2x);
        float xmax1 = r1x + r1width;
        float xmax2 = r2x + r2width;
        float xmax = Math.min(xmax1, xmax2);
        if (xmax > xmin) {
            float ymin = Math.max(r1y, r2y);
            float ymax1 = r1y + r1height;
            float ymax2 = r2y + r2height;
            float ymax = Math.min(ymax1, ymax2);
            if (ymax > ymin) {

                return true;
            }
        }
        return false;
    }

    public void render(Graphics2D g) throws InterruptedException, IOException {
        g.setColor(Color.blue);
        g.drawRect(x, y, z, t);
        g.setColor(Color.red);
        g.drawRect((int) (pos.x),(int)(pos.y),bounds.getWidth(),bounds.getHeight());
        update(p);

    }
    public void update(Player p) throws IOException, InterruptedException {
        if(doOverlap()){
            //System.out.println("Yes===================================================================================");

        }



    }


    @Override
    public Vector2f getPos() {
        return null;
    }
    public void input(MouseHandler mouse, KeyHandler key){
        if(mouse.getButton()==1){
            System.out.println("Player: "+pos.x+","+pos.y);
        }
        if(key.up.down)
        {
            up=true;
        }
        else{
            up=false;
        }

    }
}
