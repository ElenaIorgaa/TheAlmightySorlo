package com.Sorlo.game.entity;

import com.Sorlo.game.graphics.*;
import com.Sorlo.game.graphics.Sprites.*;
import com.Sorlo.game.util.Coliziuni;
import com.Sorlo.game.util.KeyHandler;
import com.Sorlo.game.util.MouseHandler;
import com.Sorlo.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity{
    private final int DOWN=1;
    private final int RIGHT=2;
    private final int LEFT=3;
    private final int JUMPRIGHT=0;
    private final int FALLING=0;
    private final int JUMPLEFT=1;
    private final int ATTACKGALBEN=4;
    private final int ATTACKROSU=5;
    private final int ATTACKALBASTRU=6;
    private final int ATTACKVERDE=7;
    private final int UP=1;
    protected int currentAnimation;
    protected int life;
    public boolean entitateGalbena;
    public boolean entitateRosie;
    public boolean entitateAlbastra;
    public boolean entitateVerde;
    public int x;
    public int y;
    public int z;
    public int t;


    // movement attributes
    protected double moveSpeed;
    protected double stopSpeed;
    protected double fallSpeed;
    protected double maxFallSpeed;
    protected double jumpStart;
    protected double stopJumpSpeed;

    protected Animation ani;
    protected Sprite sprite;
    protected Sprite48 sprite48;
    protected Sprite482 sprite482;
    protected Sprite192 sprite192;
    protected Sprite32 sprite32;
    protected Sprite80 sprite80;

    public Vector2f pos;
    protected int size;
    protected Sprite16 sprite16;

    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;

    protected boolean falling;
    protected boolean down;
    public boolean right;
    public boolean left;
    public boolean up;
    public boolean jump;
    public boolean attack;
    public boolean escape;
    protected int attackSpeed;
    protected int attackDuration;
    protected BufferedImage img;

    public boolean xCol = false;
    public boolean yCol = false;
    protected Coliziuni hitBounds;
    public Coliziuni bounds1;
    public Coliziuni bounds2;
    public Coliziuni bounds3;

    protected double dx;
    protected double dy;
    public static final double Friction=0.99;
    public static final double GRAVITY = 0.01;
    private double posX;
    private double posY;
    private double speedX = 0;
    private double speedY = 0;
    public double maxSpeed=  1.2;

    protected double acc=0.3;
    protected double deacc=0.3;

    protected double speed= (float) 0.3;



    //noi
    private int state;
    int nrAtacuri;
    private long stateTime;
    private int force = 0;

    protected Color culoare;
    public Coliziuni bounds;

    public Entity(int x, int y, int z, int t, Vector2f origin, Player player) {
        pos=origin;
        this.x=x;
        this.y=y;
        this.z=z;
        this.t=t;
        bounds=new Coliziuni(origin,size,size);

    }

    public Entity(int x, int y, int z, int t, Vector2f origin, PlayerNivel2 player) {
        pos=origin;
        this.x=x;
        this.y=y;
        this.z=z;
        this.t=t;
        bounds=new Coliziuni(origin,size,size);

    }
    public Entity(int x, int y, int z, int t, Vector2f origin) {
        pos=origin;
        this.x=x;
        this.y=y;
        this.z=z;
        this.t=t;


    }


    public Entity(Sprite482 sprite, Vector2f origin, int size)
    {
        this.sprite482=sprite;
        pos=origin;
        this.size=size;

        ani=new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT),10);

        //tc=new TileCollision(this);
    }


    public float getSpeed()
    {
        return (float) maxSpeed;
    }
    public double getSpeed2() {return speed;}

    public void setForce(int force)
    {
        this.force=force;
    }
    public double getVelocityX() {
        return this.dx;
    }

    public double getVelocityY() {
        return this.dy;
    }

    public void setVelocityX(float dx) {
        this.dx = dx;
    }

    public void setVelocityY(float dy) {
        this.dy = dy;
    }
    public void setState(int state) {
        if (this.force > 0 && state == 1) {
            --this.force;
        } else if (this.state != state) {
            this.state = state;
            this.stateTime = 0L;
            if (state == 1) {
                this.setVelocityX(0.0F);
                this.setVelocityY(0.0F);
            }
        }

    }




    public Entity(Sprite sprite, Vector2f origin, int size)
    {
        this.sprite=sprite;
        pos=origin;
        this.size=size;

        bounds=new Coliziuni(origin,size,size);
        bounds1=new Coliziuni(origin,size,size);
        bounds2=new Coliziuni(origin,size,size);
        bounds3=new Coliziuni(origin,size,size);
        hitBounds=new Coliziuni(new Vector2f(origin.x+(size/2),origin.y),size,size);//sa fie mai la stanga


        ani=new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT),10);
        xMove=0;
        yMove=0;
        nrAtacuri=0;


        //tc=new TileCollision(this);
    }
    public Entity(Sprite80 sprite, Vector2f origin, int size) {
        this.sprite80=sprite;
        pos=origin;
        this.size=size;

        ani=new Animation();
        setAnimation(0, sprite.getSpriteArray(0),10);

    }
    public Entity(Sprite48 sprite, Vector2f origin, int size, Color b)
    {
        this.sprite48=sprite;
        pos=origin;
        this.size=size;
        this.culoare=b;

        bounds=new Coliziuni(origin,size,size);
        bounds1=new Coliziuni(origin,size,size);
        bounds2=new Coliziuni(origin,size,size);
        bounds3=new Coliziuni(origin,size,size);
        hitBounds=new Coliziuni(new Vector2f(origin.x+(size/2),origin.y),size,size);//sa fie mai la stanga


        ani=new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT),10);

        //tc=new TileCollision(this);
    }
    public Entity(Sprite192 sprite, Vector2f origin, int size)
    {
        this.sprite192=sprite;
        pos=origin;
        this.size=size;



        //ani=new Animation();
        //setAnimation(RIGHT, sprite.getSpriteArray(0),10);

        //tc=new TileCollision(this);
    }
    public Entity(Sprite16 sprite, Vector2f origin, int size)
    {
        this.sprite16=sprite;
        pos=origin;
        this.size=size;
        bounds=new Coliziuni(origin,size,size);


        ani=new Animation();
        setAnimation(0, sprite.getSpriteArray(0),10);


        //tc=new TileCollision(this);
    }
    public Entity(Sprite32 sprite, Vector2f origin, int size)
    {
        this.sprite32=sprite;
        pos=origin;
        this.size=size;

        bounds=new Coliziuni(origin,size,size);

        ani=new Animation();
        setAnimation(0, sprite.getSpriteArray(0),10);



        //tc=new TileCollision(this);
    }
    public Coliziuni getHitBounds()
    {
        return hitBounds;
    }

    private void setHitBoxDirection()
    {
        if(jump){
            hitBounds.setyOffset(0);
            hitBounds.setXOffset(0);

        }
        else if(down){

            hitBounds.setyOffset(size/2);
            hitBounds.setXOffset(-size/2);

        }
        else if(up){

            hitBounds.setyOffset(-size/2);
            hitBounds.setXOffset(-size/2);

        }
        else if(left){
            hitBounds.setyOffset(0);
            hitBounds.setXOffset(-size);

        }
        else if(right){

            hitBounds.setyOffset(0);
            hitBounds.setXOffset(0);
        }
        else if(attack)
        {
            hitBounds.setyOffset(0);
            hitBounds.setXOffset(0);
        }



    }




    public void setSprite(Sprite sprite){
        this.sprite=sprite;

    }
    public void setSize(int i)
    {
        size=i;
    }
    public void setMaxSpeed(float f){
        maxSpeed=f;
    }
    public int getSize(){
        return size;
    }

    public Animation getAnimation(){
        return ani;
    }
    public void setAcc(float f)
    {
        acc=f;
    }
    public void setDeacc(float f)
    {
        deacc=f;
    }
    public Coliziuni getBounds()
    {
        return bounds;
    }


    public void setAnimation(int i, BufferedImage[] frames, int delay){
        currentAnimation=i;
        ani.setFrames(frames);
        ani.setDelay(delay);
    }
    public Color getCuloare()
    {
        return culoare;
    }

    public void animate(){
        if(up)
        {
            if(currentAnimation!=UP|ani.getDelay()==-1)
                setAnimation(UP, sprite.getSpriteArray(UP), 5);

        }
        if(jump){
            if(currentAnimation!=JUMPRIGHT||ani.getDelay()==-1)
                setAnimation(JUMPRIGHT, sprite.getSpriteArray(JUMPRIGHT), 5);//nu stim care e up, asa ca sounem ca 0 e UP, dar nu stim
        }
        if(falling){
            if(currentAnimation!=FALLING||ani.getDelay()==-1)
                setAnimation(FALLING, sprite.getSpriteArray(FALLING), 5);
        }
        else if(jump && right)
        {
            if(currentAnimation!=JUMPRIGHT||ani.getDelay()==-1)
                setAnimation(JUMPRIGHT, sprite.getSpriteArray(JUMPRIGHT), 5);
        }
        else if(jump && left)
        {
            if(currentAnimation!=JUMPLEFT||ani.getDelay()==-1)
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
        }
        else if(down)
        {
            if(currentAnimation!=DOWN|ani.getDelay()==-1)
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
        }
        else if(left)
        {
            if(currentAnimation!=LEFT||ani.getDelay()==-1)
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
        }
        else if(right) {
            if (currentAnimation != RIGHT || ani.getDelay() == -1)
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);

        } /*else if(attack){
            //if(entitateAlbastra==true)
            //{
                //if(currentAnimation!=ATTACKALBASTRU||ani.getDelay()==-1)
                   // setAnimation(ATTACKALBASTRU,sprite.getSpriteArray(ATTACKALBASTRU),5);
                //entitateAlbastra=false;
            //}
           // else if(entitateRosie==true)
            //{
            //    if(currentAnimation!=ATTACKROSU||ani.getDelay()==-1)
            //        setAnimation(ATTACKROSU,sprite.getSpriteArray(ATTACKROSU),5);
           // }
           // else if(entitateVerde==true)
            //{
            //    if(currentAnimation!=ATTACKVERDE||ani.getDelay()==-1)
           //         setAnimation(ATTACKVERDE,sprite.getSpriteArray(ATTACKVERDE),5);
           // }
              if(nrAtacuri==0)
            {
               if(currentAnimation!=ATTACKGALBEN||ani.getDelay()==-1)
                     setAnimation(ATTACKGALBEN,sprite.getSpriteArray(ATTACKGALBEN),5);
               nrAtacuri++;
            }
              if(nrAtacuri==3) {
                  if (currentAnimation!=ATTACKROSU||ani.getDelay() == -1)
                      setAnimation(ATTACKROSU, sprite.getSpriteArray(ATTACKROSU), 5);
                  nrAtacuri++;
              }

        }*/
        else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }



    }
    public void render(){

    }
    public void update() throws  InterruptedException {
        animate();
        setHitBoxDirection(); //unde ma intorc , acolo lovesc
        ani.update();
    }

    public void input(KeyHandler key, MouseHandler mouse){

    }

    public abstract Vector2f getPos();

    public  float getAcc()
    {
        return (float) acc;
    }

    public float getDeacc()
    {
        return (float) deacc;
    }

    public float getMaxSpeed()
    {
        return (float) maxSpeed;
    }

    public double getDy()
    {
        return dy;
    }

    public double getDx()
    {
        return dx;
    }
    public double setDy(float v)
    {
        return dy;
    }

    public double setDx(float v)
    {
        return dx;
    }


}
