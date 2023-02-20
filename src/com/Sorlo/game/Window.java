package com.Sorlo.game;
import com.Sorlo.game.states.GameStateManager;
import com.Sorlo.game.states.MenuState;

import javax.swing.JFrame;
public class Window extends JFrame {

    private static Window instance=null;

    /**
     * initializeaza fereastra pe care va rula jocul
     * fereastra se va inchide cand apasam pe x
     * lungimea va fi de 1280 si inaltimea de 432
     *
     *
     * Acesta este un Singleton care are ca specific constructorul privat care na va
     * permite sa cream o singura instanta pentru fereastra jocului
     */
    private Window()
    {
        setTitle("TheAlmightySorlo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280,432));
        setIgnoreRepaint(true);
        pack();///condenseaza fereastra la un JPanel
        setLocationRelativeTo(null);
        setVisible(true);///face ca cadrul sa apara pe ecran, daca nu il implementan obiectul va exista ca obiect in memorie, dar
        ///pe ecran nu va exista nicio imagine
        setResizable(false);///dimensiunea nu poate fi schimbata
    }
    public static Window getInstance(){
        if (instance == null){///daca instanta este nula, atunci va fi facuta una
            ///daca nu, nu se va intampla nimic deoarece Window este de tip Singleton si ne folosim
            ///o singura data de el
            instance = new Window();
        }
        return instance;
    }

}


