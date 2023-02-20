package com.Sorlo.game.util;


/**
 * Clasa aceasta se va ocupa de pozitia personajului, entitatilor si a inamicilor pe harta.
 * Este o notatie pentru coordonatele x si y
 */
public class Vector2f {

    public double x;
    public double y;

    public static double worldX;
    public static double worldY;

    public Vector2f() {
        x = 0;
        y = 0;
    }

    public Vector2f(Vector2f pos) {
        new Vector2f(pos.x, pos.y);
    }

    public Vector2f(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public void setX(double f) { x = f; }
    public void setY(double f) { y = f; }

    /**
     * seteaza coordonatele lumii
     * @param x
     * @param y
     */
    public static void setWorldVar(double x, double y) {
        worldX = x;
        worldY = y;
    }

    /**
     * returneaza coordonata x
     * @param x
     * @return
     */
    public static float getWorldVarX(float x) {
        return x ;
    }
    /**
     * returneaza coordonata y
     * @param y
     * @return
     */
    public static float getWorldVarY(float y) {
        return y ;
    }

    /**
     * Returneaza un string care ajuta la afisarea celor 2 coordonate sau concatenarea lor intr-o singura valoare de tip String
     * @return
     */
    @Override
    public String toString() {
        return x + ", " + y;
    }

}
