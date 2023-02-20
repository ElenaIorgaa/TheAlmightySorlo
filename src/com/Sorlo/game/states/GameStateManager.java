package com.Sorlo.game.states;

import com.Sorlo.game.GamePanel;
import com.Sorlo.game.util.*;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import com.Sorlo.game.util.Audio;

public class GameStateManager {

    //private ArrayList<GameState> states;
    public static Vector2f map;
    public static Vector2f map2;

    public static Statement s;
    public static Statement s2;
    private GameState states[];
    public static Connection conexiune;
    public static final int PLAY=1;
    public static final int MENU=0;
    public static final int LEVEL2=2;
    public static final int MENU2=3;
    public static final int MUZICA=4;
    private int currentState;
    public Camera cam;
    public Camera cam2;
    private GameState menust;

    public static Graphics2D g;
    private static Vector <Audio> music;
    private static boolean VOLUME;


    /**
      * -creeaza conexiunea cu baza de date unde se vor salva sunetul ales din setari, daca acesta va fi schimbat in timpul jocului, nivelul
     *      * la care a ramas playerul sau daca atunci cand a fost in meniu, era deschis sau nu
     *      * initializeaza totodata mapa, camera si starea jocului cu care acesta va porni
     * @param g
     * @throws SQLException

     */
    public GameStateManager(Graphics2D g) throws SQLException {
        GameStateManager.g = g;

        Connection conexiune = null;
        s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexiune = DriverManager.getConnection("jdbc:sqlite:Joc.db");
            s = conexiune.createStatement();
            Table.createTable(s);
            Table.AddEntry(s,"/Songs/H.mp3",0,0,0,0);



        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        music = new Vector<>();
        music.add(new Audio(Table.SelectLast(s)));
        states = new GameState[6];


        //add(0);







        map = new Vector2f(GamePanel.width, GamePanel.height);

        cam = new Camera(new Coliziuni(new Vector2f(0, 0), GamePanel.width, GamePanel.height));
        VOLUME = true;
        Vector2f.setWorldVar(map.x, map.y);

        music.get(0).play();
        currentState=Table.SelectLastS(s);
        add(currentState);
    }

    /**
     *Face un nou PlayState atunci cand i se cere
     * @param state
     * @throws SQLException
     *
     */

    public void setState(int state) throws SQLException {
        states[state]=new PlayState(this, cam);
        currentState=PLAY;


    }
    /**
     *Face un nou Meniu atunci cand i se cere
     * @param state
     * @throws SQLException
     *
     */

    public void setStateMenu(int state) throws SQLException {
        states[state]=new MenuState(this);
        currentState=MENU;


    }
    /**
     *Face un nou Nivel2 atunci cand i se cere
     * @param state
     * @throws SQLException
     *
     */
    public void setNivel2(int state) throws SQLException {
        states[state]=new Level2PlayState(this, new Camera(new Coliziuni(new Vector2f(0, 0), GamePanel.width, GamePanel.height)));
        currentState=LEVEL2;

    }

    /**
     ** Initializeaza meniul pentru muzica
     * @param state
     * @throws SQLException

     */
    public void setStateMuzica(int state)

    {
        states[state]=new MeniuMuzica(this);
        currentState=MUZICA;
    }


    /**
     ** seteaza starea jocului daca ca parametru i se da state, un int
     *      * care stie daca starea va fi Play, Meniu, Muzica, Nivel1 sau Nivel2
     * @param state
     * @throws SQLException

     */
    public void add(int state) throws SQLException {

        if(state==PLAY)
        {

            cam = new Camera(new Coliziuni(new Vector2f(0, 0), GamePanel.width + 16, GamePanel.height + 16));
            PlayState p=new PlayState(this, cam);
            states[PLAY] = p;




        }
        else if (state == MENU) {
        states[MENU] = new MenuState(this);
    }
    else if (state == LEVEL2) {
        states[LEVEL2] = new Level2PlayState(this, cam2);
    }
    else if (state == MENU2) {
        states[MENU2] = new MenuState2(this);
    }
    else if(state==MUZICA)
        {
            states[MUZICA]=new MeniuMuzica(this);
        }

    }
    //public void addAndpop(int state) {
     //  addAndpop(state, 0);
   // }


    /**
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws SQLException
     *
     */
    public void update() throws InterruptedException, IOException, SQLException {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].update();
            }
        }

    }


    /**
     *Aceasta clasa permite apasarea mouse-ului si input-ul de la tastatura
     * @param mouse
     * @param key
     * @throws SQLException
     *
     */



    public void input(MouseHandler mouse, KeyHandler key) throws SQLException {
        for (int i = 0; i < states.length; i++) {
            if (states[i] != null) {
                states[i].input(mouse, key);
            }
        }
    }

    /**
     * pentru a afisa starile jocului pe ecran
     * @param g
     * @throws InterruptedException
     * @throws IOException
     */
    public void render(Graphics2D g) throws InterruptedException, IOException {
        for (int i = 0; i < 6; i++) {
            if (states[i] != null) {
                states[i].render(g);


            }

        }



    }
    public static Vector<Audio> getMusic (){ return music; }


    public static boolean getVOLUME () { return VOLUME; }
}
