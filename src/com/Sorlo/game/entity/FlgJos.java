package com.Sorlo.game.entity;

import com.Sorlo.game.graphics.Sprites.Sprite80;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;

public class FlgJos extends Entity {

    public boolean isAlive;
    private int r;
    Color a;
    boolean flag;
    public int inc;
    int sum;
    Rect col;
    PlayerNivel2 p;


    public FlgJos(Sprite80 sprite, Vector2f origin, int size, PlayerNivel2 p) {

        super(sprite, origin, size);

        this.p=p;

        r=135;
        flag=true;

        sum=30;
        col=new Rect((int)pos.x+32, (int)pos.y,16,80);

    }

    public void update(PlayerNivel2 player) throws IOException, InterruptedException {

    }

    public Color getColor()
    {
        return a;
    }


    public void move() throws InterruptedException {

    }
    public void setInc(int i)
    {
        inc=i;
    }

    public void animate()
    {
            if (currentAnimation != 0 || ani.getDelay() == -1)
                setAnimation(0, sprite80.getSpriteArray(0), 5);//nu stim care e up, asa ca sounem ca 0 e UP, dar nu stim


    }

    public void render(Graphics2D g) throws InterruptedException {



        sum--;

            if(sum>=0 && sum<=30) {
                g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), 80, 80, null);
                sum=200;
                g.drawRect(col.x, col.y, col.z, col.t);
                if(p.doOverlap(p.incercare,col))
                    p.isAlive=false;
            }



    }


    public void setFlag(boolean t)
    {
        flag=t;
    }

    @Override
    public Vector2f getPos() {
        return new Vector2f(this.dx, this.dy);
    }
    public void input(MouseHandler mouse, KeyHandler key){
        if(mouse.getButton()==1){
            System.out.println("flgr: "+pos.x+","+pos.y);
        }





    }
}
