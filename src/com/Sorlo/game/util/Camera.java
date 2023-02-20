package com.Sorlo.game.util;


import com.Sorlo.game.GamePanel;
import com.Sorlo.game.entity.*;
import com.Sorlo.game.entity.Enemies.ENEM;
import com.Sorlo.game.states.PlayState;

import java.awt.*;

/**
 * este clasa ce misca camera conform miscarii personajului
 * daca acesta se va deplasa la dreapta sau stanga, camera va deplasa si mapa in aceeasi directie
 */
public class Camera {
    private Coliziuni collisionCam;
    private Coliziuni bounds;

    private boolean up;
    private boolean down;

    private float dx;
    private float dy;
    private float maxSpeed = (float) 1.2;
    private float acc = (float) 0.6;
    private float deacc = (float) 0.6;
    protected float x;
    protected int s = 0;
    protected int param;
    boolean flag=true;
    boolean flag2=true;
    boolean f;
    Camera cam;

    public int sum;

    protected boolean right;
    protected boolean left;
    private int widthLimit;
    private int heightLimit;

    private int tileSize = 16;

    private Player e;
    private PlayerNivel2 e2;
    boolean flagg;
    boolean flaggg;

    public Camera(Coliziuni collisionCam) {

        this.collisionCam=collisionCam;
        flagg=false;
        flaggg=false;
        sum=0;
        f=false;
        dx=0;
        x=0;
    }
    public void setCamera(Camera cam)
    {
        this.cam=cam;
    }

    public void setLimit(int widthLimit, int heightLimit) {
        this.widthLimit = widthLimit;
        this.heightLimit = heightLimit;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }


    public Vector2f getPos() {
        return collisionCam.getPos();
    }

    public Coliziuni getBounds() {
        return collisionCam;
    }

    public void update() {
        if(e.isAlive) {
            move();///atat timp cat playerul este in viata, camera sa ve misca

        }
    }
    public void update2()
    {
        if(e2.isAlive && flag==true) {
            move2();

        }
    }


    private void move() {

        if (e.right && !e.bounds.collisionTile(e.getDx(), 0) && !e.bounds1.collisionTile(e.getDx(), 0) && !e.bounds2.collisionTile(e.getDx(), 0) && !e.bounds3.collisionTile(e.getDx(), 0) && !e.left) {
            x -= acc;
            dx -= acc;
            if (x < -maxSpeed) {
                x = (float) -maxSpeed;
            }
            if (dx < -maxSpeed) {
                dx = (float) -maxSpeed;
            }
        } else {
            if (x < 0) {
                x += deacc;

                if (x > 0) {
                    x = 0;

                }
                if (dx < 0) {
                    dx += deacc;

                    if (dx > 0) {
                        dx = 0;

                    }
                }
            }
            if (e.left && !e.bounds.collisionTile(e.getDx(), 0) && !e.bounds1.collisionTile(e.getDx(), 0) && !e.bounds2.collisionTile(e.getDx(), 0) && !e.bounds3.collisionTile(e.getDx(), 0) && !e.right) {
                x += acc;
                if (x > maxSpeed) {
                    x = (float) maxSpeed;

                }

                dx += acc;
                if (dx > maxSpeed) {
                    dx = (float) maxSpeed;

                }
            } else {
                if (x > 0) {
                    x -= deacc;

                    if (x < 0) {
                        x = 0;
                    }
                }
                if (dx > 0) {
                    dx -= deacc;

                    if (dx < 0) {
                        dx = 0;
                    }
                }
            }
        }



    }
    public void move2(){

        System.out.println("LA MOVE AVEM:    "+maxSpeed+"---------"+acc+"--------"+deacc);
        if (e2.right && !e2.bounds.collisionTile(e2.getDx(), 0) && !e2.bounds1.collisionTile(e2.getDx(), 0) && !e2.bounds2.collisionTile(e2.getDx(), 0) && !e2.bounds3.collisionTile(e2.getDx(), 0) && !e2.left) {
            x -= acc;
            dx -= acc;
            if (x < -maxSpeed) {
                x = (float) -maxSpeed;
            }
            if (dx < -maxSpeed) {
                dx = (float) -maxSpeed;
            }
        } else {
            if (x < 0) {
                x += deacc;

                if (x > 0) {
                    x = 0;

                }
                if (dx < 0) {
                    dx += deacc;

                    if (dx > 0) {
                        dx = 0;

                    }
                }
            }
            if (e2.left && !e2.bounds.collisionTile(e2.getDx(), 0) && !e2.bounds1.collisionTile(e2.getDx(), 0) && !e2.bounds2.collisionTile(e2.getDx(), 0) && !e2.bounds3.collisionTile(e2.getDx(), 0) && !e2.right) {
                x += acc;
                if (x > maxSpeed) {
                    x = (float) maxSpeed;

                }

                dx += acc;
                if (dx > maxSpeed) {
                    dx = (float) maxSpeed;

                }
            } else {
                if (x > 0) {
                    x -= deacc;

                    if (x < 0) {
                        x = 0;
                    }
                }
                if (dx > 0) {
                    dx -= deacc;

                    if (dx < 0) {
                        dx = 0;
                    }
                }
            }
        }


    }


    public void target(Player e) {
        this.e = e;
        if (e != null) {
            acc = (float) 0.1;
            deacc = (float) 0.1;
            maxSpeed = (float) 1.2;
        } else {
            acc = (float) 0.1;
            deacc = (float) 0.1;
            maxSpeed = (float) 1.2;


        }
    }

    public void target(PlayerNivel2 e) {
        this.e2 = e;
        if (e != null) {
            acc = (float) 0.1;
            deacc = (float) 0.1;
            maxSpeed = (float)1.2;
        } else {
            acc = (float) 0.1;
            deacc = (float) 0.1;
            maxSpeed = (float) 1.2;


        }
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        if (e == null) {
            if (key.up.down) {
                up = true;
            } else {
                up = false;
            }
            if (key.down.down) {
                down = true;
            } else {
                down = false;
            }
            if (key.left.down) {
                left = true;
            } else {
                left = false;
            }
            if (key.right.down) {
                right = true;
            } else {
                right = false;
            }
        } else {

        }
    }




    public void render(Graphics g, int c) {

        if(flag2==true) {

            if (e.isAlive) {
                if (e.getPosX2() <= 2800 && e.getPosX2() >= 28 && !e.bounds.collisionTile(x,0)&& !e.bounds1.collisionTile(x,0)&& !e.bounds2.collisionTile(x,0)&& !e.bounds3.collisionTile(x,0)) {
                //if (e.camDreapta()==false && e.getPosX2() >= 28 && !e.bounds.collisionTile(x,0)&& !e.bounds1.collisionTile(x,0)&& !e.bounds2.collisionTile(x,0)&& !e.bounds3.collisionTile(x,0)) {
                    {
                      //  move();
                        System.out.println("                         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + x);
                        // System.out.println("888888888888888888888888888888888888888888888888888888888888888888888888888888888888888 " + e2.getPosX2());
                        g.translate((int) (x), 0);
                        sum = sum + (int) x;
                        System.out.println("sum----------------------------------------------------------------------" + sum);
                    }
                    ;

                }

            }

            if (!e.isAlive && flagg == false) {
                g.translate((int) -sum, 0);
                e.nextLevel = false;
                flagg = true;
                System.out.println("E APELATAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }


            if (e.cheiColectate == 4 && e.butoaieColectate == 3) {
                g.translate((int) -sum, 0);
                //e.nextLevel = false;
                f = true;
                System.out.println("55555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
            }
        }

    }

    public void render2(Graphics g, int c) {
        if(flag==true) {

            if (e2.isAlive ) {
                if (e2.colDreapta()==false && e2.getPosX2() >= 28 && !e2.bounds.collisionTile(x,0)&& !e2.bounds1.collisionTile(x,0)&& !e2.bounds2.collisionTile(x,0)&& !e2.bounds3.collisionTile(x,0)) {
                    {
                        g.translate((int) (x), 0);
                        sum = (int) (sum + (int) x);

                    }


                }

            }
            if (!e2.isAlive && flaggg==false) {
                g.translate((int) -sum, 0);
                sum = 0;
                e2.nextLevel=false;
                flaggg=true;

            }


            if (e2.nextLevel == true ) {
                if (PlayState.map.x < 0)
                    PlayState.map.x = 0;
                g.translate((int) -sum, 0);
                sum = 0;
                e2.nextLevel = false;
            }
        }
    }
}

