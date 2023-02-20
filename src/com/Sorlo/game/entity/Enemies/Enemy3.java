package com.Sorlo.game.entity.Enemies;

import com.Sorlo.game.entity.Entity;
import com.Sorlo.game.entity.Player;
import com.Sorlo.game.graphics.Sprites.Sprite48;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.io.IOException;

public class Enemy3 extends Entity {
    private final int STAY=0;
    private final int LEFT=1;
    public boolean stay=true;
    public boolean left=false;
    public Coliziuni sense;
    public boolean isAlive;
    private int r;
    Color a;
    int i;
    Player p;
    boolean flag;
    boolean pressedOnce;
    public int inc;


    public Enemy3(Sprite48 sprite, Vector2f origin, int size, Color b) {

        super(sprite, origin, size, b);
        bounds.setWidth(40);
        bounds.setHeight(16);
        bounds.setXOffset(4);
        bounds.setyOffset(0);

        bounds1.setWidth(40);
        bounds1.setHeight(16);
        bounds1.setXOffset(4);
        bounds1.setyOffset(16);

        bounds2.setWidth(40);
        bounds2.setHeight(16);
        bounds2.setXOffset(4);
        bounds2.setyOffset(32);

        acc=1f;
        maxSpeed=3f;
        r=135;
        isAlive=true;

        entitateRosie=true;
        this.a=b;

        sense=new Coliziuni(new Vector2f(origin.x-size/2,origin.y-size/2),r);
        flag=true;
        inc=300;



    }
    public void update(Player player) throws IOException, InterruptedException {
        if(isAlive==true)
            if(sense.colCircleBox(player.getBounds())){
                System.out.println("Yes");
            }

    }

    public Color getColor()
    {
        return a;
    }


    public void move() throws InterruptedException {
        if(flag==true && pos.x>1100 && inc>0) {

            pos.x -= 20;
            flag = false;
            inc=inc-100;

        }
    }
    public void setInc(int i)
    {
        inc=i;
    }
    public boolean killsPlayer()
    {
        if(pos.x<= 3160-200 && isAlive)
            return true;
        else return false;
    }



    public boolean getIsAlive()
    {
        return isAlive;
    }
    public void setIsAlive(boolean a)
    {
        this.isAlive=a;
    }
    public void Disappear()
    {
        isAlive=false;
        sense=new Coliziuni(new Vector2f(0,0),0);
    }
    public void animate()
    {
        if(isAlive) {
            if (stay) {
                if (currentAnimation != STAY || ani.getDelay() == -1)
                    setAnimation(STAY, sprite48.getSpriteArray(STAY), 5);//nu stim care e up, asa ca sounem ca 0 e UP, dar nu stim
            } else if (attack) {
                if (currentAnimation != LEFT | ani.getDelay() == -1)
                    setAnimation(LEFT, sprite48.getSpriteArray(LEFT), 5);
            } else {
                setAnimation(currentAnimation, sprite48.getSpriteArray(currentAnimation), -1);
            }
        }
    }

    public void render(Graphics2D g) throws InterruptedException {
        if(isAlive)
        //g.drawImage(ani.getImage(),(int)(pos.x),(int)(pos.y), size, size, null);
        {
            //move();
            g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
            //System.out.println("Pentru cea rosie 99999999999999999999"+ "    "+pos.x);
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
            System.out.println("Fantomita: "+pos.x+","+pos.y);
        }
        if(key.attack.down) {
            attack = true;
        }
        else
        {
            attack=false;
        }
    }
}
